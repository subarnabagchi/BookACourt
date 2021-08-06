package com.courtbooking.controller;

import com.courtbooking.model.Booking;
import com.courtbooking.model.Court;
import com.courtbooking.model.ResponseData;
import com.courtbooking.service.BookingService;
import com.courtbooking.service.CourtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/court")
public class CourtBookingController {

    public static Map<String, Integer> occupiedCourtMap = new HashMap<>();

    Logger logger = LoggerFactory.getLogger(CourtBookingController.class);

    @Autowired
    BookingService bookingService;

    @Autowired
    CourtService courtService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public Object registerCourt(@RequestParam(required = true) long playerId,
                                @RequestParam(required = true) String bookingDate) {
        ResponseData responseData = new ResponseData();
        long courtId = 0;
        boolean flag = false;
        try {
            //Initial update of occupiedCourtMap
            if (occupiedCourtMap.isEmpty())
                updateOccupiedCourtMap();
            courtId = getAvailableCourtOnDate(bookingDate);
            if (courtId != 0) {
                Booking book = new Booking(courtId, playerId, bookingDate);
                bookingService.createBooking(book);
                flag = true;
                responseData.setMessage("Player has been registered successfully for court "
                        + courtId + " and date " + bookingDate);

            } else {
                responseData.setMessage("No slot is available in any of the courts on date "
                        + bookingDate);
            }
        } catch (Exception e) {
            logger.error("Error while registering for a court..." + e.getMessage());
            responseData.setErrorMessage(e.getMessage());
            if (flag)
                updateMapOnError(courtId, bookingDate);
        }
        return responseData;
    }

    private void updateMapOnError(long courtId, String bookingDate) {
        String key = bookingDate.concat("|").concat(String.valueOf(courtId));
        synchronized (occupiedCourtMap) {
            if (!occupiedCourtMap.containsKey(key)) {
                occupiedCourtMap.put(key, 0);
            }
            int counter = occupiedCourtMap.get(key);
            if (counter > 0)
                occupiedCourtMap.put(key, --counter);
        }
    }

    private void updateOccupiedCourtMap() {
        try {
            /* Create a static map with key as bookingDate|courtId
            and value as number of players booked the court for a date*/
            List<Booking> bookings = bookingService.getBookings();
            String bookingDate = null;
            String courtId = null;
            int counter = 0;
            String key = null;
            for (int i = 0; i < bookings.size(); i++) {
                Booking entry = bookings.get(i);
                bookingDate = entry.getBookingDate();
                courtId = String.valueOf(entry.getCourtId());
                key = bookingDate.concat("|").concat(courtId);
                if (!occupiedCourtMap.containsKey(key)) {
                    occupiedCourtMap.put(key, Integer.valueOf(0));
                }
                counter = occupiedCourtMap.get(key);
                occupiedCourtMap.put(key, ++counter);
                if (counter == 4) {
                    logger.info("The game is on...." + courtId);
                }
            }
        } catch (Exception e) {
            logger.error("Error in updateOccupiedCourtMap: " + e.getMessage());
        }
    }

    /*
    This method checks if any of the courts is available on the date,
    if multiple courts are available, then this method finds out the court which
    is maximum occupied (player count < 4). Then updates the map with
    new player count for the court before inserting the booking data into DB.
     */
    public long getAvailableCourtOnDate(String date) {
        long courtId = 0;
        try {
            List<Court> courts = courtService.getAllCourts();
            long maxOccupiedCourt = 0;
            String key = null;
            int counter = 0;
            synchronized (occupiedCourtMap) {
                for (Court c : courts) {
                    key = date.concat("|").concat(String.valueOf(c.getId()));
                    if (occupiedCourtMap.containsKey(key)) {
                        counter = occupiedCourtMap.get(key);
                        if (counter < 4) { //Slot available on the date in one of the courts
                            if (counter > maxOccupiedCourt) {
                                maxOccupiedCourt = counter;
                                courtId = c.getId();
                            }
                        }
                    } else {
                        //One court is not occupied on that date
                        if (courtId == 0) {
                            courtId = c.getId();
                        }
                    }
                }
                if(courtId != 0) {
                    key = date.concat("|").concat(String.valueOf(courtId));
                    if (!occupiedCourtMap.containsKey(key)) {
                        occupiedCourtMap.put(key, 0);
                    }
                    counter = occupiedCourtMap.get(key);
                    occupiedCourtMap.put(key, ++counter);
                    if (counter == 4) {
                        logger.info("The game is on...." + courtId);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in getAvailableCourtOnDate: " + e.getMessage());
        }
        return courtId;
    }

}
