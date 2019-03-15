package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.servlet.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "order")
@SessionScoped
public class OrderBean {
    private Logger logger = LoggerFactory.getLogger(OrderBean.class);
    private List<Product> orders = new LinkedList<>();

    @Inject
    private Cart cart;

    public Collection<Product> getProductList() {
        return cart.getAll();
    }

    public String doOrder(Product product) {
        cart.add(product);
        logger.info("Ordered {}", product.getName());
        return "/index.xhtml?faces-redirect=true";
    }

    public String doDelete(Product product) {
        cart.delete(product);
        logger.info("Deleted {}", product.getName());
        return "/orders.xhtml?faces-redirect=true";
    }
}
