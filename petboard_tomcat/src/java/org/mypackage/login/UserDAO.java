/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.login;
import java.sql.*;
/**
 *
 * @author Connor
 */

//DAO validates for correct user and password then pulls remaining data from the table, stores in userbean
public class UserDAO {
    
     static ResultSet rs = null;  
     static Connection conn=null;
     public static UserBean login(UserBean bean) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
	
         String username = bean.getUsername();    
         String password = bean.getPassword();   
	    
         String searchQuery =
               "select * from accountinfo where userid='"
                        + username
                        + "' AND password='"
                        + password
                        + "'";
    
          try 
      {
         //connect to DB 
         //final String db_url= "jdbc:derby://localhost:1527/users";
        // final String db_username= "app";
       //  final String db_password= "app";
          
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String hostName = "cburroughs.database.windows.net"; // update me
        String dbName = "petboard"; // update me
        String us = "cburroughs"; // update me
        String pass = "Jilsog12God!"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, us, pass);
   
         conn = DriverManager.getConnection(url);
          
          
         stmt=conn.createStatement();
         rs = stmt.executeQuery(searchQuery);	        
         boolean more = rs.next();
	       
         // if user does not exist set the isValid variable to false
         if (!more) 
         {
           
            bean.setValid(false);
         } 
	        
         //if user exists set the isValid variable to true
         else if (more) 
         {
            String e = rs.getString("email");
            String z = rs.getString("zipcode");
	     	
            
            bean.setEmail(e);
            bean.setZipcode(z);
            bean.setValid(true);
         }
      } 

      catch (Exception ex) 
      {
        
      } 
         
         
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (conn!= null) {
            try {
               conn.close();
            } catch (Exception e) {
            }

            conn = null;
         }
      }
          
          
              
         
         return bean;
         
     }
    
    
       
    
}
