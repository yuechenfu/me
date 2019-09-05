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
import com.pib.property.manager.ApiAnalysisManager;
import com.pib.property.manager.ApiCredentialsManager;
import com.pib.util.StringUtil;

@RestController(value = "HouseController")
@RequestMapping({"/house"})
public class HouseController {
	
	@Autowired
    private ApiRevokeManager apiRevokeManager;
	@Autowired
	private ApiAnalysisManager apiAnalysisManager;

    @GetMapping("/search")
    public ModelAndView search(HttpServletRequest request,@RequestParam(value="") String search)throws Exception {
		ModelAndView mode = new ModelAndView();
		List<Property> propertyList = new ArrayList();
		String resource = "Property";
		String resultText ="";
        Map<String, String> params = new HashMap<>();
        
        

        if (search.equals("")) {
        	resultText =  apiRevokeManager.getTextFromApi(request,resource,params);
        	System.out.println("resultText="+resultText);
        }
        else if (StringUtil.isNumber(search)) {
        	params.put("$filter", "(PostalCode eq '"+search+"')" );
        	params.put("$expand", "Media");
        	resultText = apiRevokeManager.getTextFromApiByPostalCode(request,resource,params);
        }
        else {
        	params.put("search", search.toLowerCase());
            resultText =  apiRevokeManager.getTextFromApi(request,resource,params);
        }
        int sumCount = apiAnalysisManager.getPropertyListSize(resultText) ;
        propertyList = apiAnalysisManager.getPropertyList(resultText,sumCount);
        if(propertyList != null) {
        	mode.addObject("propertyList", propertyList);
        	mode.addObject("searchCount",sumCount);
        	mode.addObject("cLat","25.774");
        	mode.addObject("cLng","-80.190");
        	//mode.addObject("cLat",propertyList.get(0).getLatitude());
        	//mode.addObject("cLng",propertyList.get(0).getLongitude());
        }
        mode.addObject("searchText",search);
		mode.setViewName("pages/main");
        return mode;
    }
 

}
