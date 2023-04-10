package br.com.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
        public Connection getConnection(){
            
            try {
                
                return DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_sales","test","123");
                
            } catch (SQLException erro) {
               
                throw new RuntimeException(erro);
                
            }
            
            
        }
    
    
}