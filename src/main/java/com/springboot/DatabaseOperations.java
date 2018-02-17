package com.springboot;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class DatabaseOperations {
    
    @Value("${spring.datasource.url}")
    private String url;    

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void querytDatabaseTable() {
        String sql = "SELECT * FROM Product";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : list) {
            System.out.println(" -" + row.get("name"));
        }
    }

    public SqlRowSet queryDatabaseView() {
        String sql = "SELECT * from vw_product";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        return rs;
    }  
 
 
    public String getURL() {
        return url;
    }  
    
}
