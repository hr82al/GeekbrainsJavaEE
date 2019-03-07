package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.servlet.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс-заглушка для репозитория
 * через несколько уроков мы его заменим на
 * полноценный JPA репозиторий
 */
@ApplicationScoped
public class ProductRepository {
    private Logger logger = LoggerFactory.getLogger(ProductRepository.class);
    private AtomicInteger sequence = new AtomicInteger();
    private Map<String, Product> productMap = Collections.synchronizedMap(new LinkedHashMap<>());

    public ProductRepository() {
        this.merge(new Product("1", "Pen", 50, "канцтовары"));
        this.merge(new Product("2", "Pencil", 150, "канцтовары"));
        this.merge(new Product("3", "Textbook", 200, "канцтовары"));
        this.merge(new Product("4", "Paper", 500, "канцтовары"));
    }

    public Collection<Product> getAll() {
        return productMap.values();
    }

    public Product getById(String id) {
        return productMap.get(id);
    }

    public void delete(Product product) {
        productMap.values().remove(product);
    }

    public void merge(Product product) {
        if (product.getId() == null || !productMap.containsKey(product.getId())) {
            product.setId(String.valueOf(sequence.incrementAndGet()));
        }
        productMap.put(product.getId(), product);
    }
}
