package vn.edu.iuh.fit.frontend.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.repositories.CustomerDAO;
import vn.edu.iuh.fit.backend.services.CustomerService;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

public class CustomerModel {
    private final CustomerService customerService = new CustomerService();

    public CustomerModel() {
    }

    public void getCustomerList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Customer> list = customerService.getAllCusTomer();
        req.getSession().setAttribute("listCustomer",list);
        resp.sendRedirect("listCustomer.jsp");
    }
    public void getCusTomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       long id=Long.parseLong(req.getParameter("id"));
        Customer customer=customerService.finCustomer(id).get();
        req.getSession().setAttribute("customer",customer);
        resp.sendRedirect("updateCustomer.jsp");
    }
    public void addCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name=req.getParameter("name").trim();
        String email=req.getParameter("email").trim();
        String phone=req.getParameter("phone").trim();
        String address=req.getParameter("address").trim();
        Customer customer= new Customer(name,email,phone,address);
        if(customerService.insertCustomer(customer)){
            getCustomerList(req, resp);
            return;
        }
//        req.getSession().setAttribute("customer",customer);
        resp.sendRedirect("addCustomer.jsp");
    }
    public void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id=Long.parseLong(req.getParameter("id"));
        String name=req.getParameter("name").trim();
        String email=req.getParameter("email").trim();
        String phone=req.getParameter("phone").trim();
        String address=req.getParameter("address").trim();
        Customer customer= new Customer(name,email,phone,address);
        if(customerService.insertCustomer(customer)){
            getCustomerList(req, resp);
            return;
        }
//        req.getSession().setAttribute("customer",customer);
        resp.sendRedirect("updateCustomer.jsp");
    }

}
