package com.kylin.webcluster.demo.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.HeadMethod;

@WebServlet("/sessions")
public class ActiveSessionsLoadServlet extends LoadServlet {
	
    private static final long serialVersionUID = -946741803216943778L;

    @Override
    protected void doHead(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        this.log("Handling session load request from: " + request.getRequestURL().toString() + ", using session id: " + session.getId());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int count = Integer.parseInt(this.getParameter(request, COUNT, "20"));

        String url = this.createLocalURL(request, null);

        this.log("Sending " + count + " requests to: " + url);

        for (int i = 0; i < count; ++i) {
            HttpClient client = new HttpClient();
            HttpMethod method = new HeadMethod(url);
            client.executeMethod(method);
        }

        this.writeLocalName(request, response);
    }
}
