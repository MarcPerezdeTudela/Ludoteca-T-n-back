package com.ccsw.tutorial.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.common.exception.AlreadyExistException;
import com.ccsw.tutorial.customer.model.CustomerDto;
import com.devonfw.module.beanmapping.common.api.BeanMapper;

/**
 * @author ccsw
 */
@RequestMapping(value = "/customer")
@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    BeanMapper beanMapper;

    /**
     * Método para recuperar todos los customer
     * 
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CustomerDto> findAll() {

        return this.beanMapper.mapList(this.customerService.findAll(), CustomerDto.class);
    }

    /**
     * Método para crear o actualizar un customer
     * 
     * @param id
     * @param dto
     * @return
     */
    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody CustomerDto dto)
            throws AlreadyExistException {

        this.customerService.save(id, dto);

    }

    /**
     * Método para borrar un customer
     * 
     * @param id
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.customerService.delete(id);
    }
}
