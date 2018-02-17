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

        
        System.out.println("\n - queryDatabaseTable() \n");
        databaseOperations.querytDatabaseTable();
        
        SqlRowSet rs = databaseOperations.queryDatabaseView();
      	rs.last();
    	System.out.println("\n - queryDatabaseView()   rowcount = " + rs.getRow() + "\n");
        
 	
        System.out.println("\n\n - @Value(${spring.datasource.ur}): " + databaseOperations.getURL());

    }
}
