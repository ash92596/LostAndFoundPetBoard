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
    //private String photo;
    private String contact;
    private String status;
    private double lat;
    private double lng;
    private String address; 
  
         
           
    public String getUserid() {
         return user;
	}

      public void setUserid(String user) {
         this.user = user;
	}
    
    public String getSpecies() {
         return species;
	}

      public void setSpecies(String species) {
         this.species = species;  
      
      }
       public String getDescription() {
         return description;
	}

      public void setDescription(String description) {
         this.description = description;
	}
            
                
      public String getContact() {
         return contact;
	}

      public void setContact(String contact) {
         this.contact = contact;
	}
    
    public String getStatus() {
         return status;
	}

      public void setStatus(String status) {
         this.status = status;
      }
      
    public double getLat() {
         return lat;
	}

      public void setLat(double lat) {
         this.lat = lat;
      }  
      
    public double getLng() {
         return lng;
	}

      public void setLng(double lng) {
         this.lng = lng;
      } 
      
      
    public String getAddress() {
         return address;
	}

      public void setAddress(String address) {
         this.address = address;
	}  
}
