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
@WebServlet(name = "lostpetservlet", urlPatterns = {"/lostpetservlet"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class lostpetservlet extends HttpServlet {

    
    final String dbURL = "jdbc:derby://localhost:1527/users";
    final String dbUser = "app";
    final String dbPass = "app";
    
    
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
        double lat = Double.parseDouble(request.getParameter("latposition"));
        double lng = Double.parseDouble(request.getParameter("lngposition"));
                
                
                
        InputStream inputStream = null; // input stream of the upload file
        
        Part filePart = request.getPart("photo");
        
        if (filePart != null) {
        
        inputStream = filePart.getInputStream();
        
        }
        
        
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
        
        
        try{
        
         conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        
         String sql = "INSERT INTO lostpets (userid, species, description, photo, contact, status, lat, lng) values (?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement statement = conn.prepareStatement(sql);
         statement.setString(1, user);
         statement.setString(2, species);
         statement.setString(3, description);
         statement.setString(5, contact);
         statement.setString(6, status);
         statement.setDouble(7, lat);
         statement.setDouble(8, lng);
         
         
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
        
        catch(SQLException ex){
        message="Post Failed";
                }
        
                    
              
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lost Pet Submission</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+message+ "</h1>");
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
