package com.example.gb.controller;

import com.example.gb.model.Router;
import com.example.gb.model.po.TransRecord;
import com.example.gb.service.TransRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransRecordController {

    private final TransRecordService transRecordService;

    @Autowired
    public TransRecordController(TransRecordService transRecordService) {
        this.transRecordService = transRecordService;
    }

    @GetMapping(Router.TransRecord.TRANS_RECORD)
    public List<TransRecord> getTransRecord(@RequestBody TransRecord transRecord) {
        return null;
    }

    @PostMapping(Router.TransRecord.TRANS_RECORD)
    public Boolean insertTransRecord(@RequestBody TransRecord transRecord) {
        return null;
    }

    @PutMapping(Router.TransRecord.TRANS_RECORD)
    public TransRecord updateTransRecord(@RequestBody TransRecord transRecord) {
        return null;
    }

    @DeleteMapping(Router.TransRecord.TRANS_RECORD)
    public Boolean deleteTransRecord(int id) {
        return null;
    }
}
