package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.OrderDAO;

import java.util.List;
import java.util.Optional;

public class OrderService {
    private final OrderDAO repo=new OrderDAO();

    public OrderService() {

    }
    public boolean insertOrder(Order orders) {return repo.insertOrder(orders);}
    public boolean updateOrder(Order orders) {return repo.updateOrder(orders);}
    public Optional<Order> findOrder(long id) {return repo.findOrder(id);}
    public boolean deleteOrders(long id) {return repo.deleteOrders(id);}
    public List<Order> getAllOrders() {return repo.getAllOrders();}

}
