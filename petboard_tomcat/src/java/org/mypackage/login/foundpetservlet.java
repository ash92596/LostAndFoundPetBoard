/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.login;

import java.io.InputStream;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Connor
 */
@WebServlet(name = "foundpetservlet", urlPatterns = {"/foundpetservlet"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class foundpetservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Stores user data into database
        String user = request.getParameter("userid");
        String species = request.getParameter("species");
        String description = request.getParameter("description");
        String contact = request.getParameter("contact");
        String status = request.getParameter("status");
        float lat = Float.parseFloat(request.getParameter("latposition"));
        float lng = Float.parseFloat(request.getParameter("lngposition"));
        String address = request.getParameter("area");
                
                
        InputStream inputStream = null; // input stream of the upload file
        
        Part filePart = request.getPart("photo");
        
        if (filePart != null) {
        
        inputStream = filePart.getInputStream();
        
        }
        
        
         Connection conn; // connection to the database
        String message = null;  // message will be sent back to client
        
        
        try{
            
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String hostName = "cburroughs.database.windows.net"; // update me
        String dbName = "petboard"; // update me
        String us = "cburroughs"; // update me
        String pass = "Jilsog12God!"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, us, pass);
        
         conn = DriverManager.getConnection(url);
        
         String sql = "INSERT INTO foundpets (userid, species, description, photo, contact, status, lat, lng, address) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement statement = conn.prepareStatement(sql);
         statement.setString(1, user);
         statement.setString(2, species);
         statement.setString(3, description);
         statement.setString(5, contact);
         statement.setString(6, status);
         statement.setFloat(7, lat);
         statement.setFloat(8, lng);
         statement.setString(9, address);
         
         if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(4, inputStream);
            }
        int row = statement.executeUpdate();
            if (row > 0) {
                message = "Post was Successful!";
            }
            conn.commit();
            statement.close();
            conn.close();
            
            
          }
        
        catch(Exception ex){
        message="Post Failed";
                }
        
        
        
        
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
             
            String myvar =
        "<div class=\"wrapper\">"+
            "<div class=\"container\">"+
                "<div class=\"col-md-6 col-md-offset-3\">"+
                    "<div class=\"form\">"+
                            "<div class=\"input-container sign-up a\">"+
                                "<h2>Status: "+ message+"</h2>"+
                                "<p>Click on the button below to go to the Home Page.</p>"+      
                                "<a href=\"welcome.jsp\">"+ "<button class=\"homepage-btn\" value=\"OK\" type=\"submit\" >Home</button>" + "</a>" +               
                            "</div>  " +
                    "</div>"+
                "</div>"+
            "</div>"+
        "</div>";
            
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css'>");
            out.println("<link rel=\"stylesheet\" href=\"indexstyle.css\">");
            out.println("<title>Post created</title>");   
            out.println("</head>");
            out.println("<body>");
            out.println(myvar);
            
            out.println("</body>");
            out.println("</html>");   
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
