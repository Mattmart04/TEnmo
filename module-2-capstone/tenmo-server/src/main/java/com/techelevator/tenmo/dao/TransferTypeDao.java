package com.techelevator.tenmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techelevator.tenmo.model.TransferType;

public interface TransferTypeDao extends JpaRepository<TransferType, Integer> {
}