package com.ccsw.tutorial.customer;

import com.ccsw.tutorial.common.exception.AlreadyExistException;
import com.ccsw.tutorial.customer.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CustomerIT {

    public static final String LOCALHOST = "http://localhost:";
    public static final String SERVICE_PATH = "/customer/";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    ParameterizedTypeReference<List<CustomerDto>> responseType = new ParameterizedTypeReference<List<CustomerDto>>() {
    };

    @Test
    public void findAllShouldReturnAllCategories() {

        ResponseEntity<List<CustomerDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH,
                HttpMethod.GET, null, responseType);

        assertNotNull(response);
        assertEquals(3, response.getBody().size());
    }

    public static final Long NEW_Customer_ID = 4L;
    public static final String NEW_Customer_NAME = "CAT4";

    @Test
    public void saveWithoutIdShouldCreateNewCustomer() {

        CustomerDto dto = new CustomerDto();
        dto.setName(NEW_Customer_NAME);

        restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.PUT, new HttpEntity<>(dto), Void.class);

        ResponseEntity<List<CustomerDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH,
                HttpMethod.GET, null, responseType);
        assertNotNull(response);
        assertEquals(4, response.getBody().size());

        CustomerDto CustomerSearch = response.getBody().stream().filter(item -> item.getId().equals(NEW_Customer_ID))
                .findFirst().orElse(null);
        assertNotNull(CustomerSearch);
        assertEquals(NEW_Customer_NAME, CustomerSearch.getName());
    }

    public static final Long MODIFY_Customer_ID = 3L;

    @Test
    public void modifyWithExistIdShouldModifyCustomer() {

        CustomerDto dto = new CustomerDto();
        dto.setName(NEW_Customer_NAME);

        restTemplate.exchange(LOCALHOST + port + SERVICE_PATH + MODIFY_Customer_ID, HttpMethod.PUT,
                new HttpEntity<>(dto), Void.class);

        ResponseEntity<List<CustomerDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH,
                HttpMethod.GET, null, responseType);
        assertNotNull(response);
        assertEquals(3, response.getBody().size());

        CustomerDto CustomerSearch = response.getBody().stream().filter(item -> item.getId().equals(MODIFY_Customer_ID))
                .findFirst().orElse(null);
        assertNotNull(CustomerSearch);
        assertEquals(NEW_Customer_NAME, CustomerSearch.getName());
    }

    public static final String ALREADY_SAVED_Customer_NAME = "John Doe";

    @Test
    public void saveExistsCustomerNameShouldThrowAlreadyExistException() throws AlreadyExistException {

        CustomerDto dto = new CustomerDto();
        dto.setName(ALREADY_SAVED_Customer_NAME);

        ResponseEntity<AlreadyExistException> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH,
                HttpMethod.PUT, new HttpEntity<>(dto), AlreadyExistException.class);

        assertNotNull(response);
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    public static final Long DELETE_Customer_ID = 2L;

    @Test
    public void deleteWithExistsIdShouldDeleteCustomer() {

        restTemplate.exchange(LOCALHOST + port + SERVICE_PATH + DELETE_Customer_ID, HttpMethod.DELETE, null,
                Void.class);

        ResponseEntity<List<CustomerDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH,
                HttpMethod.GET, null, responseType);
        assertNotNull(response);
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void deleteWithNotExistsIdShouldInternalError() {

        ResponseEntity<?> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH + NEW_Customer_ID,
                HttpMethod.DELETE, null, Void.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

}
