package com.pib.property.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.pib.property.entity.Account;
import com.pib.property.entity.Property;
import com.pib.property.entity.PropertyFilterCondition;
import com.pib.property.manager.BridgeApiManager;
import com.pib.property.manager.ApiAnalysisManager;
import com.pib.util.StringUtil; 

@RestController(value = "HouseController")
@RequestMapping({"/house"})
public class HouseController {
	
	@Autowired
    private BridgeApiManager bridgeApiManager;
	@Autowired
	private ApiAnalysisManager apiAnalysisManager;

    @GetMapping("/search")
    public ModelAndView search(HttpServletRequest request,PropertyFilterCondition ptc )throws Exception {
		
		List<Property> propertyList = new ArrayList();
        HttpSession session = request.getSession();
    	PropertyFilterCondition condition = (PropertyFilterCondition) session.getAttribute("FILTER");
    	if(condition != null) condition.setSearchText(ptc.getSearchText());
    	else condition =ptc;
    	String resultText =bridgeApiManager.getTextFromApiByCondition(request, condition);
        propertyList = apiAnalysisManager.getPropertyList(resultText);
        ModelAndView mode = getDataModel(propertyList);
        mode.addObject("searchText",ptc.getSearchText());
		mode.setViewName("pages/main");
        return mode;
    }
    
    
    public ModelAndView getDataModel(List<Property> propertyList ) {
    	ModelAndView mode = new ModelAndView();
    	if(propertyList.size() >0 ) {
        	int homeCounts = propertyList.get(0).getHomeCounts();
        	int pageLimit = propertyList.get(0).getPageLimit();
        	mode.addObject("propertyList", propertyList);
        	mode.addObject("homeCounts",homeCounts);
        	mode.addObject("pageLimit",pageLimit);
        	mode.addObject("pageCounts",StringUtil.getPageSum(homeCounts, pageLimit));
        	mode.addObject("cLat",propertyList.get(0).getLatitude());
        	mode.addObject("cLng",propertyList.get(0).getLongitude());
        }
    	return mode;
    }
    
    @PostMapping("/filter")
    @ResponseBody
    public Map<String,Object>  filter_search(HttpServletRequest request,@RequestBody PropertyFilterCondition ptc)throws Exception {
    	createSessionFilter(request,ptc);
    	Map<String, Object> result = null;  
    	 result = new HashMap<String, Object>();  
         result.put("msg", "SUCCESS");  
        return result;  
    }
    
    public PropertyFilterCondition createSessionFilter(HttpServletRequest request,PropertyFilterCondition newPtc) {
    	PropertyFilterCondition allPtc = null;
    	HttpSession session = request.getSession();
    	PropertyFilterCondition sessionPtc = (PropertyFilterCondition) session.getAttribute("FILTER");
    	if(sessionPtc !=null ) {
    		if(newPtc.getClickMenu().equals("ListType")) {
    			
    			sessionPtc.setListType(newPtc.getListType());
    		}
    		allPtc =sessionPtc ;
    	}else {
    		session.setAttribute("FILTER", newPtc);
    		allPtc = newPtc ;
    	}
    	return allPtc;
    }
    
    @GetMapping("/save_search")
    public ModelAndView save_search(HttpServletRequest request)throws Exception {
    	HttpSession session = request.getSession();
    	ModelAndView mode = new ModelAndView();
		Account account = (Account) session.getAttribute("loginAccount");
    	if (account == null) return new ModelAndView("redirect:/account/login");
    	mode.setViewName("/pages/index");
        return mode;
    }
    
    
 

}
