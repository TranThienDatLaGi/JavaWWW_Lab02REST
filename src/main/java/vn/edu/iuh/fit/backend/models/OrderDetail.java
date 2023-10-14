package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orders;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "price",columnDefinition = "DOUBLE",nullable = false)
    private double price;
    @Column(name = "quantity",columnDefinition = "DOUBLE",nullable = false)
    private double quantity;
    @Column(name = "note",columnDefinition = "VARCHAR(255)",nullable = true)
    private String note;

    public OrderDetail(Order orders, Product product, double price, double quantity, String note) {
        this.orders = orders;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.note = note;
    }

    public OrderDetail(Order orders, Product product) {
        this.orders = orders;
        this.product = product;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orders=" + orders +
                ", product=" + product +
                ", price=" + price +
                ", quantity=" + quantity +
                ", note='" + note + '\'' +
                '}';
    }
}
