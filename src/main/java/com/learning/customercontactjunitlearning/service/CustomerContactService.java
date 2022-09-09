package com.learning.customercontactjunitlearning.service;

import com.learning.customercontactjunitlearning.model.CustomerContact;
import com.learning.customercontactjunitlearning.repository.CustomerContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactService {

    @Autowired
    private CustomerContactRepository customerContactRepository;

    public CustomerContact saveCustomerContact(CustomerContact customerContact) {
        CustomerContact savedContact = null;
        if (customerContact != null) {
            savedContact = customerContactRepository.save(customerContact);
        }
        return savedContact;
    }
}
