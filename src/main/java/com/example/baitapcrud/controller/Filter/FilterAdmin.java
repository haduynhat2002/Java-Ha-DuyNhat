package com.example.baitapcrud.controller.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterAdmin implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) request;
        HttpSession session = httpServletRequest.getSession();
        boolean havePermission = false;
        if (session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            System.out.println("Hello user: " + username );
            if (username.equals("admin")) {
                havePermission = true;
            }
        }
        if (havePermission) {
            chain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            httpServletResponse.getWriter().println("Permission denied!");
        }

    }
}
