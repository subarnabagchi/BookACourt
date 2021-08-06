package com.courtbooking.service;

import com.courtbooking.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayerByEmailId(String email) throws Exception;

    Player savePlayer(Player player) throws Exception;
}
