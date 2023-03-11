package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;


public interface AccountRepository extends JpaRepository<Account, Integer> {


//    @Query(value="SElECT * from account join tenmo_user using(user_id) WHERE username = ?1", nativeQuery = true)
//    Account findAccountByUsername(String username);


    //@Query(value="SElECT * from account WHERE user_id = ?1", nativeQuery = true)
    Account findAccountByUser(User userId);


    @Query(value="SElECT balance from account WHERE account_id = ?1", nativeQuery = true)
    BigDecimal findBalanceByAccountId(int accountId);


    @Modifying
    @Query(value = "UPDATE account SET balance = ?1 WHERE account_id = ?2 ;", nativeQuery = true)
    void changeAmount(long amount, int id);




}
