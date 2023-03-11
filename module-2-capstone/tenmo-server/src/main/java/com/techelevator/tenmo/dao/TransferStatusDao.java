package com.techelevator.tenmo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techelevator.tenmo.model.TransferStatus;

public interface TransferStatusDao extends JpaRepository<TransferStatus, Integer> {
}
