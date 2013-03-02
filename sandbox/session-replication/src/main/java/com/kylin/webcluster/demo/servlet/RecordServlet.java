package com.kylin.webcluster.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/record")
public class RecordServlet extends LoadServlet {

    private static final long serialVersionUID = -4143320241936636855L;

    private static final String DESTROY = "destroy";
    private static final String TIMEOUT = "timeout";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        boolean destroy = Boolean.valueOf(request.getParameter(DESTROY));

        if (destroy) {
            session.invalidate();
        } else {
            String timeout = request.getParameter(TIMEOUT);

            if (timeout != null) {
                session.setMaxInactiveInterval(Integer.valueOf(timeout));
            }
        }

        response.setHeader("X-ClusterNode", this.getJvmRoute());

        this.writeLocalName(request, response);
    }
}
