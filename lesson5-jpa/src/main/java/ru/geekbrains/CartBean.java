package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persistance.CartRepository;
import ru.geekbrains.persistance.entity.Cart;
import ru.geekbrains.persistance.entity.Category;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;


@Named("cart")
@SessionScoped
public class CartBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(CartBean.class);

    @Inject
    private CartRepository cartRepository;

    // наличие такого поля для хранения текущего элемента является стандартным для JSF
    private Cart cart;

    private Collection<Cart> cartList;

    public void preloadCartList(ComponentSystemEvent event) throws AbortProcessingException {
        boolean postback = FacesContext.getCurrentInstance().isPostback();
        boolean ajaxRequest = FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest();

        logger.info("Preloading products from database cart postback={}, ajaxrequest={}", postback, ajaxRequest);

        cartList = cartRepository.getAll();
    }

    public Cart getProduct() {
        return this.cart;
    }

    public void setProduct(Cart cart) {
        this.cart = cart;
    }

    public Collection<Cart> getProductList() {
        logger.info("Get product list");
        return cartList;
    }

    public void newCartAction() {
        Cart prod = new Cart();
    }

    public void deleteAction(Cart cart) {
        logger.info("Delete product");
        cartRepository.remove(cart);
    }
}
