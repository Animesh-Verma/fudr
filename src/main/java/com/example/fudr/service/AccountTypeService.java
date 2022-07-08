package com.example.fudr.service;

import com.example.fudr.base.BaseService;
import com.example.fudr.exception.AlreadyExistException;
import com.example.fudr.model.AccountType;
import com.example.fudr.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountTypeService implements BaseService<AccountType,Integer> {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public AccountType create(AccountType accountType) throws AlreadyExistException {
        try {
            return accountTypeRepository.save(accountType);
        }catch (Exception e){
            throw new AlreadyExistException("Account Type already exist");
        }
    }

    @Override
    public AccountType read(Integer id) {
        Optional<AccountType> accountType = accountTypeRepository.findById(id);
        return accountType.get();
    }

    @Override
    public AccountType update(AccountType accountType) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        accountTypeRepository.deleteById(id);
    }
}
