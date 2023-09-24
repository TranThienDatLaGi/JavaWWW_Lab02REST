package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.ProductStatus;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id",columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "VARCHAR(150)",name = "name",nullable = false)
    private String name;
    @Column(columnDefinition = "VARCHAR(250)",name = "description")
    private String description;
    @Column(columnDefinition = "VARCHAR(25)",name = "unit",nullable = false)
    private String unit;
    @Column(columnDefinition = "VARCHAR(100)",name = "manufactureer_name")
    private String manufacturer;
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "INT(11)",name = "status")
    @Convert(converter = ProductStatus.class)
    private ProductStatus status;

    public Product() {
    }

    public Product(String name, String description, String unit, String manufacturer, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", status=" + status +
                '}';
    }
}
