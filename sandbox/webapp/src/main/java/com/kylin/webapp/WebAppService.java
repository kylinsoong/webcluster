package com.kylin.webapp;

public class WebAppService {

   public String createHelloMessage(String name) {
      return "Hello " + name + "!";
   }
   
   public String pageHeader(String title) {
	   return "<html><head><title>" + title +"</title><body>";
   }
   
	public String pageFooter() {
		return "</body></html>";
	}
	
	public String contentType() {
		return "text/html";
	}

	public String servletlocation() {
		return "/webapp/servlets/index.html";
	}
	
	public String servletReturnStr() {
		return "&#160;&#160;&#160;<a href=\"/webapp/servlets/index.html\">Back</a>" ;
	}

}
