package com.admin.model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:application.properties"})
public class EmailGridTemplate {
	
	@Value("${server.ip}") 
    private String url ;
	@Value("${server.servlet.context-path}") 
	private String path;
	
	/**
	 * 新用户注册，系统发送email
	 * @return 
	 */
	public  String getNewSeekerTemplate(HttpServletRequest request){
		String imgHeaderUrl  = "http://"+url + path+"/images"+ "/header.png" ;
		String imgBodyUrl  = "http://"+url + path+"/images"+ "/seeker.png" ;
		String imgFooterUrl  = "http://"+url + path+"/images"+ "/footer.png" ;
    	StringBuilder sb = new StringBuilder();
    	sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Welcome to Talentscamp !</title>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		sb.append("<style type=\"text/css\">");
		sb.append("TABLE{border-collapse:collapse;border-left:solid 1 #000000; border-top:solid 1 #000000;padding:5px;}");
		sb.append("TH{border-right:solid 1 #000000;border-bottom:solid 1 #000000;}");
		sb.append("TD{font:normal;border-right:solid 1 #000000;border-bottom:solid 1 #000000;}");
		sb.append("</style></head>");
		sb.append("<body bgcolor=\"#FFF8DC\">");
		sb.append("<div align=\"center\">");
		sb.append("<img src=\""+imgHeaderUrl+"\"/>");
		sb.append("<br/>");
		sb.append("<img src=\""+imgBodyUrl+"\"/>");
		sb.append("<br/>");
		sb.append("<img src=\""+imgFooterUrl+"\"/>");
		sb.append("</div></body></html>");
		return sb.toString();
    }
	
	/**
	 * 新雇主注册，系统发送email
	 * @return 
	 */
	public  String getNewEmployerTemplate(HttpServletRequest request){
		String imgHeaderUrl  = "http://"+url + path+"/images"+ "/header.png" ;
		String imgBodyUrl  = "http://"+url + path+"/images"+ "/employer.png" ;
		String imgFooterUrl  = "http://"+url + path+"/images"+ "/footer.png" ;
    	StringBuilder sb = new StringBuilder();
    	sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Welcome to Talentscamp !</title>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		sb.append("<style type=\"text/css\">");
		sb.append("TABLE{border-collapse:collapse;border-left:solid 1 #000000; border-top:solid 1 #000000;padding:5px;}");
		sb.append("TH{border-right:solid 1 #000000;border-bottom:solid 1 #000000;}");
		sb.append("TD{font:normal;border-right:solid 1 #000000;border-bottom:solid 1 #000000;}");
		sb.append("</style></head>");
		sb.append("<body bgcolor=\"#FFF8DC\">");
		sb.append("<div align=\"center\">");
		sb.append("<img src=\""+imgHeaderUrl+"\"/>");
		sb.append("<br/>");
		sb.append("<img src=\""+imgBodyUrl+"\"/>");
		sb.append("<br/>");
		sb.append("<img src=\""+imgFooterUrl+"\"/>");
		sb.append("</div></body></html>");
		return sb.toString();
    }
}
