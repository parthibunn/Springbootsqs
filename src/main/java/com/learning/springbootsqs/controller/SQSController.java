package com.learning.springbootsqs.controller;

import com.learning.springbootsqs.model.Employee;
import com.learning.springbootsqs.service.SQSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SQSController {

    @Autowired
    private SQSService sqsService;

    @GetMapping("postMessage/{msg}")
    public String postMessage(@PathVariable(value="msg") String msg) {
        sqsService.postMessage(msg);
        return msg;
    }

    @PostMapping("postEmployee")
    public String postEmployee(@RequestBody Employee employee) {
        sqsService.postEmployee(employee);
        return "success";
    }
}
