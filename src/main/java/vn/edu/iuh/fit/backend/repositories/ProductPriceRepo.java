package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.ProductPrice;

import java.util.List;
import java.util.Optional;

public class ProductPriceRepo {
    private EntityManager em;
    private EntityManagerFactory emf;
    private EntityTransaction trans;
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceRepo() {
        em= Persistence.createEntityManagerFactory("default").createEntityManager();
        trans=em.getTransaction();
    }

    public boolean insertProductPrice(ProductPrice productPrice){
        try {
            trans.commit();
            em.persist(productPrice);
            trans.commit();
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            trans.rollback();
        }
        return false;
    }
    public boolean updateProductPrice(ProductPrice productPrice){
        try {
            trans.commit();
            em.merge(productPrice);
            trans.commit();
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public Optional<ProductPrice> findProductPrice(long id) {
        TypedQuery<ProductPrice> query = em.createQuery("select o from ProductPrice o where o.id=:id", ProductPrice.class);
        query.setParameter("id", id);
        ProductPrice productPrice = query.getSingleResult();
        return productPrice == null ? Optional.empty() : Optional.of(productPrice);
    }

    public boolean deleteProductPrice(long id) {
        Optional<ProductPrice> op = findProductPrice(id);
        ProductPrice productPrice = op.isPresent() ? op.get() : null;
        if (productPrice == null) return false;
        try {
            trans.begin();
            em.remove(productPrice);
            trans.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public List<ProductPrice> getAllProductPrice() {
        try {
            trans.begin();
            List<ProductPrice> list = em.createNativeQuery("SELECT * from product_price ", ProductPrice.class).getResultList();
            trans.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        }
        return null;
    }
}
