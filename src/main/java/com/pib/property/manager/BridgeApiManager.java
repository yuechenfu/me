package com.pib.property.manager;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pib.property.entity.PropertyFilterCondition;
import com.pib.property.exception.FailException;
import com.pib.property.log.LogUtil;
import com.pib.util.StringUtil;
 
 
@Component
public class BridgeApiManager {
	
	@Value("${api.bridge.rootUrl}")
    private String rootUrl;
	
	@Value("${api.bridge.dataset}")
    private String dataset;
	
	@Value("${api.bridge.token}")
    private String token;
	
	@Value("${api.bridge.maxRecordLimit}")
    private String maxRecordLimit;
	
	@Value("${api.bridge.resource}")
	private String resource;
	
	public JsonObject parseJsonFromApi(String resultText) throws Exception {
        JsonObject jsonObject = new Gson().fromJson(resultText, JsonObject.class);
        JsonObject result = new JsonObject();
        JsonElement data = jsonObject.get("data");
        result.add("data", data);
        result.addProperty("code", "SUCCESS");
        result.addProperty("msg", "ok");
        return result;
    }

    public String getTextFromApi(String resource, HttpServletRequest request, Map<String, String> requestParams) throws Exception {
        RequestBuilder requestBuilder = RequestBuilder.get(constructApiUrl(resource));
        if (requestParams != null && !requestParams.isEmpty()) {
            requestParams.keySet().stream().forEach(paramName -> {
                Object paramValue = requestParams.get(paramName);
                requestBuilder.addParameter(paramName, String.valueOf(paramValue));
            });
        }
        setHeader(request, requestBuilder);
        String result = requestCrmlsApiTextByHttps(requestBuilder.build());
       
        if (StringUtils.isEmpty(result)) {
            throw new FailException("connection fail");
        }
        return result;
    }
    
    public String getTextFromApiByCondition(HttpServletRequest request,PropertyFilterCondition condition) throws Exception {
    	RequestBuilder requestBuilder = RequestBuilder.get(constructApiUrl(resource));
    	Map<String, String> params = mergeCondition(condition);
    	if (params != null && !params.isEmpty()) {
    		params.keySet().stream().forEach(paramName -> {
                Object paramValue = params.get(paramName);
                requestBuilder.addParameter(paramName, String.valueOf(paramValue));
            });
        }
        String result = requestCrmlsApiTextByHttps(requestBuilder.build());
        if (StringUtils.isEmpty(result)) {
            throw new FailException("connection fail");
        }
        System.out.println("requestBuilder.build()="+requestBuilder.build());
        
        return result;
    }
    
    public Map<String, String> mergeCondition(PropertyFilterCondition condition){
    	Map<String, String> params = new HashMap<>();
    	if(StringUtil.isNumber(condition.getSearchText()))params.put("PostalCode" , condition.getSearchText() );
    	else params.put("UnparsedAddress.in", condition.getSearchText());
    	if(condition.getListType() !=null) {
    		for(String list_type:condition.getListType()) {
    			switch (list_type) {
    			  case  "ForSale" :
    			      params.put("StandardStatus", "Active");
    			  case  "Sold" :
        			  params.put("StandardStatus", "Closed");
    			  case  "Pending" :
        			  params.put("StandardStatus", "Pending");  	  
    			}
    			 
    		}
    	}
    	
    	return params;
    	
    }
    
    public String postTextFromApi(String resource, HttpServletRequest request, String query) throws Exception {
        RequestBuilder requestBuilder = RequestBuilder.post(constructApiUrl(resource));
        setHeader(request, requestBuilder);
        HttpEntity httpEntity = new StringEntity(query);
        requestBuilder.setEntity(httpEntity);
        String result = requestCrmlsApiTextByHttps(requestBuilder.build());
        if (StringUtils.isEmpty(result)) {
            throw new FailException("connection fail");
        }
        return result;
    }

    public void setHeader(HttpServletRequest request, RequestBuilder requestBuilder) {
        Enumeration<?> enu = request.getHeaderNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            String value = request.getHeader(name);
            if (value != null) {
                requestBuilder.addHeader(name, value);
            }

        }
    }

    public String requestCrmlsApiTextByHttps(HttpUriRequest httpUriRequest) throws IOException {
        httpUriRequest.removeHeaders(HTTP.CONTENT_LEN);
        String responseText = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (certificate, authType) -> true).build();
            client = HttpClients.custom().setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
            response = client.execute(httpUriRequest);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) response.close();
                if (client != null) client.close();
            } catch (IOException e) {
            }
        }
        return responseText;
    }
    

 
    
    public String constructApiUrl(String resource) throws Exception {
    	String rUrl = rootUrl + dataset + resource +"access_token="+token+"&limit="+maxRecordLimit;
    	return rUrl;
    }
}
