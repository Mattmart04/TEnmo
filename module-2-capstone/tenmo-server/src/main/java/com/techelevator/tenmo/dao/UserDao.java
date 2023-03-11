package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDao extends JpaRepository<User, Long> {

     User findByUsername(String username);
     User findByUserId(int id);
}
