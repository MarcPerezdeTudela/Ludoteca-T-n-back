package com.ccsw.tutorial.customer;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.tutorial.customer.model.Customer;

/**
 * @author ccsw
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    boolean existsByName(String name);
}
