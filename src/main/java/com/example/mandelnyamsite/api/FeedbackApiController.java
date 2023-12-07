package com.example.mandelnyamsite.api;

import com.example.mandelnyamsite.models.Feedback;
import com.example.mandelnyamsite.services.FeedbackService;
import com.example.mandelnyamsite.services.ProductService;
import com.example.mandelnyamsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackApiController {

    private final FeedbackService feedbackService;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public FeedbackApiController(FeedbackService feedbackService, ProductService productService, UserService userService) {
        this.feedbackService = feedbackService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.findAll();
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable Long id) {
        return feedbackService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback updatedFeedback) {
        // Проверка существования отзыва с заданным id
        Feedback existingFeedback = feedbackService.findById(id);
        if (existingFeedback == null) {
            return ResponseEntity.notFound().build();
        }

        // Обновление полей отзыва
        existingFeedback.setFeedbackText(updatedFeedback.getFeedbackText());

        // Проверка и обновление связанного пользователя
        if (updatedFeedback.getUser() != null) {
            existingFeedback.setUser(updatedFeedback.getUser());
        }

        // Проверка и обновление связанного продукта
        if (updatedFeedback.getProduct() != null) {
            existingFeedback.setProduct(updatedFeedback.getProduct());
        }

        // Сохранение обновленного отзыва
        Feedback updatedFeedbackData = feedbackService.saveFeedback(existingFeedback);

        return ResponseEntity.ok(updatedFeedbackData);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteById(id);
    }
}