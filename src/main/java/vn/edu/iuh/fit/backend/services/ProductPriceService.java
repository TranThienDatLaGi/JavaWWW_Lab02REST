package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.ProductPrice;
import vn.edu.iuh.fit.backend.repositories.ProductPriceRepo;

import java.util.List;
import java.util.Optional;

public class ProductPriceService {
    private ProductPriceRepo repo;

    public ProductPriceService(ProductPriceRepo repo) {
        this.repo = repo;
    }

    public boolean insertProductPrice(ProductPrice productPrice) {
        return repo.insertProductPrice(productPrice);
    }

    public boolean updateProductPrice(ProductPrice productPrice) {
        return repo.updateProductPrice(productPrice);
    }

    public Optional<ProductPrice> findProductPrice(long id) {
        return repo.findProductPrice(id);
    }

    public boolean deleteProductPrice(long id) {
        return repo.deleteProductPrice(id);
    }

    public List<ProductPrice> getAllProductPrice() {
        return repo.getAllProductPrice();
    }
}
