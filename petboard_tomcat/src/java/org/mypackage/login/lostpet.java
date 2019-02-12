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


public class lostpet {
    private String user;
    private String species;
    private String description;
    //private String photo;
    private String contact;
    private String status;
    private float lat;
    private float lng;
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
      
    public float getLat() {
         return lat;
	}

      public void setLat(float lat) {
         this.lat = lat;
      }  
      
    public float getLng() {
         return lng;
	}

      public void setLng(float lng) {
         this.lng = lng;
      } 
      
      
    public String getAddress() {
         return address;
	}

      public void setAddress(String address) {
         this.address = address;
	}  
}
