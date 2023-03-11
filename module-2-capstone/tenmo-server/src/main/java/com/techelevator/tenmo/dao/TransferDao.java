package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TransferDao extends JpaRepository<Transfer, Integer> {
    List<Transfer> findAll();
}