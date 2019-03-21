package ru.geekbrains.persistance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persistance.entity.Cart;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collection;


@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class CartRepository extends AbstractRepository<Cart> implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(CartRepository.class);

    @Override
    public Cart getById(long id) {
        return entityManager.find(Cart.class, id);
    }

    @Override
    public Collection<Cart> getAll() {
        logger.info("Fetching All Products in cart");
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cart> query = builder.createQuery(Cart.class);
        Root<Cart> from = query.from(Cart.class);
        query.select(from);
        return entityManager.createQuery(query).getResultList();
    }

    @SuppressWarnings("unchecked")
    public Collection<Cart> getByCategory(long categoryId) {
        logger.info("Fetching Products by Category with id {}", categoryId);
        return entityManager.createQuery("select p from Product p where p.category.id = :id")
                .setParameter("id", categoryId)
                .getResultList();
    }
}
