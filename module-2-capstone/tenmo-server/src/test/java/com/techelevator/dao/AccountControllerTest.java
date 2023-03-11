package com.techelevator.dao;

import com.techelevator.tenmo.controller.AccountController;
import com.techelevator.tenmo.dao.AccountRepository;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
@SpringBootTest

public class AccountControllerTest {
    @MockBean
    private AccountRepository repository;

    @Autowired
    private AccountController controller;

    @Autowired
    private UserDao userDao;
    Long sutBalance = 10000L;
    Account newAccount = new Account(4,40,sutBalance);

    @Test
    public void created_repository_not_null(){
        Assert.assertNotNull(repository);
    } @Test
    public void created_controller_not_null(){
        Assert.assertNotNull(controller);
    } @Test
    public void created_service_not_null(){
        Assert.assertNotNull(userDao);
    }


}
