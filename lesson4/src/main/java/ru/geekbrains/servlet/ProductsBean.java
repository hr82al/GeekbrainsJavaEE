package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.servlet.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.Collection;

@ManagedBean(name = "products")
@SessionScoped
public class ProductsBean {
    private Logger logger = LoggerFactory.getLogger(ProductsBean.class);
    private Product product;

    @Inject
    private ProductRepository repository;

    public String getId() {
        return product.getId();
    }

    public void setId(String id) {
        product.setId(id);
    }

    public String getName() {
        return product.getName();
    }

    public void setName(String name) {
        product.setName(name);
    }

    public int getPrice() {
        return product.getPrice();
    }

    public void setPrice(int price) {
        product.setPrice(price);
    }

    public Collection<Product> getProductList() {
        return repository.getAll();
    }

    public String doEdit(Product product) {
        logger.info("Edit product with id {} and name {}", product.getId(), product.getName());
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public String doDelete(Product product) {
        repository.delete(product);
        logger.info("Deleting {}", product.getName());
        return "/index.xhtml?faces-redirect=true";
    }

    public String saveProduct() {
        repository.merge(product);
        return "/index.xhtml?faces-redirect=true";
    }
}
