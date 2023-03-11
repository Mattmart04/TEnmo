package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Account {
    private int accountid;
    private int userid;

    public int getAccountid() {
        return accountid;
    }

    public Account(int accountid, int userid, BigDecimal balance) {
        this.accountid = accountid;
        this.userid = userid;
        this.balance = balance;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Account() {
    }

    private BigDecimal balance;

}
