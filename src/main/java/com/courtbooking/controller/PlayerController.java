package com.courtbooking.controller;

import com.courtbooking.model.Player;
import com.courtbooking.model.ResponseData;
import com.courtbooking.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    PlayerService playerService;

    @RequestMapping(method = RequestMethod.POST, value = "/addPlayer")
    public ResponseData addPlayer(@RequestParam(required = true) String firstName,
                                  @RequestParam(required = true) String lastName,
                                  @RequestParam(required = true) String email) {

        ResponseData responseData = new ResponseData();
        try {
            List<Player> players = playerService.getPlayerByEmailId(email);
            if(players.isEmpty()) {
                logger.info("New player is getting saved...");
                Player player = playerService.savePlayer(new Player(firstName, lastName, email));
                logger.info("Player is saved in DB with player id: "+player.getId());
                responseData.setMessage("Player has been added successfully.");
            } else {
                responseData.setMessage("Player record exists with email id: "+email);
                logger.info("Player record exists with email id: "+email);
            }
        } catch(Exception e) {
            logger.error("Error while adding the player..."+e.getMessage());
            responseData.setErrorMessage(e.getMessage());
        }
        return responseData;
    }

}
