package com.learning.customercontactjunitlearning.repository;

import com.learning.customercontactjunitlearning.model.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerContactRepositoryIntergrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Test
    public void testFindByEmail() {
        CustomerContact contact = new CustomerContact();
        contact.setFirstName("Tony");
        contact.setLastName("Stark");
        contact.setEmail("tony.stark@testmail.com");

        entityManager.persist(contact);

        CustomerContact customerContact = customerContactRepository.findByEmail("tony.stark@testmail.com");

        assertEquals("tony.stark@testmail.com", customerContact.getEmail());
        assertEquals("Tony", customerContact.getFirstName());
    }
}
