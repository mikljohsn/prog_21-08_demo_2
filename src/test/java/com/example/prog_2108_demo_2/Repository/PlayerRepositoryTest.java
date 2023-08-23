package com.example.prog_2108_demo_2.Repository;

import com.example.prog_2108_demo_2.Entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest //annotation så testen kun bruger in memory database, H2
    //testen siger der er 0, fordi den kun bruger test dataen. Den bruger ikke vores ApplicationRunner, så det er ikke tilføjet til vores h2
    //gør den transaktionel, ruller databasen til som den var inden
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;
    boolean isInitialzied = false;

    @BeforeEach //annotation der gør, at den kører denne metode før hver test
    void setUp() {
        if(!isInitialzied) {
            playerRepository.deleteAll();
            playerRepository.save(new Player("Lionel Messi","C1","P1"));
            playerRepository.save(new Player("P2","C2","P2"));
            isInitialzied = true;
        }
    }
    @Test
    public void deleteAll(){
        playerRepository.deleteAll();
        assertEquals(0,playerRepository.count());
    }

    @Test
    public void testAll(){
      Long count = playerRepository.count(); //læs hvor mange der er i mit repository. Brug count, da det mindsker redundant data. FindAll får ALT tilbage.
      assertEquals(2,count);
    }
    @Test
    public void findByName(){
        Player p1 = playerRepository.findByName("P2");
        assertEquals("P2", p1.getName());

    }
    @Test
    public void findByNameLike(){
        Player p1 = playerRepository.findByNameLike("%Messi%");
        assertEquals("Lionel Messi", p1.getName());

    }
}