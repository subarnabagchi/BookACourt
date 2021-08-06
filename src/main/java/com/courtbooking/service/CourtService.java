package com.courtbooking.service;

import com.courtbooking.model.Court;

import java.util.List;

public interface CourtService {

    List<Court> getAllCourts() throws Exception;
}
