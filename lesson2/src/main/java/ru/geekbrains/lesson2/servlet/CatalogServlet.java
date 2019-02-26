package ru.geekbrains.lesson2.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatalogServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(CatalogServlet.class);
    private static final String title = "Товары";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("<title>" + title + "</title>");
        resp.getWriter().print(MainServlet.page);
    }
}
