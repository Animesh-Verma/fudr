package com.example.fudr.repository;

import com.example.fudr.model.CustomerAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Long> {
    @Query("select case when count(0)>0 then true else false end from CustomerAccount ca where customer_id=:cid and account_type_id=:atid")
    boolean existsAccountTypeAndCustomer(@Param("cid") Long cid , @Param("atid") Integer atid);

}
