package com.pib.property.entity;

public class PropertyFilterCondition {
	
	private String clickMenu;
	
	private String searchText;
	
	private String[] listType ;

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
 

	public String[] getListType() {
		return listType;
	}

	public void setListType(String[] listType) {
		this.listType = listType;
	}

	public String getClickMenu() {
		return clickMenu;
	}

	public void setClickMenu(String clickMenu) {
		this.clickMenu = clickMenu;
	}
	
	

}
