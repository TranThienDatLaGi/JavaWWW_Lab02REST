package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", columnDefinition = "BIGINT(20)")
    private long id;
    @Column(columnDefinition = "VARCHAR(250)")
    private String path;
    @Column(columnDefinition = "VARCHAR(250)")
    private String alternative;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImage(long id, String path, String alternative, Product product) {
        this.id = id;
        this.path = path;
        this.alternative = alternative;
        this.product = product;
    }

    public ProductImage() {
    }

    public long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Product_Image{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                ", product=" + product +
                '}';
    }
}
