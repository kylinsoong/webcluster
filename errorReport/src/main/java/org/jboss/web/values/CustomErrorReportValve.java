package org.jboss.web.values;

import java.io.IOException;
import java.io.Writer;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.util.RequestUtil;
import org.apache.catalina.valves.ErrorReportValve;

public class CustomErrorReportValve extends ErrorReportValve {

	protected void report(Request request, Response response, Throwable throwable) {
		int statusCode = response.getStatus();  
        if ((statusCode < 400) || (response.getContentCount() > 0)) {  
            return;  
        }  
        String message = RequestUtil.filter(response.getMessage());  
        if (message == null) {  
            message = "";  
        }  
        StringBuffer sb = new StringBuffer();  
        sb.append("<html><head><title>");  
        sb.append(sm.getString("errorReportValve.statusHeader", "" + statusCode, message));  
        sb.append("</title>");  
//        sb.append("<style><!--");  
//        sb.append(org.apache.catalina.util.TomcatCSS.TOMCAT_CSS);  
//        sb.append("--></style> ");  
        sb.append("</head><body>");  
//        sb.append("<h1>");  
//        sb.append(sm.getString("errorReportValve.statusHeader", "" + statusCode, message));  
//        sb.append("</h1>");  
        sb.append("</body></html>");  
        try {  
            try {  
                response.setContentType("text/html");  
                response.setCharacterEncoding("utf-8");  
            } catch (Throwable t) {  
                if (container.getLogger().isDebugEnabled())  
                    container.getLogger().debug("status.setContentType", t);  
            }  
            Writer writer = response.getReporter();  
            if (writer != null) {  
                // If writer is null, it's an indication that the response has  
                // been hard committed already, which should never happen  
                writer.write(sb.toString());  
            }  
        } catch (IOException e) {  
            ;  
        } catch (IllegalStateException e) {  
            ;  
        }  
	}

}
