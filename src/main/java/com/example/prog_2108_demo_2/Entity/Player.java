package com.example.prog_2108_demo_2.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter @Getter
@Entity
@Table(name ="spiller") //laver en tabel med navnet 'spiller'
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "player_name", length = 70, nullable = false) //sætter kolonnen 'name' i koden som player_name i databasen og længde på 70 og not null. Sætter parametre
    private String name;
    private String country;
    private String position;
    public  Player(String name, String country, String position) {
        this.name = name;
        this.country = country;
        this.position = position;
    }
}