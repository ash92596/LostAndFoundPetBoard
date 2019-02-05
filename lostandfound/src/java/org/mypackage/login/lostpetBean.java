/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.login;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import org.mypackage.login.lostpet;
/**
 *
 * @author Connor
 */
//@ManagedBean(name = "lostpetBean")
//@SessionScoped
public class lostpetBean {
    
        // String db_url= "jdbc:derby://localhost:1527/users";
        // String db_username= "app";
      //  String db_password= "app";
    
    public static lostpet lpDAO(lostpet id) throws SQLException, IOException{
        
        lostpet lostpet =null;
        String db_url= "jdbc:derby://localhost:1527/users";
         String db_username= "app";
         String db_password= "app";
        
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        String username="Connor";
        String sql = "SELECT * FROM lostpets WHERE userid ='"
                        + username
                        + "'" ;
        try{
        
         
   
         conn = DriverManager.getConnection(db_url, db_username, db_password);
            
         ps= conn.prepareStatement(sql); 
         //ps.setString(1, id);
         rs= ps.executeQuery(); 
         
        if (rs.next()) {
               // lostpet = new lostpet();
                String user = rs.getString("userid");
                String descr = rs.getString("description");
                Blob blob = rs.getBlob("photo");
                
                 InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                
                 byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                 
                inputStream.close();
                outputStream.close();
                
                id.setUserid(user);
                id.setDescription(descr);
                id.setPhoto(base64Image);
        }
        }
        catch(SQLException | IOException ex){
        ex.printStackTrace();
            throw ex;
                }
        finally
    {
    try
    {
    conn.close();
    ps.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
  }   
        
        
    return lostpet;
    }
    
}
