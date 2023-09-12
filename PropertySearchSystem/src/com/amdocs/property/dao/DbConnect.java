package com.amdocs.property.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
   
    	public static void main(String[] args) {
   		 String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl"; 
   	        String username = "system";
   	        String password = "Amdocs1!";

   	        try {
   	            // Load Oracle JDBC Driver
   	            Class.forName("oracle.jdbc.driver.OracleDriver");

   	            // Create a connection to the database
   	            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

   	            if (connection != null) {
   	                System.out.println("Connection to Oracle SQL Developer Success!");
   	                // You can perform database operations here
   	                
   	                Statement smt=connection.createStatement();
//   	              create table
//   	              smt.executeUpdate("create table MyProperties4(propId number, numberOfRooms varchar(12), areaInSqft number, floorNumber number, city varchar(20), state varchar(20), cost number, ownerName varchar(30), ownerNumber number)");
//   	              System.out.println("Table created!");	

   	                connection.close();
   	            } else {
   	                System.out.println("Failed to connect to Oracle SQL Developer!");
   	            }
   	        } catch (ClassNotFoundException e) {
   	            System.out.println("Oracle JDBC Driver not found.");
   	            e.printStackTrace();
   	        } catch (SQLException e) {
   	            System.out.println("Connection to Oracle SQL Developer failed.");
   	            e.printStackTrace();
   	        }
   			
   		}
}

