package com.example.mandelnyamsite.services;

import com.example.mandelnyamsite.models.Feedback;
import com.example.mandelnyamsite.models.Product;
import com.example.mandelnyamsite.models.User;
import com.example.mandelnyamsite.repos.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, ProductService productService, UserService userService) {
        this.feedbackRepository = feedbackRepository;
        this.productService = productService;
        this.userService = userService;
    }

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public Feedback findById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }

    public List<Product> findAllProducts() {
        return productService.findAll();
    }

    public List<User> findAllUsers() {
        return userService.findAll();
    }

}
