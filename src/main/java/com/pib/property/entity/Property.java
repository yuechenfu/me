package com.pib.property.entity;

import java.util.ArrayList;
import java.util.List;

import com.pib.nullhandler.NullObject;
import com.pib.property.model.builder.AbstractBuilder;

public class Property {

	private String odataId;
	
	private long   price;
	
	private String mediaURL;
	
	private ArrayList mediaURLList ;
	
	private int count;
	
	private String bedRooms;
	
	private String bathRooms;
	
	private String livingArea;
	
	private String lotSizeSquareFeet;
	
	private String address;
	
	private String longitude;
	
	private String latitude;
	
	private String mlsStatus;
	
	private String vDirections;
	
	
	public static final Null NULL = new Null();

	public String getOdataId() {
		return odataId;
	}

	public void setOdataId(String odataId) {
		this.odataId = odataId;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getMediaURL() {
		return mediaURL;
	}

	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

 

 

	public String getvDirections() {
		return vDirections;
	}

	public void setvDirections(String vDirections) {
		this.vDirections = vDirections;
	}

	public ArrayList getMediaURLList() {
		return mediaURLList;
	}

	public void setMediaURLList(ArrayList mediaURLList) {
		this.mediaURLList = mediaURLList;
	}

	public String getLivingArea() {
		return livingArea;
	}

	public void setLivingArea(String livingArea) {
		this.livingArea = livingArea;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBedRooms() {
		return bedRooms;
	}

	public void setBedRooms(String bedRooms) {
		this.bedRooms = bedRooms;
	}

	public String getBathRooms() {
		return bathRooms;
	}

	public void setBathRooms(String bathRooms) {
		this.bathRooms = bathRooms;
	}

	public String getLotSizeSquareFeet() {
		return lotSizeSquareFeet;
	}

	public void setLotSizeSquareFeet(String lotSizeSquareFeet) {
		this.lotSizeSquareFeet = lotSizeSquareFeet;
	}
	
	

	public String getMlsStatus() {
		return mlsStatus;
	}

	public void setMlsStatus(String mlsStatus) {
		this.mlsStatus = mlsStatus;
	}



	private static class Null extends Property implements NullObject { 
    }
    public static class Builder extends AbstractBuilder {
        @Override
        public Property build() {
            try {
                return super.build(Property.class);
            } catch (InstantiationException | IllegalAccessException e) {
                return NULL;
            }
        }
    }
	@Override
	public String toString() {
		return "Property [odataId=" + odataId + ", price=" + price + ", mediaURL=" + mediaURL + ", mediaURLList="
				+ mediaURLList + ", count=" + count + ", bedRooms=" + bedRooms + ", bathRooms=" + bathRooms
				+ ", livingArea=" + livingArea + ", lotSizeSquareFeet=" + lotSizeSquareFeet + ", address=" + address
				+ ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	 
    
}
