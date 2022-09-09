package com.learning.customercontactjunitlearning.controller;

import com.learning.customercontactjunitlearning.model.CustomerContact;
import com.learning.customercontactjunitlearning.service.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(consumes = "application/json")
public class CustomerContactController {

    @Autowired
    private CustomerContactService customerContactService;

    @PostMapping(path = "/contact/save")
    @ResponseBody
    public String saveCustomerContact(@RequestBody CustomerContact customerContact) {
        String message = "success";
        CustomerContact savedCustomerContact = customerContactService.saveCustomerContact(customerContact);
        if (savedCustomerContact == null) {
            message = "failure";
        }
        return message;
    }
}
