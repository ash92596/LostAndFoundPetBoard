<%-- 
    Document   : postlost
    Created on : Jan 29, 2019, 11:22:36 AM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
        
        
    </head>
    <body>
        <h1>Lost Pet Info</h1>
        
        <form id="info" method="post" action="lostpetservlet"  enctype="multipart/form-data">
            UserID:
            <input type="text" name="userid" value="" />
            Species(specify breed):
            <input type="text" name="species" value="" />
            Description:
            <textarea name="description" rows="6" cols="40">
            </textarea>
            Photo:
            <input type="file" name="photo" value="" />
            Contact Info(phone/email):
            <textarea name="contact" rows="6" cols="40">
            </textarea>
            Status:
            <select name="status">
                <option value="Missing">Missing</option>
               <option value="Reunited">Reunited</option>
            </select>
            <input type="hidden" name="latposition" id="latposition"/> <!-- hidden types are used javascript function then given a value -->
            <input type="hidden" name="lngposition" id="lngposition"/>
            <input type="submit" value="Submit" onClick="processinfo()" />

            
        </form> 
        
        <div id="map" height="460px" width="100%"></div>
        
        <div id="form">
            
            <table>
                
                <tr><td><td>Confirm lost pet location</td><input type='button' value='save' onclick='markerdata()'/></td></tr>
                   
                                
            </table>
                                  
                      
        </div>
        
        
    <script>
        
        // initializes map and stores coordinates from user placed marker
      var map;
      var marker;
      var infowindow;
      var locationlat;
      var locationlng;
      function initMap() {
         var alabama = {lat: 32.3792, lng: -86.3077};
        map = new google.maps.Map(document.getElementById('map'), {
          center: alabama,
          zoom: 13
        });
        
        infowindow = new google.maps.InfoWindow({
          content: document.getElementById('form')
        });
        
        
         google.maps.event.addListener(map, 'click', function(event) {
          marker = new google.maps.Marker({
            position: event.latLng,
            map: map
          });
          
          google.maps.event.addListener(marker, 'click', function() {
            infowindow.open(map, marker);
        });
          
      });
      }
      
      function markerdata(){
          
          var latlng = marker.getPosition();
           locationlat = latlng.lat();
           locationlng= latlng.lng();              
      }
      
      function processinfo(){
          
          //put coordinates into hidden values and submitted to servlet
          var hiddenlat = document.getElementById("latposition");
          var hiddenlng = document.getElementById("lngposition")
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
