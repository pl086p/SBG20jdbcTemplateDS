package com.springboot;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@SpringBootApplication
public class SBdbApplication {
    
    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context = SpringApplication.run(SBdbApplication.class, args);

        DatabaseOperations databaseOperations = (DatabaseOperations) context
                .getBean("databaseOperations");

        databaseOperations.querytDatabaseTable();
        
        //databaseOperations.queryDatabaseView();
        SqlRowSet rs1 = databaseOperations.queryDatabaseView1();
      	rs1.last();
    	System.out.println("\n - queryDatabaseView1 getRow(): " + rs1.getRow());
        
 	
        System.out.println("\n - @Value(${spring.datasource.ur}): " + databaseOperations.getURL());

    }
}
