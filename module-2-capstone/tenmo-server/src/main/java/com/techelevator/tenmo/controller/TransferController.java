package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private TransferDao dao;

    public TransferController(TransferDao dao) {
        this.dao = dao;
    }

    @GetMapping
    private List<Transfer> findAll() {
        return dao.findAll();
    }

    @PostMapping("/{id}")
    public Transfer post(@RequestBody @Valid Transfer transfer, @PathVariable int id) {
        Transfer toUpdate = dao.getOne(id);
        toUpdate.setTransferType(transfer.getTransferType());
        toUpdate.setTransferStatus(transfer.getTransferStatus());
        toUpdate.setAccountFrom(transfer.getAccountFrom());
        toUpdate.setAccountTo(transfer.getAccountTo());
        toUpdate.setAmount(transfer.getAmount());
        return dao.save(toUpdate);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public Transfer put(@RequestBody @Valid Transfer transfer) {
        return dao.save(transfer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dao.delete(dao.getOne(id));
    }
}
