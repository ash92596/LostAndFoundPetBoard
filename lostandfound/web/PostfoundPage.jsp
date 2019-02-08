<%-- 
    Document   : foundPage
    Created on : Feb 5, 2019, 9:39:08 AM
    Author     : NV121
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" type="text/css" href="myStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Found Page</title>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 50%;
        margin: 0;
        padding: 0;
      }
    </style>
    </head>
    
    <body>
        <h1>List of found pets</h1>
        <table border="0">
    <thead>
        <tr>
            <th colspan="2">{placeholder}</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><strong>Description: </strong></td>
            <td><span style="font-size:smaller; font-style:italic;">{placeholder}</span></td>
        </tr>
        <tr>
            <td><strong>Counselor: </strong></td>
            <td>{placeholder}
                <br>
                <span style="font-size:smaller; font-style:italic;">
                member since: {placeholder}</span>
            </td>
        </tr>
        <tr>
            <td><strong>Contact Details: </strong></td>
            <td><strong>email: </strong>
                <a href="mailto:{placeholder}">{placeholder}</a>
                <br><strong>phone: </strong>{placeholder}
            </td>
        </tr>
    </tbody>
</table>
        <div id="map"></div>
    <script>
      // Note:requires that you consent to location sharing when
      // prompted by your browser. If you see the error "The Geolocation service
      // failed.", it means you probably did not give permission for the browser to
      // locate you.
      var map, infoWindow;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -34.397, lng: 150.644},
          zoom: 6
        });
        infoWindow = new google.maps.InfoWindow;

        // Try HTML5 geolocation.
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };

            infoWindow.setPosition(pos);
            infoWindow.setContent('Location found.');
            infoWindow.open(map);
            map.setCenter(pos);
          }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
          });
        } else {
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindow, map.getCenter());
        }
      }

      function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?
                              'Error: The Geolocation service failed.' :
                              'Error: Your browser doesn\'t support geolocation.');
        infoWindow.open(map);
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCkfc0bsDNQdjxexqfkZ4HS_wyQSgPBLaY&callback=initMap">
    </script>
    </body>
</html>
