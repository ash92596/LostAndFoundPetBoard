<%-- 
    Document   : postlost
    Created on : Jan 29, 2019, 11:22:36 AM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.login.UserBean"%> 
<%@page import ="org.mypackage.login.loginservlet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lost Pet</title>
        
        <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 50%;
        width:  50%;
        margin-left:auto;
        margin-right:auto;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      
      .center{
          text-align: center;
          
      }
    </style>
        
        
    </head>
    <body>
        <h1>Lost Pet Info</h1>
        <%UserBean currentUser = (UserBean) session.getAttribute("SessionUser");%>
        
        
        <form id="info" method="post" action="lostpetservlet"  enctype="multipart/form-data">
            UserID:
            <input type="text" name="userid" value="<%= currentUser.getUsername() %>" readonly="readonly" />
            Species(specify breed):
            <input type="text" name="species" value="" />
            Description:
            <textarea name="description" rows="6" cols="40">
            </textarea>
            Photo:
            <input type="file" name="photo" value="" />
            Contact Info(phone/email):
            <textarea name="contact" rows="6" cols="40">
              <%= currentUser.getEmail() %>
            </textarea>
            Status:
            <select name="status">
                <option value="Missing">Missing</option>
               <option value="Reunited">Reunited</option>
            </select>
            <input type="hidden" name="latposition" id="latposition"/> <!-- hidden types are used javascript function then given a value -->
            <input type="hidden" name="lngposition" id="lngposition"/>
            <input type="hidden" name="area" id="area"/>
            <input type="submit" value="Submit" onClick="processinfo()" />

           
        </form> 
               <p class="center">Add marker and save location</p>
            <div id="map" height="460px" width="100%"></div>
        
        <div class="center" id="floating-panel">
            Enter Address:
      <input id="address" type="textbox" value="">
      <input id="submit" type="button" value="Find">
    </div>
        
        <div id="form">
            
            <table>
                
                <tr><td>Confirm lost pet location</td>
                    <td><input type='button' value='save' onclick='markerdata()'/></td> 
                </tr>
                   
                                
            </table>
                                  
                      
        </div>
        
        
    <script>
        
        // initializes map and stores coordinates from user placed marker
      var map;
      var marker;
      var marker2;
      var infowindow;
      var locationlat;
      var locationlng;
      var geocoder;
      var x = document.getElementById("form");
      
      function initMap() {
         var alabama = {lat: 32.3792, lng: -86.3077};
        map = new google.maps.Map(document.getElementById('map'), {
          center: alabama,
          zoom: 13
        });
        
        geocoder = new google.maps.Geocoder();
         x.style.display = "none";
        
        infowindow = new google.maps.InfoWindow({
          content: document.getElementById('form')
        });
        
        
         google.maps.event.addListener(map, 'click', function(event) {
          marker = new google.maps.Marker({
            position: event.latLng,
            map: map
          });
          
          google.maps.event.addListener(marker, 'click', function() {
               x.style.display = "block";
               infowindow.open(map, marker);
            
        });
          
      });
      
         document.getElementById('submit').addEventListener('click', function() {
          geocodeAddress(geocoder, map);
        });
      
      }
        /*
        function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('address').value;
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            marker2 = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location
            });
             google.maps.event.addListener(marker2, 'click', function() {
               x.style.display = "block";
               infowindow.open(map, marker2);
            
        });
            
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }
      */
      
      function markerdata(){
          
          var latlng = marker.getPosition();
      
      
           locationlat = latlng.lat();
           locationlng= latlng.lng();
           var lg = new google.maps.LatLng(locationlat, locationlng);
           x.style.display = "none";
           infowindow.close();
           GeoCode(lg);
      }
      
      function GeoCode(geo){ 
       geocoder.geocode({'latLng': geo}, function(results, status) {
                    
                    if (status === 'OK') {
                       if (results[2]) { 
                       
                     var area=(results[2].formatted_address);
                      document.getElementById('area').value=area;
                      
                       
                       }
                    }
                 }); 
    }
    
    
      function processinfo(){
          
          //put coordinates into hidden values and submitted to servlet
          var hiddenlat = document.getElementById("latposition");
          var hiddenlng = document.getElementById("lngposition");
          hiddenlat.value= locationlat;
          hiddenlng.value= locationlng;
          
          
          
          
          var form = document.getElementById("info");
          form.submit();
      }
      
      
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDkYfkn-x3aD_jJWJwa_81AnA3Qz-d-TcU&callback=initMap"
    async defer></script>
   
        
       
        
    </body>
</html>
