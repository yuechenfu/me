package com.pib.property.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pib.property.entity.Property;
import com.pib.property.manager.ApiRevokeManager;
import com.pib.util.StringUtil;

@RestController(value = "HouseController")
@RequestMapping({"/house"})
public class HouseController {
	
	@Autowired
    private ApiRevokeManager apiRevokeManager;
	
	@GetMapping(value="/index")
	@ResponseBody
	public ModelAndView home(){
		ModelAndView mode = new ModelAndView();
		mode.setViewName("pages/index");
		return mode;
	}
    
    @GetMapping("/search")
    public ModelAndView search(HttpServletRequest request,@RequestParam(value="") String search)throws Exception {
		ModelAndView mode = new ModelAndView();
		List<Property> propertyList = new ArrayList();
		String url = "/Property";
		String resultText ="";
        Map<String, String> params = new HashMap<>();
        
        if (search.equals("")) {
        	resultText =  apiRevokeManager.getTextFromDefaultApi(url, request, params);
        }
        else if (StringUtil.isNumber(search)) {
        	params.put("search", search);
        	resultText = apiRevokeManager.getTextFromApiFilterofZIP(url, request, params);
        }
        else {
        	params.put("search", search.toLowerCase());
            resultText =  apiRevokeManager.getTextFromApiFilterofAddress(url, request, params);
        }
        int sumCount = apiRevokeManager.getPropertyListSize(resultText) ;
        propertyList =apiRevokeManager.getPropertyList(resultText,sumCount);
        if(propertyList != null) {
        	mode.addObject("propertyList", propertyList);
        	mode.addObject("searchCount",sumCount);
        	mode.addObject("cLat",propertyList.get(0).getLatitude());
        	mode.addObject("cLng",propertyList.get(0).getLongitude());
        }
        mode.addObject("searchText",search);
		mode.setViewName("pages/main");
        return mode;
    }
    @GetMapping({"/openHouse"})
    public String openHouse(HttpServletRequest request) throws Exception {
    	String url = "/OpenHouse";
        Map<String, String> params = new HashMap<>();
        String resultText =  apiRevokeManager.getTextFromApiFilterofAddress(url, request, params);
        return apiRevokeManager.parseJsonFromApi(resultText).toString();
    }



}
