package com.techelevator.tenmo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TransferStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transferStatusId;
    @NotNull
    private String transferStatusDesc;

    public TransferStatus(String transferStatusDesc) {
        this.transferStatusDesc = transferStatusDesc;
    }
}
