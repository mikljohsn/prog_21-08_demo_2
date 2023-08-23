package com.example.prog_2108_demo_2.Repository;

import com.example.prog_2108_demo_2.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByName(String player);
    Player findByNameLike(String name);
}
