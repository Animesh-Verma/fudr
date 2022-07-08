package com.example.fudr.service;

import com.example.fudr.base.BaseService;
import com.example.fudr.model.Customer;
import com.example.fudr.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements BaseService<Customer, Long> {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer read(Long aLong) {
        Optional<Customer> customer = customerRepository.findById(aLong);
        return customer.get();
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long aLong) {
        customerRepository.deleteById(aLong);
    }
}
