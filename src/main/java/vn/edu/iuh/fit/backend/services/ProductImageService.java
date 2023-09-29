package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.repositories.ProductImageRepo;

import java.util.List;
import java.util.Optional;

public class ProductImageService {
    private ProductImageRepo repo;

    public ProductImageService(ProductImageRepo repo) {
        this.repo = repo;
    }

    public boolean insertProductImage(ProductImage productImage) {
        return repo.insertProductImage(productImage);
    }

    public boolean updateProductImage(ProductImage productImage) {
        return repo.updateProductImage(productImage);
    }

    public Optional<ProductImage> findProductImage(long id) {
        return repo.findProductImage(id);
    }

    public boolean deleteProductImage(long id) {
        return repo.deleteProductImage(id);
    }

    public List<ProductImage> getAllProductImages() {
        return repo.getAllProductImages();
    }
}
