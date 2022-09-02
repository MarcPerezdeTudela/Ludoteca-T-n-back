package com.ccsw.tutorial.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.common.exception.AlreadyExistException;
import com.ccsw.tutorial.customer.model.Customer;
import com.ccsw.tutorial.customer.model.CustomerDto;

/**
 * @author ccsw
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Método para recuperar todos los Customer
     * 
     * @return
     */
    public List<Customer> findAll() {

        return (List<Customer>) customerRepository.findAll();
    }

    /**
     * Método para crear o actualizar un Customer
     * 
     * @param dto
     * @return
     */
    public void save(Long id, CustomerDto dto) throws AlreadyExistException {

        if (this.customerRepository.existsByName(dto.getName())) {
            throw new AlreadyExistException();
        }

        Customer customer = null;

        if (id == null) {
            customer = new Customer();
        } else {
            customer = this.customerRepository.findById(id).orElse(null);
        }
        customer.setName(dto.getName());

        this.customerRepository.save(customer);

    }

    /**
     * Método para borrar un Customer
     * 
     * @param id
     */
    public void delete(Long id) {

        this.customerRepository.deleteById(id);
    }
}
