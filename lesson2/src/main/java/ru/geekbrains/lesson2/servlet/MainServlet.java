package ru.geekbrains.lesson2.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    public static final String page = "<ul>\n" +
            "    <li><a href=\"main\">Главная</a></li>\n" +
            "    <li><a href=\"catalog\">Товары</a></li>\n" +
            "    <li><a href=\"product\">Товар</a></li>\n" +
            "    <li><a href=\"cart\">Корзина</a></li>\n" +
            "    <li><a href=\"order\">Заказ</a></li>\n" +
            "</ul>";
    private static final Logger logger = LoggerFactory.getLogger(MainServlet.class);
    private static final String title = "Главная";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        resp.getWriter().println("<title>" + title + "</title>");
        resp.getWriter().print(page);
    }
}
