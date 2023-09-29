package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Orders;

import java.util.List;
import java.util.Optional;

public class OrdersRepo {
    private EntityManager em;
    private EntityManagerFactory emf;
    private EntityTransaction trans;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrdersRepo() {
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
        trans = em.getTransaction();
    }

    public boolean insertOrder(Orders orders) {
        try {
            trans.begin();
            em.persist(orders);
            trans.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public boolean updateOrder(Orders orders) {
        try {
            trans.begin();
            em.merge(orders);
            trans.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public Optional<Orders> findOrder(long id) {
        TypedQuery<Orders> query = em.createQuery("select o from Orders o where o.id=:id", Orders.class);
        query.setParameter("id", id);
        Orders orders = query.getSingleResult();
        return orders == null ? Optional.empty() : Optional.of(orders);
    }

    public boolean deleteOrders(long id) {
        Optional<Orders> op = findOrder(id);
        Orders orders = op.isPresent() ? op.get() : null;
        if (orders == null) return false;
        try {
            trans.begin();
            em.remove(orders);
            trans.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        }
        return false;
    }

    public List<Orders> getAllOrders() {
        try {
            trans.begin();
            List<Orders> list = em.createNativeQuery("SELECT * from orders ", Orders.class).getResultList();
            trans.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        }
        return null;
    }
}
