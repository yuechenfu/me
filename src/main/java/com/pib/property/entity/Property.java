package com.pib.property.entity;

import java.util.ArrayList;
import java.util.List;

import com.pib.nullhandler.NullObject;
import com.pib.property.model.builder.AbstractBuilder;

public class Property {

	private long   listPrice;
	
	private String mediaURL;
	
	private ArrayList mediaURLList ;
	
	private int count;
	
	private String bedroomsTotal;
	
	private String bathroomsFull;
	
	private String livingArea;
	
	private long streetNumberNumeric;
	
	private String streetDirPrefix;
	
	private String streetName;
	
	private String streetSuffix;
	
	private String city;
	
	private String stateOrProvince;
	
	private String postalCode;
	
	
	private String address;
	
	private String mlsStatus;
	
	private String latitude;
	
	private String longitude;
	
	private int    homeCounts ;
	
	private int  pageLimit;
	
	private int  pageCounts;
	
	
	 
 
	
	
	public long getListPrice() {
		return listPrice;
	}
	public void setListPrice(long listPrice) {
		this.listPrice = listPrice;
	}
	public String getMediaURL() {
		return mediaURL;
	}
	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	public ArrayList getMediaURLList() {
		return mediaURLList;
	}
	public void setMediaURLList(ArrayList mediaURLList) {
		this.mediaURLList = mediaURLList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBedroomsTotal() {
		return bedroomsTotal;
	}
	public void setBedroomsTotal(String bedroomsTotal) {
		this.bedroomsTotal = bedroomsTotal;
	}
	public String getBathroomsFull() {
		return bathroomsFull;
	}
	public void setBathroomsFull(String bathroomsFull) {
		this.bathroomsFull = bathroomsFull;
	}
	public String getLivingArea() {
		return livingArea;
	}
	public void setLivingArea(String livingArea) {
		this.livingArea = livingArea;
	}
	public long getStreetNumberNumeric() {
		return streetNumberNumeric;
	}
	public void setStreetNumberNumeric(long streetNumberNumeric) {
		this.streetNumberNumeric = streetNumberNumeric;
	}
	public String getStreetDirPrefix() {
		return streetDirPrefix;
	}
	public void setStreetDirPrefix(String streetDirPrefix) {
		this.streetDirPrefix = streetDirPrefix;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetSuffix() {
		return streetSuffix;
	}
	public void setStreetSuffix(String streetSuffix) {
		this.streetSuffix = streetSuffix;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateOrProvince() {
		return stateOrProvince;
	}
	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMlsStatus() {
		return mlsStatus;
	}
	public void setMlsStatus(String mlsStatus) {
		this.mlsStatus = mlsStatus;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	 
	public int getPageCounts() {
		return pageCounts;
	}
	public void setPageCounts(int pageCounts) {
		this.pageCounts = pageCounts;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	public int getHomeCounts() {
		return homeCounts;
	}
	public void setHomeCounts(int homeCounts) {
		this.homeCounts = homeCounts;
	}
	public static Null getNull() {
		return NULL;
	}
	public static final Null NULL = new Null();

	


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
		return "Property [listPrice=" + listPrice + ", mediaURL=" + mediaURL + ", mediaURLList=" + mediaURLList
				+ ", count=" + count + ", bedroomsTotal=" + bedroomsTotal + ", bathroomsFull=" + bathroomsFull
				+ ", livingArea=" + livingArea + ", streetNumberNumeric=" + streetNumberNumeric + ", streetDirPrefix="
				+ streetDirPrefix + ", streetName=" + streetName + ", streetSuffix=" + streetSuffix + ", city=" + city
				+ ", stateOrProvince=" + stateOrProvince + ", postalCode=" + postalCode + ", address=" + address
				+ ", mlsStatus=" + mlsStatus + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	 
	 
    
}
