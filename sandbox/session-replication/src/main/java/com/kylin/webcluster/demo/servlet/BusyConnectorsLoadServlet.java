package com.kylin.webcluster.demo.servlet;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.HeadMethod;

@WebServlet("/connectors")
public class BusyConnectorsLoadServlet extends LoadServlet {

    private static final long serialVersionUID = -946741803216943778L;

    private static final String END = "end";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String parameter = request.getParameter(END);

        if (parameter == null) {
            int duration = Integer.parseInt(this.getParameter(request, DURATION, "15")) * 1000;

            long end = System.currentTimeMillis() + duration;

            String url = this.createLocalURL(request, Collections.singletonMap(END, String.valueOf(end)));
            Runnable task = new ExecuteMethodTask(url);

            int count = Integer.parseInt(this.getParameter(request, COUNT, "50"));

            this.log("Sending " + count + " concurrent requests to: " + url);

            Thread[] threads = new Thread[count];

            for (int i = 0; i < count; ++i) {
                threads[i] = new Thread(task);
            }

            for (int i = 0; i < count; ++i) {
                threads[i].start();
            }

            for (int i = 0; i < count; ++i) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            this.writeLocalName(request, response);
        } else {
            long end = Long.parseLong(parameter);

            if (end > System.currentTimeMillis()) {
                String url = this.createLocalURL(request, Collections.singletonMap(END, String.valueOf(end)));
                response.setStatus(307);
                response.setHeader("location", response.encodeRedirectURL(url));
            }
        }
    }

    private class ExecuteMethodTask implements Runnable {
        private final String url;

        ExecuteMethodTask(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            HttpClient client = new HttpClient();
            String url = this.url;

            try {
                while (url != null) {
                    HttpMethod method = new HeadMethod(url);
                    // Disable auto redirect following, to allow circular redirect
                    method.setFollowRedirects(false);

                    int code = client.executeMethod(method);

                    url = (code == 307) ? method.getResponseHeader("location").getValue() : null;
                }
            } catch (HttpException e) {
                BusyConnectorsLoadServlet.this.log(e.getLocalizedMessage(), e);
            } catch (IOException e) {
                BusyConnectorsLoadServlet.this.log(e.getLocalizedMessage(), e);
            }
        }
    }
}
