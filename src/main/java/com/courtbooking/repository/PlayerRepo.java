package com.courtbooking.repository;

import com.courtbooking.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("playerRepo")
public interface PlayerRepo extends JpaRepository<Player, Long> {

    List<Player> findByEmail(String email);

}
