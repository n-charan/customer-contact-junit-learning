package com.learning.customercontactjunitlearning.repository;

import com.learning.customercontactjunitlearning.model.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerContactRepository extends JpaRepository<CustomerContact, Integer> {

    CustomerContact findByEmail(String email);
}
