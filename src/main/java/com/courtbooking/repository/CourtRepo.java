package com.courtbooking.repository;

import com.courtbooking.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courtRepo")
public interface CourtRepo extends JpaRepository<Court, Long> {

    List<Court> findAll();
}
