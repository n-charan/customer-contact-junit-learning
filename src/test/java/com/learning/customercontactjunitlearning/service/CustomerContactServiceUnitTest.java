package com.learning.customercontactjunitlearning.service;

import com.learning.customercontactjunitlearning.model.CustomerContact;
import com.learning.customercontactjunitlearning.repository.CustomerContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CustomerContactServiceUnitTest {

    @Mock
    private CustomerContactRepository customerContactRepository;

    @InjectMocks
    private CustomerContactService customerContactService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContactHappyPath() {
        CustomerContact aMockContact = new CustomerContact();
        aMockContact.setFirstName("Test First Name");
        aMockContact.setLastName("Test Last Name");
        aMockContact.setEmail("test_email@testmail.com");

        when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);

        CustomerContact customerContact = customerContactService.saveCustomerContact(aMockContact);

        assertEquals("Test First Name", customerContact.getFirstName());
    }

    @Test
    public void testAddContactWhenDataIsNull() {
        CustomerContact aMockContact = new CustomerContact();
        aMockContact.setFirstName("Test First Name");
        aMockContact.setLastName("Test Last Name");
        aMockContact.setEmail("test_email@testmail.com");

        CustomerContact customerContact = customerContactService.saveCustomerContact(null);

        assertNull(customerContact);
    }
}
