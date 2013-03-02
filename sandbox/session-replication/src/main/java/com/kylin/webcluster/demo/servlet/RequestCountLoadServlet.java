package com.kylin.webcluster.demo.servlet;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

@WebServlet("/requests")
public class RequestCountLoadServlet extends LoadServlet {
    
    private static final long serialVersionUID = -5001091954463802789L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int count = Integer.parseInt(this.getParameter(request, COUNT, "50"));

        if (count > 1) {
            String url = this.createLocalURL(request, Collections.singletonMap(COUNT, String.valueOf(count - 1)));

            this.log("Sending request count request to: " + url);

            HttpClient client = new HttpClient();
            HttpMethod method = new GetMethod(url);
            client.executeMethod(method);
        }

        this.writeLocalName(request, response);
    }
}
