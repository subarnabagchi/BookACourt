package com.courtbooking.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "court_id")
    long courtId;

    @Column(name = "player_id")
    long playerId;

    @Column(name = "booking_date")
    String bookingDate;

    public Booking() {
    }

    public Booking(long courtId, long playerId, String bookingDate) {
        this.courtId = courtId;
        this.playerId = playerId;
        this.bookingDate = bookingDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCourtId(long courtId) {
        this.courtId = courtId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public long getId() {
        return id;
    }

    public long getCourtId() {
        return courtId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public String getBookingDate() {
        return bookingDate;
    }
}
