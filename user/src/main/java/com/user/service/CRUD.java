package com.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CRUD<T, ID> {

    T register(T t);
    T update(T t);
    List<T> getAll();
    T getById(ID id);
    void delete(ID id);

}