package com.example.gb.controller;

import com.example.gb.model.Router;
import com.example.gb.model.po.BetRecord;
import com.example.gb.service.BetRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BetRecordController {

    private final BetRecordService betRecordService;

    @Autowired
    public BetRecordController(BetRecordService betRecordService) {
        this.betRecordService = betRecordService;
    }

    @GetMapping(Router.BetRecord.BET_RECORD)
    public List<BetRecord> getBetRecord(@RequestBody BetRecord betRecord) {
        return null;
    }

    @PostMapping(Router.BetRecord.BET_RECORD)
    public Boolean insertBetRecord(@RequestBody BetRecord betRecord) {
        return null;
    }

    @PutMapping(Router.BetRecord.BET_RECORD)
    public BetRecord updateBetRecord(@RequestBody BetRecord betRecord) {
        return null;
    }

    @DeleteMapping(Router.BetRecord.BET_RECORD)
    public Boolean deleteBetRecord(int id) {
        return null;
    }
}
