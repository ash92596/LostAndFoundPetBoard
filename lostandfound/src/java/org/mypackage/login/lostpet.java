/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author Connor
 */
@ManagedBean(name="lostpet")
@RequestScoped
public class lostpet {
    private String user;
    private String species;
    private String description;
    private String photo;
    private String contact;
    private String status;
    
    
  
         
           
    public String getUserid() {
         return user;
	}

      public void setUserid(String user) {
         this.user = user;
	}
    
       public String getDescription() {
         return user;
	}

      public void setDescription(String description) {
         this.description = description;
	}
            
                
      
      public String getPhoto() {
         return photo;
	}

      public void setPhoto(String photo) {
         this.photo = photo;
	}
      
    
}
