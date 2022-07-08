package com.example.fudr.service;

import com.example.fudr.base.BaseService;
import com.example.fudr.exception.AlreadyExistException;
import com.example.fudr.model.AccountType;
import com.example.fudr.model.Customer;
import com.example.fudr.model.CustomerAccount;
import com.example.fudr.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class CustomerAccountService implements BaseService<CustomerAccount, Long> {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountTypeService accountTypeService;

    @Override
    public CustomerAccount create(CustomerAccount customerAccount) throws AlreadyExistException {
        Long customerId = customerAccount.getCustomer().getId();
        Integer accountTypeId = customerAccount.getAccountType().getId();
        boolean isExist = customerAccountRepository.existsAccountTypeAndCustomer(customerId,accountTypeId);
        if(!isExist) {
            System.out.println(customerAccount.getCustomer().getId());
            Customer customer = customerService.read(customerId);
            AccountType accountType = accountTypeService.read(accountTypeId);
            customerAccount.setCustomer(customer);
            customerAccount.setAccountType(accountType);
            return customerAccountRepository.save(customerAccount);
        }
       throw new AlreadyExistException("Customer with Account type Already exist");
    }

    @Override
    public CustomerAccount read(Long id) {
        return null;
    }

    @Override
    public CustomerAccount update(CustomerAccount customerAccount) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public Float getBalance(Long id) throws UnsupportedOperationException{
       CustomerAccount customerAccount =  customerAccountRepository.findById(id).get();
       if(customerAccount.getAccountType().getAccountType().equals("LOAN")){
           throw new UnsupportedOperationException("Loan Account is Unsupported ! Try Again");
       }
       return customerAccount.getBalance();
    }
}
