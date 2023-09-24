package vn.edu.iuh.fit.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    @Column(columnDefinition = "BIGINT(20)")
    private Product product;
    @Id
    @Column(name = "price_date", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dateTime;
    private double price;
    private String note;

    public ProductPrice(Product product, LocalDateTime dateTime, double price, String note) {
        this.product = product;
        this.dateTime = dateTime;
        this.price = price;
        this.note = note;
    }

    public ProductPrice(Product product, LocalDateTime dateTime) {
        this.product = product;
        this.dateTime = dateTime;
    }

    public ProductPrice() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product=" + product +
                ", dateTime=" + dateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
