package org.garvk.ecombackend.service;

import org.garvk.ecombackend.model.Product;
import org.garvk.ecombackend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Integer aInId) {

        return productRepo.findById(aInId).orElse(null);

    }
}
