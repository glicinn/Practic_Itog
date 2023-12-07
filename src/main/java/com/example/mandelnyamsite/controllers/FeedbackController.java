package com.example.mandelnyamsite.controllers;

import com.example.mandelnyamsite.models.Feedback;
import com.example.mandelnyamsite.models.Product;

import com.example.mandelnyamsite.models.User;
import com.example.mandelnyamsite.services.FeedbackService;
import com.example.mandelnyamsite.services.ProductService;
import com.example.mandelnyamsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, ProductService productService, UserService userService) {
        this.feedbackService = feedbackService;
        this.productService = productService;
        this.userService = userService;
    }

//    @PreAuthorize("hasAnyAuthority('admin','employee','user')")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/feedbacks")
    public String findAll(Model model) {
        List<Feedback> feedbacks = feedbackService.findAll();
        model.addAttribute("feedbacks", feedbacks);
        return "feedback-list";
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/feedbacks/create")
    public String createFeedbackForm(Feedback feedback, Model model) {
        List<Product> products = productService.findAll();
        List<User> users = userService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("users", users);
        return "feedback-create";
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @PostMapping("/feedbacks/create")
    public String createFeedback(Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedbacks";
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/feedbacks/update/{id}")
    public String updateFeedbackForm(@PathVariable Long id, Model model) {
        Feedback feedback = feedbackService.findById(id);
        List<Product> products = productService.findAll();
        List<User> users = userService.findAll();
        model.addAttribute("feedback", feedback);
        model.addAttribute("products", products);
        model.addAttribute("users", users);
        return "feedback-update";
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @PostMapping("/feedbacks/update/")
    public String updateFeedback(@ModelAttribute("feedback") Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedbacks";
    }


    @GetMapping("/feedbacks/delete/{id}")
    public String deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteById(id);
        return "redirect:/feedbacks";
    }
}
