package com.ccsw.tutorial.customer;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ccsw.tutorial.common.exception.AlreadyExistException;
import com.ccsw.tutorial.customer.model.Customer;
import com.ccsw.tutorial.customer.model.CustomerDto;

/**
 * @author ccsw
 */
@ExtendWith(MockitoExtension.class)
public class CustomerTest {

    public static final String Customer_NAME = "New Name";
    public static final String Customer_EXISTING_NAME = "John Doe";

    @Mock
    private CustomerRepository CustomerRepository;

    @InjectMocks
    private CustomerServiceImpl CustomerService;

    @Test
    public void findAllShouldReturnAllCategories() {

        List<Customer> list = new ArrayList<>();
        list.add(mock(Customer.class));

        when(CustomerRepository.findAll()).thenReturn(list);

        List<Customer> categories = CustomerService.findAll();

        assertNotNull(categories);
        assertEquals(1, categories.size());
    }

    @Test
    public void saveNotExistsCustomerIdShouldInsert() throws AlreadyExistException {

        CustomerDto CustomerDto = new CustomerDto();
        CustomerDto.setName(Customer_NAME);

        ArgumentCaptor<Customer> Customer = ArgumentCaptor.forClass(Customer.class);

        CustomerService.save(null, CustomerDto);

        verify(CustomerRepository).save(Customer.capture());

        assertEquals(Customer_NAME, Customer.getValue().getName());
    }

    public static final Long EXISTS_Customer_ID = 1L;

    @Test
    public void saveExistsCustomerIdShouldUpdate() throws AlreadyExistException {

        CustomerDto CustomerDto = new CustomerDto();
        CustomerDto.setName(Customer_NAME);

        Customer Customer = mock(Customer.class);
        when(CustomerRepository.findById(EXISTS_Customer_ID)).thenReturn(Optional.of(Customer));

        CustomerService.save(EXISTS_Customer_ID, CustomerDto);

        verify(CustomerRepository).save(Customer);
    }

    @Test
    public void saveExistsCustomerNameShouldThrowAlreadyExistException() throws AlreadyExistException {

        CustomerDto CustomerDto = new CustomerDto();
        CustomerDto.setName(Customer_EXISTING_NAME);

        when(CustomerRepository.existsByName(Customer_EXISTING_NAME)).thenReturn(true);
        assertThrows(AlreadyExistException.class, () -> CustomerService.save(null, CustomerDto));
    }

    @Test
    public void deleteExistsCustomerIdShouldDelete() {

        CustomerService.delete(EXISTS_Customer_ID);

        verify(CustomerRepository).deleteById(EXISTS_Customer_ID);
    }

}
