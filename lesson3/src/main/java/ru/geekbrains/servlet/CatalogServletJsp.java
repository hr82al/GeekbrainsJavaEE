package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CatalogServletJsp", urlPatterns = "/catalog_jsp")
public class CatalogServletJsp extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(CatalogServletJsp.class);
    private ProductRepository repository = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        // помещаем список продуктов в аттрибут запроса
        // это более правильно чем использовать тут аттрибут сервлета через getServletContext()
        // или аттрибут сессии через getSession()
        req.setAttribute("products", repository.getAll());
        getServletContext().getRequestDispatcher("/catalog.jsp").forward(req, resp);
    }
}
