package com.pib.property.manager;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pib.property.entity.Property;
import com.pib.property.exception.FailException;
import com.pib.util.DateUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Component
public class ApiRevokeManager {

	
	@Value("${api.root.url}") 
	private String rootUrl;
	
	@Value("${api.maxRecordLimit}") 
	private int maxRecordLimit;
	
	
	
	@Autowired
	ApiCredentialsManager apiCredentialsManager;
	
    public String getTextFromApi(HttpServletRequest request,String resource,Map<String, String> requestParams) throws Exception {
    	RequestBuilder requestBuilder = RequestBuilder.get(constructApiUrl(resource));
    	String token = apiCredentialsManager.getBearerAccessToken(request);
    	requestBuilder.addHeader("Authorization", "Bearer "+token);
    	if (requestParams != null && !requestParams.isEmpty()) {
            requestParams.keySet().stream().forEach(paramName -> {
                Object paramValue = requestParams.get(paramName);
                requestBuilder.addParameter(paramName, String.valueOf(paramValue));
            });
        }
        String result = requestCrmlsApiTextByHttps(requestBuilder.build());
        if (StringUtils.isEmpty(result)) {
            throw new FailException("connection fail");
        }
        return result;
    }
  
    public String getTextFromApiByPostalCode(HttpServletRequest request,String resource,Map<String, String> requestParams) throws Exception {
    	RequestBuilder requestBuilder = RequestBuilder.get(constructApiUrl(resource));
    	String token = apiCredentialsManager.getBearerAccessToken(request);
    	requestBuilder.addHeader("Authorization", "Bearer "+token);
    	if (requestParams != null && !requestParams.isEmpty()) {
            requestParams.keySet().stream().forEach(paramName -> {
                Object paramValue = requestParams.get(paramName);
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
    
    public String constructApiUrl(String resource) throws Exception {
    	String rUrl = rootUrl + resource ;
    	return rUrl;
    }
    public JsonObject parseJsonFromApi(String resultText) throws Exception {
        JsonObject jsonObject = new Gson().fromJson(resultText, JsonObject.class);
        JsonObject result = new JsonObject();
        JsonElement data = jsonObject.get("value");
        result.add("data", data);
        result.addProperty("code", "SUCCESS");
        result.addProperty("msg", "ok");
        return result;
    }
    public String postTextFromApi(String url, HttpServletRequest request, String query) throws Exception {
        RequestBuilder requestBuilder = RequestBuilder.post(rootUrl +  url );
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
    

    

}
