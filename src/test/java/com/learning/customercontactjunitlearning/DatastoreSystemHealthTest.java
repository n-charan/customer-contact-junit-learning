package com.learning.customercontactjunitlearning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DatastoreSystemHealthTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void dbPrimaryIsOk() {
        try {
            DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
            String catalogName = dataSource.getConnection().getCatalog();

            assertNotNull(metaData);
            assertEquals("customer-contact-db", catalogName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
