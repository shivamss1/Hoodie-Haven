package com.HoodieStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HoodieStore.model.Product;
import com.HoodieStore.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository pr;

    @Override
    public List<Product> getProduct() {
        return pr.findAll();
    }
    
    @Override
    public String deleteproduct(Long id) {
        pr.deleteById(id);
        return "Product has been successfully deleted.";
    }
    
    @Override
    public void updateStock(int quantity, Long id) {
        Optional<Product> product = pr.findById(id);
        if (product.isPresent()) {
            product.get().setStock(product.get().getStock() - quantity);
            pr.save(product.get());
        }
    }
    
    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = pr.findById(id);
        return product.orElse(new Product());
    }

    @Override
    public Product addproduct(Product product) {
        return pr.save(product);
    }
    
    @Override
    public List<Product> getProductsByCategory(String category) {
        return pr.findByCategory(category);
    }
}
