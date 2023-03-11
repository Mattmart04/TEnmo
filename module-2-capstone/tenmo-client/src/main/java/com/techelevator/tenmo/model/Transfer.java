package com.techelevator.tenmo.model;

public class Transfer {

    private int transferId;

    private TransferType transferType;

    private TransferStatus transferStatus;

    private int accountFrom;

    private int accountTo;

    private double amount;

    public Transfer(int transferId, TransferType transferType, TransferStatus transferStatus, int accountFrom, int accountTo, double amount) {
        this.transferId = transferId;
        this.transferType = transferType;
        this.transferStatus = transferStatus;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public Transfer() {
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public TransferStatus getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(TransferStatus transferStatus) {
        this.transferStatus = transferStatus;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Transfer(TransferType transferType, TransferStatus transferStatus, int accountFrom, int accountTo, double amount) {
        this.transferType = transferType;
        this.transferStatus = transferStatus;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }
}
