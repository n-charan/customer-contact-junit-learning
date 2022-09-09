package com.learning.customercontactjunitlearning;

import com.learning.customercontactjunitlearning.controller.CustomerContactControllerIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DatastoreSystemHealthTest.class,
        CustomerContactControllerIntegrationTest.class
})
public class ContinuousIntegrationTestSuite {
}
