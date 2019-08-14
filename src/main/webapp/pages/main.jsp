<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<link rel='stylesheet' id='main-css' href='../css/main_list.css' type='text/css' media='all' />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 
<style type="text/css">
position: fixed;
}

</style>
</head>
<body>
<header><%@include file="search.jsp"%></header>
 
    <section class="flexModal fixedLeft">
      <nav> 
       <div id="map" ></div>
      </nav>
      <article>
      
       <table border="1" align="center">
        
       <p align="left"  style="padding-left:40px;">${searchText} Real Estate & Homes For Sale</p>
       <p align="left"  style="padding-left:40px;">${searchCount } results</p>
        <c:forEach var="property" items="${propertyList}" varStatus="status">
           <c:if test="${status.index%2==0}">
			<tr>
		   </c:if>
			<td>
			    <div>
                    <a href="" class="woocommerce-LoopProduct-link woocommerce-loop-product__link">
                        <img width="350" height="200" src="${property.mediaURL}" class="primary_image" alt="" />
                    </a>
                    <div >
                      <span style="font-style:Courier New;font-size:20px;">$${property.price }</span>
                      <span style="font-style:Courier New;font-size:15px;">${property.bedRooms } bds | ${property.bathRooms } ba | ${property.livingArea } sqft</span>
                      <p style="font-style:Courier New;font-size:15px;">${property.address }</p>
                    </div>
                </div>
			</td>
		  <c:if test="${status.index%2!=0}">
			</tr>
			</c:if>
        </c:forEach>
        
        <tr>
        <td colspan=2>
        <p class="paging">
                            <a href="Staff_ListServlet?page=${paging.indexpage-1}">&lt;&lt; first </a>
                            <a href="Staff_ListServlet?page=${paging.page-1 }">    &lt; last </a>
                            <strong>${paging.page+1}/total ${paging.pagenumber}</strong>
                            <a href="Staff_ListServlet?page=${paging.page+1}">next &gt;</a>
                            <a href="Staff_ListServlet?page=${paging.pagenumber-1}">end &gt;&gt;</a>
        </p>
        </td>
        <tr>
        </table>
        
      </article>
      
    </section> 
    
     
    <script type="text/javascript">  
		var map = null;  
		var prev_infowindow = null;  
		var contentString = '<div id="content">'+  
	      '<div id="siteNotice">'+  
	      '</div>'+  
	      '<h1 id="firstHeading" class="firstHeading">Uluru</h1>'+  
	      '<div id="bodyContent">'+  
	      '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +  
	      'sandstone rock formation in the southern part of the '+  
	      'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) '+  
	      'south west of the nearest large town, Alice Springs; 450&#160;km '+  
	      '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major '+  
	      'features of the Uluru - Kata Tjuta National Park. Uluru is '+  
	      'sacred to the Pitjantjatjara and Yankunytjatjara, the '+  
	      'Aboriginal people of the area. It has many springs, waterholes, '+  
	      'rock caves and ancient paintings. Uluru is listed as a World '+  
	      'Heritage Site.</p>'+  
	      '<p>Attribution: Uluru, <a href="http://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+  
	      'http://en.wikipedia.org/w/index.php?title=Uluru</a> '+  
	      '(last visited June 22, 2009).</p>'+  
	      '</div>'+  
	      '</div>';  
	  
		function initMap() {  
			var vCenter ;
			var LatLngList = new Array ();
			<c:forEach items="${propertyList}" var="property">
	    	vCenter = new google.maps.LatLng('${property.latitude}','${property.longitude}');
	    	LatLngList.push(vCenter);
	        </c:forEach>
	    
		    map = new google.maps.Map(document.getElementById('map'), {  
		            zoom: 12,  
		            center: vCenter, // set center  
		            mapTypeId: google.maps.MapTypeId.ROADMAP // type : HYBRID,ROADMAP,SATELLITE,TERRAIN     
		        });   
		     
		    var array = new Array();
		    <c:forEach items="${propertyList}" var="property">
		    	addSite(map,'${property.price}','${property.latitude}','${property.longitude}','${property.price}'); 
		    </c:forEach>
		     
			//  Create a new viewpoint bound  
			var bounds = new google.maps.LatLngBounds ();  
			//  Go through each...  
			for (var i = 0, LtLgLen = LatLngList.length; i < LtLgLen; i++) {  
			//  And increase the bounds to take this point  
			bounds.extend (LatLngList[i]);  
			}  
			//  Fit these bounds to the map  
			map.fitBounds (bounds);  
		}  

		function addSite(map, siteDesc, lat, lng, address) {  
		    var pt = new google.maps.LatLng(lat,lng);  
		    var marker = new google.maps.Marker({  
		                map: map,  
		                position : pt,   
		                title: siteDesc  
		                });  
		    var infowindow = new google.maps.InfoWindow({  
		        content: contentString  
		    });  
		  
		    google.maps.event.addListener(marker, 'click', function() {  
		        if (prev_infowindow != null) prev_infowindow.close();  
		        prev_infowindow = infowindow;  
		        infowindow.open(map, marker);  
		    });       

       }  
		
		

	</script>

    <script src="../js/markerclusterer.js"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCuMhCNOD0HtouNQ_rm9igVmd3LD1Z1a-8&callback=initMap">
    </script>
    </body>
  </html>