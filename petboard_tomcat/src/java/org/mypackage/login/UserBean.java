/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.login;

/**
 *
 * @author Connor
 */

//Userbean stores values for the session works with servlet and UserDAO
public class UserBean {
    
      private String username;
      private String password;
      private String email;
      private String zipcode;
      public boolean valid;
	
	
      public String getEmail() {
         return email;
	}

      public void setEmail(String newemail) {
         email = newemail;
	}

	
      public String getZipcode() {
         return zipcode;
			}

      public void setZipcode(String newzipcode) {
         zipcode = newzipcode;
			}
			

      public String getPassword() {
         return password;
	}

      public void setPassword(String newPassword) {
         password = newPassword;
	}
	
			
      public String getUsername() {
         return username;
			}

      public void setUserName(String newUsername) {
         username = newUsername;
			}

				
      public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}	
    
    
        
}
