package com.example.fudr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class AccountType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String accountType;

    @OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerAccount> customerAccountList = new ArrayList<>();

    public AccountType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @JsonIgnore
    @JsonManagedReference(value = "account-type")
    public List<CustomerAccount> getCustomerAccountList() {
        return customerAccountList;
    }

    public void setCustomerAccountList(List<CustomerAccount> customerAccountList) {
        this.customerAccountList = customerAccountList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType accountType = (AccountType) o;
        return Objects.equals(id, accountType.id) &&
                this.accountType == accountType.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountType);
    }

}
