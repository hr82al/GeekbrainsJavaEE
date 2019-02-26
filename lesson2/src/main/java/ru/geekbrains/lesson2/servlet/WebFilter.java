package ru.geekbrains.lesson2.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class WebFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(WebFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("do filter", request.getServletContext().getContextPath());
        response.setContentType("text/html; charset=UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Filter init");
    }

    @Override
    public void destroy() {
        logger.info("Filter destroy");
    }
}
