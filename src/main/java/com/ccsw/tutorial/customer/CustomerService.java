package com.ccsw.tutorial.customer;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.ccsw.tutorial.common.exception.AlreadyExistException;
import com.ccsw.tutorial.customer.model.Customer;
import com.ccsw.tutorial.customer.model.CustomerDto;

/**
 * @author ccsw
 *
 */
public interface CustomerService {

    /**
     * Método para recuperar todos los Customer
     * 
     * @return
     */
    List<Customer> findAll();

    /**
     * Método para crear o actualizar un Customer
     * 
     * @param dto
     * @return
     */
    void save(Long id, CustomerDto dto) throws AlreadyExistException;

    /**
     * Método para borrar un Customer
     * 
     * @param id
     */
    void delete(Long id);
}
