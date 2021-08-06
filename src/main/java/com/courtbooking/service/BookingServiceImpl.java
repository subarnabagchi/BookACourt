package com.courtbooking.service;

import com.courtbooking.model.Booking;
import com.courtbooking.repository.BookingRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

    Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    BookingRepo bookingRepo;

    @Override
    public List<Booking> getBookings() throws Exception {
        return bookingRepo.findAll();
    }

    @Override
    public void createBooking(Booking booking) throws Exception {
        booking = bookingRepo.save(booking);
        logger.info("New booking has been created with booking id: "+booking.getId()
                + " for court Id: " + booking.getCourtId());
    }

}
