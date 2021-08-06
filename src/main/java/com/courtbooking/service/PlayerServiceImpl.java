package com.courtbooking.service;

import com.courtbooking.model.Player;
import com.courtbooking.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    PlayerRepo playerRepo;

    @Override
    public List<Player> getPlayerByEmailId(String email) throws Exception{
        return playerRepo.findByEmail(email);
    }

    @Override
    public Player savePlayer(Player player) throws Exception {
        return playerRepo.save(player);
    }
}
