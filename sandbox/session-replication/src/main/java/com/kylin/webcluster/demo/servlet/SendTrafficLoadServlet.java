package com.kylin.webcluster.demo.servlet;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;

@WebServlet("/send")
public class SendTrafficLoadServlet extends LoadServlet {
   
    private static final long serialVersionUID = -8586013739155819909L;
    private static final String SIZE = "size";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int size = Integer.parseInt(request.getParameter(SIZE)) * 1024;

        this.log("Writing " + (size / 1024) + "KB blob to response for: " + request.getRequestURL().toString());

        response.getOutputStream().write(new byte[size]);
        response.flushBuffer();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int duration = Integer.parseInt(this.getParameter(request, DURATION, DEFAULT_DURATION));

        String size = this.getParameter(request, SIZE, "100");
        String url = this.createLocalURL(request, Collections.singletonMap(SIZE, size));

        HttpClient client = new HttpClient();
        HttpMethod method = new PostMethod(url);

        for (int i = 0; i < duration; ++i) {
            this.log("Sending send traffic load request to: " + url);

            long start = System.currentTimeMillis();

            client.executeMethod(method);

            long ms = 1000 - (System.currentTimeMillis() - start);

            if (ms > 0) {
                try {
                    Thread.sleep(ms);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        this.writeLocalName(request, response);
    }
}
