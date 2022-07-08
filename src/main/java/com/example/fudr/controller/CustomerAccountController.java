package com.example.fudr.controller;

import com.example.fudr.exception.AlreadyExistException;
import com.example.fudr.model.CustomerAccount;
import com.example.fudr.service.CustomerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer-account")
public class CustomerAccountController {
    @Autowired
    private CustomerAccountService customerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CustomerAccount customerAccount) {
        try {
            return ResponseEntity.ok(customerService.create(customerAccount));
        } catch (AlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity<?> readAccountBalance(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(customerService.getBalance(id));
        } catch (UnsupportedOperationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
