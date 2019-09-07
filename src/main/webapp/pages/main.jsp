<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <title>Property</title>
 <meta name="viewport" content="initial-scale=1.0">
 <meta charset="utf-8">
 <link rel='stylesheet' id='main-css' href='../css/main_list.css' type='text/css' media='all' />
 <link rel='stylesheet' id='main-css' href='../css/pop_detail.css' type='text/css' media='all' />
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
 <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
 /* Create two equal columns that floats next to each other */
.column {
  overflow-y: scroll; 
  overflow-x:hidden;
  padding:2px;
  float: left;
  width: 50%;
  height: calc(100vh - 4px); 
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
  
    <div class="header"><%@include file="search.jsp"%></div>
       <div id="map"></div>
	   <div id="prolist">
	     <table border="1" align="center">
       <p align="left"  style="padding-left:20px;">${searchText} Real Estate & Homes For Sale</p>
       <p align="left"  style="padding-left:20px;">${homeCounts } results</p>
        <c:forEach var="property" items="${propertyList}" varStatus="status">
           <c:if test="${status.index%2==0}">
			<tr>
		   </c:if>
			<td>
			    <div>
			    <a href="">
                    <a  href = "#" onclick='javascript:detailWindow(${property.mlsStatus},"$${property.listPrice}",${property.bedroomsTotal}+"bd "+${property.bathroomsFull }+"ba ",${property.livingArea}+"sqft",${property.address},"${property.mediaURL}","${property.mediaURLList}");' 
                         class="woocommerce-LoopProduct-link woocommerce-loop-product__link">
                        <img width="350" height="200" src="${property.mediaURL}" class="primary_image" alt="" />
                    </a>
                    <div >
                      <span style="font-style:Courier New;font-size:20px;">$${property.listPrice }</span>
                      <span style="font-style:Courier New;font-size:15px;">${property.bedroomsTotal } bds | ${property.bathroomsFull } ba | ${property.livingArea } sqft</span>
                      <p style="font-style:Courier New;font-size:15px;">${property.address }</p>
                    </div>
                </div>
			</td>
		  		<c:if test="${status.index%2!=0}">
			</tr>
		  </c:if>
        </c:forEach>
        </table>
	        <div class="pageline">
			  <p>&nbsp;</p>
			  <ul class="pagination justify-content-center">
			    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
			    <c:forEach var="p"  begin="1" end="${pageCounts }">
				  <li class="page-item"><a class="page-link" href="#">${p}</a></li>  
				</c:forEach>
			    
			    <li class="page-item"><a class="page-link" href="#">Next</a></li>
			  </ul>
			</div>
			<hr>
        <div class="readme">
          <p>WHY USE Washingtonproperty?<p>
		  <p>Washingtonproperty helps you find the newest ${searchText} real estate listings. 
		  By analyzing information on thousands of single family homes for sale in ${searchText}, 
		  California  and across the United States, we calculate home values (Zestimates) and the washingtonproperty Home Value Price Index. 
		  If you're looking to rent in ${searchText}, check out our extensive list of luxury apartments and townhomes. 
		  We make it easy to find your dream home by filtering home types, price and size. Filtering with keyword search is also possible, 
		  like "waterfront" or brand new carpet homes in ${searchText}. 
		  If you're looking specifically for homes in ${searchText} or apartments in ${searchText}, we've got you covered there as well.
		  </p>
        </div>
        <br>
        <hr>
        <div>
         <img alt="" src="../images/homeback.png" width="100%">
        </div>
	 </div> 
    <script type="text/javascript">  
		var map = null;  
		var prev_infowindow = null;  
		function initMap() {  
			var LatLngList = new Array ();
		    map = new google.maps.Map(document.getElementById('map'), {  
		            zoom: 8,  
		            center: new google.maps.LatLng('${cLat}','${cLng}'), // set center   
		            mapTypeId: google.maps.MapTypeId.ROADMAP // type : HYBRID,ROADMAP,SATELLITE,TERRAIN     
		        });   
		     
		    <c:forEach items="${propertyList}" var="property">
		    	addSite(map,'${property.mlsStatus}','$${property.listPrice}','${property.latitude}','${property.longitude}','${property.bedroomsTotal}'+'bd '+'${property.bathroomsFull}'+'ba','${property.livingArea}'+'sqft','${property.address}','${property.mediaURL}','${property.mediaURLList}'); 
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
			//set map area
			//setArea(map,LatLngList);
		}  
		
		
		function setArea(map,LatLngList){
			 
			
			// Define the LatLng coordinates for the polygon's path.
	       <!--
			var triangleCoords = [
	          {lat: 25.774, lng: -80.190},
	          {lat: 18.466, lng: -66.118},
	          {lat: 32.321, lng: -64.757},
	          {lat: 25.774, lng: -80.190}
	        ];
           -->
           
           var triangleCoords = LatLngList;
	        // Construct the polygon.
	        var bermudaTriangle = new google.maps.Polygon({
	          paths: triangleCoords,
	          strokeColor: '#FF0000',
	          strokeOpacity: 0.8,
	          strokeWeight: 2,
	          fillColor: '#FF0000',
	          fillOpacity: 0.35
	        });
	        bermudaTriangle.setMap(map);
		}

		function addSite(map, mlsStatus,price, lat, lng,room,area ,address,image,imagelist) {  
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
		    	detailWindow(mlsStatus,price,room,area,address,image,imagelist);
                return false;
		         
		    });   

       } 
		function detailWindow(mlsStatus,price,room,area,address,image,imagelist){
			var myArray=strToArray(imagelist); 
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
		    	for(j = 0,len=myArray.length; j < len; j++) {
		    		if (j % 2 ==0){
		    			vHtml =vHtml + "<p>";
		    		}
		    		vHtml =vHtml + "<span><img src="+myArray[j]+" width='50%' height='200px'/></span>";
		    		if (j % 2 !=0){
		    			vHtml =vHtml +"</p>";
		    		}
		    	}
		    	vHtml =vHtml +     "</div>";
		    	vHtml =vHtml +     "<div class='column'>";
		    	vHtml =vHtml +       "<p><img  src='../images/logo.jpg' width='60px' height='50px'><span  style='padding-left:300px;'><a href='#'>Save</a></span><span style='padding-left:30px;'><a href='#'>Share</a></span><span style='padding-left:30px;'><a href='#'>More...</a></span></p>";
		    	vHtml =vHtml +     "<hr>";
		    	vHtml =vHtml +     "<p><span style='font-size:20px'>"+price +"</span><span  style='padding-left:40px;'>"+room +", </span><span  style='padding-left:40px;'>"+area +"</span></p>";
		    	vHtml =vHtml +     "<p><span>"+address +"</span></p>";
		    	vHtml =vHtml +     "<p><span>"+mlsStatus +"</span></p>";
		    	vHtml =vHtml +     "<p align='right'><span style='padding-right:40px'><button type='button' style='background-color: #e7e7e7;color:blue' >ContactAgent</button></span><span style='padding-right:40px'><button type='button' style='background-color: #008CBA;color: white;'>Take a Tour</button></span></p>";
		    	vHtml =vHtml +     "<hr>";
		    	vHtml =vHtml +     "<p><span style='font-size:20px'>Overview</span></p>";
		    	vHtml =vHtml +     "<p><span style='font-size:15px'>Something...</span></p>";
		    	vHtml =vHtml +     "<hr>";
		    	vHtml =vHtml +     "</div>";
		    	vHtml =vHtml + "</div></div>";
		    	
		    	oDetail.innerHTML=vHtml; 
		        document.body.appendChild(oDetail);

		    var dHeight=oDetail.offsetHeight;
		    var dWidth=oDetail.offsetWidth;
		        //left和bottom
		        oDetail.style.left=(sWidth/2 - dWidth/2)+"px";
		        oDetail.style.bottom="2px";
		       
		    var oClose=document.getElementById("close");
		        oClose.onclick=oMask.onclick=function(){
		                    document.body.removeChild(oDetail);
		                    document.body.removeChild(oMask);
		       };
		  };
		  
		  function strToArray(str){
			  var vStr = str.replace(/\[|]/g,'');
			  var list = vStr.split(",");
			  return list;
		  }
		  
		 
	</script>
 <script src="../js/markerclusterer.js"></script>
<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCuMhCNOD0HtouNQ_rm9igVmd3LD1Z1a-8&callback=initMap">
</script>
</body>
</html>