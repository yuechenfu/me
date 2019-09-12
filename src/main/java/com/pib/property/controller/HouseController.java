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
    public ModelAndView search(HttpServletRequest request,@RequestParam(value="") String search)throws Exception {
		ModelAndView mode = new ModelAndView();
		List<Property> propertyList = new ArrayList();
		String resource = "listings?";
		String resultText ="";
        Map<String, String> params = new HashMap<>();

        if (StringUtil.isNumber(search)) {
        	params.put("PostalCode" , search );
        	resultText = bridgeApiManager.getTextFromApiByPostalCode(request,resource,params);
        }
        else {
        	params.put("UnparsedAddress.in", search);
            resultText =  bridgeApiManager.getTextFromApiByAddress(request,resource,params);
        }
        propertyList = apiAnalysisManager.getPropertyList(resultText);
        
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
        mode.addObject("searchText",search);
		mode.setViewName("pages/main");
        return mode;
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
