package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.repositories.CustomerDAO;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final CustomerDAO repo=new CustomerDAO();

    public CustomerService() {

    }

    public boolean insertCustomer(Customer customer) {
        return repo.insertCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) {
        return repo.updateCustomer(customer);
    }

    public Optional<Customer> finCustomer(long id) {
        return repo.finCustomer(id);
    }

    public boolean deleteCustomer(long id) {
        return repo.deleteCustomer(id);
    }

    public List<Customer> getAllCusTomer() {
        return repo.getAllCusTomer();
    }
}
