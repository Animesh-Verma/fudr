package com.example.fudr.controller;

import com.example.fudr.base.BaseService;
import com.example.fudr.exception.AlreadyExistException;
import com.example.fudr.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private BaseService<Customer, Long> customerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        try {
            return ResponseEntity.ok(customerService.create(customer));
        } catch (AlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> read(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.read(id));
    }

    @PutMapping
    public ResponseEntity<Customer> update(Customer customer) {
        return ResponseEntity.ok(customerService.update(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok(new Customer());
    }
}
