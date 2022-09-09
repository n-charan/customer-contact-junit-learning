package com.learning.customercontactjunitlearning.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.learning.customercontactjunitlearning.model.CustomerContact;
import com.learning.customercontactjunitlearning.service.CustomerContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerContactController.class)
public class CustomerContactControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerContactService customerContactService;

    @InjectMocks
    private CustomerContactController customerContactController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContactHappyPath() throws Exception {
        CustomerContact mockCustomerContact = new CustomerContact();
        mockCustomerContact.setFirstName("Steve");
        mockCustomerContact.setLastName("Rogers");

        when(customerContactService.saveCustomerContact(any(CustomerContact.class))).thenReturn(mockCustomerContact);

        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Steve");
        aContact.setLastName("Rogers");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(aContact);

        mockMvc.perform(post("/contact/save", mockCustomerContact).contentType("application/json")
                        .content(requestJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testAddContactWhenServiceRuleNotSatisfied() throws Exception {
        when(customerContactService.saveCustomerContact(any(CustomerContact.class))).thenReturn(null);

        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Steve");
        aContact.setLastName("Rogers");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(aContact);

        mockMvc.perform(post("/contact/save").content("application/json").content(requestJson))
                .andExpect(status().is(302))
                .andReturn();
    }
}
