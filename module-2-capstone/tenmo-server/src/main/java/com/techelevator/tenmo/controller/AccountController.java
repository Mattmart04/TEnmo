package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountRepository;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Principal;


/**
 * Controller To Handle Account Requests
 */


@RestController
@Controller
public class AccountController {


    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserDao userDao;


    //endpoint for MyAccount
    //Uses account repo to return the account where principal name is = to account username
    //returns principal users account
    @GetMapping("/MyAccount")
    public ResponseEntity<Account> getAccount(Principal principal) {
        try {
            Account myAccount = accountRepository.findAccountByUser(userDao.findByUsername(principal.getName()));
            if (myAccount == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(myAccount, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //returns my balance again using principal
    @GetMapping("/MyBalance")
    public ResponseEntity<BigDecimal> getMyBalance(Principal principal) {
        try {
            BigDecimal balance = accountRepository.findAccountByUser(userDao.findByUsername(principal.getName())).getBalance();
            if (balance == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(balance, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //accepts a URL parameter for UserID
    //returns corresponding account using account repo
    //note: does not include balance
    @GetMapping("/Account")  //"/AccountId?userId=1002
    public ResponseEntity<Account> getAccountFromUserId(@RequestParam int userId) {
        try {
            Account account = accountRepository.findAccountByUser(userDao.findByUserId(userId));
            if (account == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


