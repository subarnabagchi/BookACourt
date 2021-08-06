package com.courtbooking.service;

import com.courtbooking.model.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getBookings() throws Exception;

    void createBooking(Booking booking) throws Exception;
}
