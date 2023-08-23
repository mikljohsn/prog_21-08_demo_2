package com.example.prog_2108_demo_2.API;

import com.example.prog_2108_demo_2.Entity.Player;
import com.example.prog_2108_demo_2.Repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    List<Player> getPlayers() {
        return  playerRepository.findAll();
    }
}

