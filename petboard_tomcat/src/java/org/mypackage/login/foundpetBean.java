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
public class foundpetBean {
    
    static  Connection conn = null;
    static  ResultSet rs = null;
    
     public static lostpet fpDAO(lostpet id){
     
      String area = id.getAddress();
        Statement ps = null;
        //Connection conn = null;
       // ResultSet rs = null;
        
        String sql = "SELECT * FROM foundpets WHERE address ='"
                        + area
                        + "'" ;
        try{
        
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String hostName = "cburroughs.database.windows.net"; // update me
        String dbName = "petboard"; // update me
        String us = "cburroughs"; // update me
        String pass = "Jilsog12God!"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, us, pass);
   
         conn = DriverManager.getConnection(url);
         ps=conn.createStatement();
         rs = ps.executeQuery(sql);   
         //ps= conn.prepareStatement(sql); 
         //ps.setString(1, id);
         //rs= ps.executeQuery(); 
         
        if (rs.next()) {
               // lostpet = new lostpet();
                String user = rs.getString("userid");
                String spec = rs.getString("species");
                String descr = rs.getString("description");
                String contact = rs.getString("contact");
                String status = rs.getString("status");
                float lat = rs.getFloat("lat");
                float lng = rs.getFloat("lng");
                String ad = rs.getString("address");
               // Blob blob = rs.getBlob("photo");
                
                /* InputStream inputStream = blob.getBinaryStream();
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
                */
                id.setUserid(user);
                id.setSpecies(spec);
                id.setDescription(descr);
                id.setContact(contact);
                id.setStatus(status);
                id.setLat(lat);
                id.setLng(lng);
                id.setAddress(ad);
        }
        }
        catch(Exception ex){
       
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
        
        
    return id;
     
     
     
     
     
     
     
     
     
     
     
     
     }
    
}
