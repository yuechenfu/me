package com.pib.property.manager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pib.property.exception.FailException;
import com.pib.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;


@Component
public class ApiCredentialsManager {

    @Value("${api.client.id}") 
    private String clientId ;
	
	@Value("${api.client.secret}") 
	private String clientSecret;
	
	@Value("${api.root.tokenUrl}") 
	private String tokenUrl;
	

	public String getBearerAccessToken(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String result ="";
		JsonObject token =(JsonObject)session.getAttribute("Access_token");
		System.out.println("session token ="+token);
		if (token == null || isExpired(token)) {
			result = parseStringFromJson(createNewBearerAccessToken(request));
			System.out.println("session isExpired");
		}else {
			result = token.get("access_token").getAsString();
		}
		return result;
		
	}
	public String createNewBearerAccessToken(HttpServletRequest request)  throws Exception{
		RequestBuilder requestBuilder = RequestBuilder.post(tokenUrl);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
        nvps.add(new BasicNameValuePair("grant_type", "client_credentials")); 
        nvps.add(new BasicNameValuePair("scope", "ODataApi")); 
        nvps.add(new BasicNameValuePair("client_id", clientId)); 
        nvps.add(new BasicNameValuePair("client_secret", clientSecret)); 
        requestBuilder.setEntity(new UrlEncodedFormEntity(nvps, "utf-8")); 
        String result = requestCrmlsApiTextByHttps(requestBuilder.build());
        if (StringUtils.isEmpty(result)) {
            throw new FailException("connection fail");
        }
        saveTokenToSession(request,result);
        return  result;
	}
	
	public void saveTokenToSession(HttpServletRequest request,String resultText) throws Exception {
		HttpSession session = request.getSession();
        JsonObject jsonObject = new Gson().fromJson(resultText, JsonObject.class);
        JsonObject result = new JsonObject();
        Date time = new Date();
        result.addProperty("access_token", jsonObject.get("access_token").getAsString());
        result.addProperty("expires_in",  DateUtil.getSecondTimestampTwo(time) + 3600);
        result.addProperty("token_type", jsonObject.get("token_type").getAsString());
        session.setAttribute("Access_token", result);
    }
	public boolean isExpired(JsonObject json) {
		int currentSecond = DateUtil.getSecondTimestampTwo(new Date());
		int SessionSecond = json.get("expires_in").getAsInt();
		System.out.println("currentSecond="+currentSecond+",SessionSecond="+SessionSecond);
		
		if( currentSecond < SessionSecond) return false;
		return true;
	}
	public String parseStringFromJson(String resultText) throws Exception {
        JsonObject jsonObject = new Gson().fromJson(resultText, JsonObject.class);
        return jsonObject.get("access_token").getAsString();
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
