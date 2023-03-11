package com.techelevator.tenmo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.techelevator.tenmo.model.TransferType;
import com.techelevator.tenmo.model.TransferStatus;
import javax.validation.constraints.Positive;


@Entity
public class Transfer {
    @Id
    @SequenceGenerator(name="transfer_sequence", sequenceName="seq_transfer_id", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transfer_sequence")
    private int transferId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "transferTypeId")
    private TransferType transferType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "transferStatusId")
    private TransferStatus transferStatus;
    @NotNull
    @OneToOne
    @JoinColumn(nullable = false, name="accountFrom")
    private int accountFrom;

    @NotNull
    @OneToOne
    @JoinColumn(nullable = false, name="accountTo" )
    private int accountTo;

    @Positive
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
