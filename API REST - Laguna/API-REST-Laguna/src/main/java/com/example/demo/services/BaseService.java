package com.example.demo.services;

import com.example.demo.entities.Base;
import org.hibernate.query.Page;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;
    //public Page<E> findALL(Pageable pageable) throws Exception;
    public E findById(ID id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(ID id, E entity) throws Exception;
    public boolean delete(ID id) throws Exception;
}
