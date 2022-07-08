package com.example.fudr.controller;

import com.example.fudr.base.BaseService;
import com.example.fudr.exception.AlreadyExistException;
import com.example.fudr.model.AccountType;
import com.example.fudr.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account-type")
public class AccountTypeController {
    @Autowired
    private BaseService<AccountType, Integer> accountTypeService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountType accountType) {
        try {
            return ResponseEntity.ok(accountTypeService.create(accountType));
        } catch (AlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<AccountType> read(Integer id) {
        return ResponseEntity.ok(accountTypeService.read(id));
    }

//    @DeleteMapping("/{id}")
//    public AccountType delete(@PathVariable Integer id){
//        accountTypeService.delete(id);
//        return new AccountType();
//    }
}
