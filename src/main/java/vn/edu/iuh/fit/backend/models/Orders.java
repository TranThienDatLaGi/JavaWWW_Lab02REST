package vn.edu.iuh.fit.backend.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name = "order_date",nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Orders() {
    }

    public Orders(LocalDateTime dateTime, Customer customer, Employee employee) {
        this.dateTime = dateTime;
        this.customer = customer;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }
}
