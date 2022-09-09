package com.learning.customercontactjunitlearning;

import com.learning.customercontactjunitlearning.controller.CustomerContactController;
import com.learning.customercontactjunitlearning.controller.CustomerContactControllerIntegrationTest;
import com.learning.customercontactjunitlearning.model.CustomerContact;
import com.learning.customercontactjunitlearning.repository.CustomerContactRepository;
import com.learning.customercontactjunitlearning.repository.CustomerContactRepositoryIntergrationTest;
import com.learning.customercontactjunitlearning.service.CustomerContactServiceIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CustomerContactServiceIntegrationTest.class,
        CustomerContactControllerIntegrationTest.class,
        CustomerContactRepositoryIntergrationTest.class
})
public class AddCustomerContactFeatureTestSuite {
}
