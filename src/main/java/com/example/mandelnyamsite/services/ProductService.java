package com.example.mandelnyamsite.services;

import com.example.mandelnyamsite.models.Category;
import com.example.mandelnyamsite.models.Product;
import com.example.mandelnyamsite.models.Supplier;
import com.example.mandelnyamsite.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService, SupplierService supplierService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Category> findAllCategorys() {
        return categoryService.findAll();
    }

    public List<Supplier> findAllSuppliers() {
        return supplierService.findAll();
    }

}
