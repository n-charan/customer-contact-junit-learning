package com.learning.customercontactjunitlearning.service;

import com.learning.customercontactjunitlearning.model.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CustomerContactServiceIntegrationTest {

    @Autowired
    private CustomerContactService customerContactService;

    @Test
    public void testAddContactHappyPath() {
        CustomerContact customerContact = new CustomerContact();
        customerContact.setFirstName("Jenny");
        customerContact.setLastName("Johnson");
        customerContact.setEmail("jenny.johnson@testmail.com");

        CustomerContact newContact = customerContactService.saveCustomerContact(customerContact);

        assertNotNull(newContact);
        assertNotNull(newContact.getId());
        assertEquals(customerContact.getFirstName(), newContact.getFirstName());
    }
}
