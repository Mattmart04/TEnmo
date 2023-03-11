package com.techelevator.tenmo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@Data
public class Account {


    @Id
    @SequenceGenerator(name="account_seq",sequenceName="seq_account_id", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="account_seq")
    @NotNull(message = "AccountId Cannot be empty")
    int accountId;


    @NotNull
    @OneToOne
    @JoinColumn(nullable = false, name = "user_id")
    User user;


    @NotNull(message = "balance cannot be negative or empty")
    BigDecimal balance;


    public Account() {
    }


    public Account(int accountId) {
        this.accountId = accountId;
    }


    public Account(int accountId, User user) {
        this.accountId = accountId;
        this.user = user;
    }

    public Account(User user) {
        this.user = user;
        this.balance = new BigDecimal(1000);
    }

    public Account(int accountId, User user, BigDecimal balance) {
        this.accountId = accountId;
        this.user = user;
        this.balance = balance;
    }

    public Account(int accountId, int i, Long sutBalance) {
    }


    public int getAccountId() {
        return accountId;
    }


    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public BigDecimal getBalance() {
        return balance;
    }


    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public String getUsername(){return user.getUsername();}


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", user=" + user +
                ", balance=" + balance +
                '}';
    }



}