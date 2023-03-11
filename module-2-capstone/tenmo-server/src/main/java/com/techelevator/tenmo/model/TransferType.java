package com.techelevator.tenmo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TransferType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transferTypeId;
    @NotNull
    private String transferTypeDesc;

    public TransferType(String transferTypeDesc) {
        this.transferTypeDesc = transferTypeDesc;
    }
}
