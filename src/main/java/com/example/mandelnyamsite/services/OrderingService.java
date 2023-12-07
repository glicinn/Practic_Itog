package com.example.mandelnyamsite.services;

import com.example.mandelnyamsite.models.Ordering;
import com.example.mandelnyamsite.models.Product;
import com.example.mandelnyamsite.models.User;
import com.example.mandelnyamsite.repos.OrderingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderingService {

    private final OrderingRepository orderingRepository;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public OrderingService(OrderingRepository orderingRepository, ProductService productService, UserService userService) {
        this.orderingRepository = orderingRepository;
        this.productService = productService;
        this.userService = userService;
    }

    public List<Ordering> findAll() {
        return orderingRepository.findAll();
    }

    public Ordering findById(Long id) {
        return orderingRepository.findById(id).orElse(null);
    }

    public Ordering saveOrdering(Ordering ordering) {
        return orderingRepository.save(ordering);
    }

    public void deleteById(Long id) {
        orderingRepository.deleteById(id);
    }

    public List<Product> findAllProducts() {
        return productService.findAll();
    }

    public List<User> findAllUsers() {
        return userService.findAll();
    }

}
