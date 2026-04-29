package com.springjpa.JPA;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springjpa.JPA.Repository.PlayerRepo;
import com.springjpa.JPA.model.Player;

@SpringBootTest
class JpaApplicationTests {
	@Autowired
	private PlayerRepo repository;

	@Test
	void testSavePlayer() {
		Player player = new Player();
		player.setId(1l);
		player.setName("Bate5a");
		player.setScore(2);
		repository.save(player);
		Player savedPlayer = repository.findById(1l).get();
		assertNotNull(savedPlayer);
	}

}
