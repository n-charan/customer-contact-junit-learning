package com.learning.customercontactjunitlearning.controller;

import com.learning.customercontactjunitlearning.model.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerContactControllerIntegrationTest {

    @Autowired
    private CustomerContactController customerContactController;

    @Test
    public void testAddContactHappyPath() {
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Bruce");
        aContact.setLastName("Banner");
        aContact.setEmail("bruce.banner@testmail.com");

        String outCome = customerContactController.saveCustomerContact(aContact);

        assertThat(outCome, is(equalTo("success")));
    }
}
