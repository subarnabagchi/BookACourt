package com.courtbooking.service;

import com.courtbooking.model.Court;
import com.courtbooking.repository.CourtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courtService")
public class CourtServiceImpl implements CourtService{

    @Autowired
    CourtRepo courtRepo;

    @Override
    public List<Court> getAllCourts() throws Exception {
        return courtRepo.findAll();
    }
}
