package com.techelevator.tenmo.model;

public class TransferType {
    private int transferTypeId;
    private String transferTypeDesc;

    public TransferType(String transferTypeDesc) {
        this.transferTypeDesc = transferTypeDesc;
    }

    public TransferType(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public int getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public String getTransferTypeDesc() {
        return transferTypeDesc;
    }

    public void setTransferTypeDesc(String transferTypeDesc) {
        this.transferTypeDesc = transferTypeDesc;
    }

    public TransferType() {
    }

    @Override
    public String toString() {
        return "TransferType{" +
                "transferTypeId=" + transferTypeId +
                ", transferTypeDesc='" + transferTypeDesc + '\'' +
                '}';
    }
}
