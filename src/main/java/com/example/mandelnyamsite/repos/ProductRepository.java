package com.example.mandelnyamsite.repos;

import com.example.mandelnyamsite.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
