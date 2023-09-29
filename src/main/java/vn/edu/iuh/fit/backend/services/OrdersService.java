package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Orders;
import vn.edu.iuh.fit.backend.repositories.OrdersRepo;

import java.util.List;
import java.util.Optional;

public class OrdersService {
    private OrdersRepo repo;

    public OrdersService(OrdersRepo repo) {
        this.repo = repo;
    }
    public boolean insertOrder(Orders orders) {return repo.insertOrder(orders);}
    public boolean updateOrder(Orders orders) {return repo.updateOrder(orders);}
    public Optional<Orders> findOrder(long id) {return repo.findOrder(id);}
    public boolean deleteOrders(long id) {return repo.deleteOrders(id);}
    public List<Orders> getAllOrders() {return repo.getAllOrders();}

}
