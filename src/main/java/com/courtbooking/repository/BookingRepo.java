package com.courtbooking.repository;

import com.courtbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookingRepo")
public interface BookingRepo extends JpaRepository<Booking, Long> {

    List<Booking> findAll();
}
