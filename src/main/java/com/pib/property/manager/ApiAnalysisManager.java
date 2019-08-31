package com.pib.property.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pib.property.entity.Property;

@Component
public class ApiAnalysisManager {
	
	@Value("${api.pageLimit}") 
	private int pageLimit;
	
	public Integer getPropertyListSize(String resultText) throws Exception {
    	JsonObject jsonObject = new Gson().fromJson(resultText, JsonObject.class);
        JsonElement value = jsonObject.get("value");
        if (value == null) return 0;
    	return value.getAsJsonArray().size();
    }
	
	public List<Property> getPropertyList(String resultText,int sumCount) throws Exception {
    	int n =0;
    	String fristImageUrl ="";
    	List<Property> propertyList = new ArrayList(); 
    	JsonObject jsonObject = new Gson().fromJson(resultText, JsonObject.class);
        JsonElement value = jsonObject.get("value");
        if (value == null) return null;
        JsonArray dataArray =value.getAsJsonArray();
        for (JsonElement jsonElement : dataArray) {
        	JsonObject single = jsonElement.getAsJsonObject();
        	JsonElement medias = single.get("Media");
        	List vMediaList = new ArrayList();
        	if  (!medias.isJsonNull()  ) {
        		JsonArray mediaList =medias.getAsJsonArray();
        		for (JsonElement mdElement : mediaList) {
        			JsonObject media = mdElement.getAsJsonObject();
        			vMediaList.add(media.get("MediaURL").getAsString());
        		} 
        		fristImageUrl = mediaList.get(0).getAsJsonObject().get("MediaURL").getAsString() ;
        		
        	} 
        	Property property = new Property.Builder().set("listPrice",single.get("ListPrice").getAsLong())
        											  .set("bedroomsTotal", single.get("BedroomsTotal").toString())
        											  .set("bathroomsFull", single.get("BathroomsFull").toString())
        											  .set("livingArea", single.get("LivingArea").toString())
        											  .set("address", single.get("StreetName").toString() )
        											  .set("mediaURL", fristImageUrl)
        											  .set("latitude", "34.0522"  )
        											  .set("longitude","118.2437"  )
        											  .set("mediaURLList", vMediaList)
        											  .build();  
        	propertyList.add(property);
        	n++;
        	if (pageLimit < sumCount &&  pageLimit == n)  break;
        } 
        return propertyList;
    }
	
    public List<Property> getPropertyList2(String resultText,int sumCount) throws Exception {
    	int n =0;
    	String singleMediaUrl ="";
    	List<Property> propertyList = new ArrayList(); 
    	JsonObject jsonObject = new Gson().fromJson(resultText, JsonObject.class);
        JsonElement value = jsonObject.get("value");
        if (value == null) return null;
        JsonArray dataArray =value.getAsJsonArray();
        for (JsonElement jsonElement : dataArray) {
        	JsonObject single = jsonElement.getAsJsonObject();
        	JsonElement medias = single.get("Media");
        	List vMediaList = new ArrayList();
        	if  (!medias.isJsonNull()  ) {
        		JsonArray mediaList =medias.getAsJsonArray();
        		for (JsonElement mdElement : mediaList) {
        			JsonObject media = mdElement.getAsJsonObject();
        			vMediaList.add(media.get("MediaURL").getAsString());
        		} 
        		singleMediaUrl = mediaList.get(0).getAsJsonObject().get("MediaURL").getAsString() ;
        		
        	} 
        	Property property = new Property.Builder().set("odataId", single.get("@odata.id").getAsString())
        											  .set("price",single.get("ListPrice").getAsLong())
        											  .set("bedRooms", single.get("BedroomsTotal").toString())
        											  .set("bathRooms", single.get("BathroomsTotalDecimal").toString())
        											  .set("livingArea", single.get("LivingArea").toString())
        											  .set("address", single.get("UnparsedAddress").toString() )
        											  .set("latitude", single.get("Latitude").toString()  )
        											  .set("longitude", single.get("Longitude").toString()  )
        											  .set("mediaURL", singleMediaUrl)
        											  .set("mlsStatus", single.get("MlsStatus").toString())
        											  .set("mediaURLList", vMediaList).build();  
        	propertyList.add(property);
        	n++;
        	if (pageLimit < sumCount &&  pageLimit == n)  break;
        } 
        return propertyList;
    }
}
