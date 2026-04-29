package com.springjpa.JPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.JPA.model.Player;

public interface PlayerRepo extends JpaRepository<Player, Long> {

}