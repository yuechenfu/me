<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<link rel='stylesheet' id='main-css' href='../css/main_list.css' type='text/css' media='all' />
<link rel='stylesheet' id='main-css' href='../css/pop_detail.css' type='text/css' media='all' />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> 
<style type="text/css">
position: fixed;
}


* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  overflow-y: scroll; 
  overflow-x:hidden;
  padding:2px;
  float: left;
  width: 50%;
  height: 780px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
</head>
<body>
<header><%@include file="search.jsp"%></header>
 
    <section class="flexModal fixedLeft" id="bpayon">
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

		function initMap() {  
			var LatLngList = new Array ();
		    map = new google.maps.Map(document.getElementById('map'), {  
		            zoom: 14,  
		            center: new google.maps.LatLng('${cLat}','${cLng}'), // set center  
		            mapTypeId: google.maps.MapTypeId.ROADMAP // type : HYBRID,ROADMAP,SATELLITE,TERRAIN     
		        });   
		     
		    <c:forEach items="${propertyList}" var="property">
		    	addSite(map,'$${property.price}','${property.latitude}','${property.longitude}','${property.bedRooms}'+'bd '+'${property.bathRooms}'+'ba','${property.livingArea}'+'sqft','${property.address}','${property.mediaURL}','${property.mediaURLList}'); 
		    	LatLngList.push(new google.maps.LatLng('${property.latitude}','${property.longitude}'));
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

		function addSite(map, price, lat, lng,room,area ,address,image,imagelist) {  
		    var pt = new google.maps.LatLng(lat,lng);  
		    var marker = new google.maps.Marker({  
		                map: map,  
		                position : pt,   
		                title: address 
		                });  
		    
		    var contentString=  '<table><tr>'+
			'<td><img src='+image+' height=50 width=50 /></td> '+
			'<td>'+price +'<br>'+room +'<br>'+area+'</td> '+
			'</tr></table>';
			
		    var infowindow = new google.maps.InfoWindow({  
		        content: contentString
		    });  
		    
		    google.maps.event.addListener(marker, 'mouseover', function() {  
		        if (prev_infowindow != null) prev_infowindow.close();  
		        prev_infowindow = infowindow;  
		        infowindow.open(map, marker);  
		    });   
		    google.maps.event.addListener(marker, 'click', function() {  
		    	detailWindow(image,imagelist);
                return false;
		         
		    });   

       }  
		
		function detailWindow(image,imagelist){
		    var sWidth=document.body.scrollWidth;
		    var sHeight=document.body.scrollHeight;
		    var wHeight=document.documentElement.clientHeight;
		    var oMask=document.createElement("div");
		        oMask.id="mask";
		        oMask.style.height=sHeight+"px";
		        oMask.style.width=sWidth+"px";
		        document.body.appendChild(oMask);
		    var oDetail=document.createElement("div");
		    	oDetail.id="single";
		    var vHtml ="<div class='singleCon'>";
		    	vHtml =vHtml + "<div id='close'>Close</div>";
		    	vHtml =vHtml + "<div class='row'>";
		    	vHtml =vHtml +     "<div class='column'>";
		    	vHtml =vHtml +        "<p align='center'><img src="+image+" width='100%' height='500px'/></p>";
		    	//for(j = 0,len=myArray.length; j < len; j++) {
		    		//vHtml =vHtml +        "<p align='center'><img src="+myArray[j]+" width='100%' height='500px'/></p>";
		    	//}
		    	vHtml =vHtml +     "</div>";
		    	vHtml =vHtml +     "<div class='column'>";
		    	vHtml =vHtml +       "<p>Some text2</p>";
		    	vHtml =vHtml +     "</div>";
		    	vHtml =vHtml + "</div></div>";
		    	
		    		   
		    	
		    
		    	oDetail.innerHTML=vHtml; 
		        document.body.appendChild(oDetail);

		    var dHeight=oDetail.offsetHeight;
		    var dWidth=oDetail.offsetWidth;
		        //left和bottom
		        oDetail.style.left=(sWidth/2 - dWidth/2)+"px";
		        oDetail.style.bottom="1px";
		    var oClose=document.getElementById("close");
		        oClose.onclick=oMask.onclick=function(){
		                    document.body.removeChild(oDetail);
		                    document.body.removeChild(oMask);
		       };
		  };
	</script>

    <script src="../js/markerclusterer.js"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCuMhCNOD0HtouNQ_rm9igVmd3LD1Z1a-8&callback=initMap">
    </script>
    </body>
  </html>