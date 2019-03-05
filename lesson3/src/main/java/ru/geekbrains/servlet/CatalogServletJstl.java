package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CatalogServletJstl", urlPatterns = "/catalog_jstl")
public class CatalogServletJstl extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(CatalogServletJstl.class);
    private ProductRepository  repository = new ProductRepository();

    @Override
    public void init() throws ServletException {
        logger.info("Servlet init {}", getClass().getSimpleName());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        getServletContext().setAttribute("products", repository.getAll());
        getServletContext().getRequestDispatcher("/catalog-jstl.jsp").forward(req, resp);
    }
}
