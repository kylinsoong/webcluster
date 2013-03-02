package com.kylin.webcluster.demo.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

@WebServlet("/receive")
public class ReceiveTrafficLoadServlet extends LoadServlet {

    private static final long serialVersionUID = 2344830128026153418L;
    private static final String SIZE = "size";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int duration = Integer.parseInt(this.getParameter(request, DURATION, DEFAULT_DURATION));

        int size = Integer.parseInt(this.getParameter(request, SIZE, "100")) * 1024;

        HttpClient client = new HttpClient();
        RequestEntity entity = new ByteArrayRequestEntity(new byte[size]);

        String url = this.createLocalURL(request, null);

        for (int i = 0; i < duration; ++i) {
            long start = System.currentTimeMillis();

            this.log("Sending " + (size / 1024) + "KB packet to: " + url);

            PutMethod method = new PutMethod(url);
            method.setRequestEntity(entity);
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
