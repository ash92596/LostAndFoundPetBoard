/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Connor
 */
@WebServlet(name = "accountservlet", urlPatterns = {"/accountservlet"})
public class accountservlet extends HttpServlet {
     
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    //Servlet saves data in to database
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Store user input from index.jsp into variables
        String user = request.getParameter("userid");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String zipcode = request.getParameter("zipcode");
        
       
        
       String result =addrecord(user, email, password, zipcode);
                                                     
                
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sign Up: " + result + "</h1>");
            
            
            out.println("<input type=\"button\" value=\"Home\" name=\"Home\"\n" +
                           "onclick=\"openPage('welcome.jsp')\"/>");
            out.println("<script type=\"text/javascript\">\n" +
                        " function openPage(pageURL)\n" +
                        " {\n" +
                        " window.location.href = pageURL;\n" +
                        " }\n" +
                        "</script>");
            
            
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
   
    
    //Method used to connect and add data to database
    public String addrecord(String user, String mail, String pass, String zip) {
   
    
   String u =user;
   String e = mail;
   String p = pass;
   String z = zip;
    
    String records;
try{
   final String db_url= "jdbc:derby://localhost:1527/users";
   final String db_username= "app";
   final String db_password= "app";
   
   Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
   
   Statement stmt = conn.createStatement();
   
   String sql;     
   int rows;
    
    sql = "INSERT INTO accountinfo " 
    + "(userid, email, password, zipcode) "
    + "VALUES "
    + "('" + u   + "',"
    + "'" + e + "',"
    + "'" + p + "',"        
    + "'" + z + "')";
    
   rows = stmt.executeUpdate(sql);
   conn.commit();
   stmt.close();
   conn.close();
   
   records="Success";
}
  
catch(Exception ex){
records="Failed";
        
}
return records;
}
    
    
    
    
    
    
    
    
}
