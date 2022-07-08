package com.example.fudr.util.idgen;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class TenDigitIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }
}
