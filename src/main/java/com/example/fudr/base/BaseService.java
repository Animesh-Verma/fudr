package com.example.fudr.base;

import com.example.fudr.exception.AlreadyExistException;

public interface BaseService<T,ID> {
    T create(T t) throws AlreadyExistException;
    T read(ID id);
    T update(T t);
    void delete(ID id);
}
