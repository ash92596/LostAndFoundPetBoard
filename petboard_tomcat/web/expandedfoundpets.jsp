﻿<%-- 
    Document   : expandedfoundpets
    Created on : Jan 30, 2019, 5:54:19 PM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-16"%>
<%@page import ="org.mypackage.login.expandfoundservlet" %>
<%@page import ="org.mypackage.login.lostpet" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="image/jpg; charset=UTF-8">
        <title>Expand</title>
        
        <style>
          #map {
             height: 50%;
        width:  50%;
        margin-left:auto;
        margin-right:auto;
        }
       
        </style>
        
    </head>
    
    
    <body>
        
        <img src="foundimage.jsp" width="240" height="300"/>
              
        <div align="center">
             <% lostpet lp = (lostpet) session.getAttribute("lostinfo"); %>         
             
             <input type="hidden" name="lat" value="<%= Float.toString(lp.getLat()) %>" id="lat" />
             <input type="hidden" name="lng" value="<%= Float.toString(lp.getLng()) %>" id="lng" />
             
             <ul>
             <li><%= lp.getUserid()%></li>
             <li><%= lp.getSpecies()%></li>
             <li><%= lp.getDescription()%></li>
             <li><%= lp.getContact()%></li>
             <li><%= lp.getStatus()%></li>
             <li><%= lp.getAddress() %></li>
             <li>Flag post as inappropriate <input type="checkbox" name="flag" value="Flag" /></li>
             </ul>
             
        </div>
        
             <div id="m" style="width: 100%; height: 100%; position: absolute;">
                 
                <div id="map"></div>  
             </div>  
             
        <script>
           
               
                
                 // Initialize and add the map
                 function initMap() {
                var  L = document.getElementById("lat").value;
                var  G = document.getElementById("lng").value;
                var lt = parseFloat(L);
                var lg = parseFloat(G);
                
                var  myLatLng = new google.maps.LatLng({lat: lt, lng: lg});
                 
                  // The map, centered at Uluru
                  var map = new google.maps.Map(
                  document.getElementById('map'), {
                     center: myLatLng, 
                     zoom: 18 
              });
                  
                  var marker = new google.maps.Marker({position: myLatLng, map: map});
}                 
            
        </script>  
        
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDkYfkn-x3aD_jJWJwa_81AnA3Qz-d-TcU&callback=initMap"
    async defer></script>
        
    </body>
    
    
</html>
