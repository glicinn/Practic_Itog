package com.example.mandelnyamsite.controllers;

import com.example.mandelnyamsite.models.Ordering;
import com.example.mandelnyamsite.models.Product;
import com.example.mandelnyamsite.models.User;
import com.example.mandelnyamsite.services.OrderingService;
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
public class OrderingController {

    private final OrderingService orderingService;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public OrderingController(OrderingService orderingService, ProductService productService, UserService userService) {
        this.orderingService = orderingService;
        this.productService = productService;
        this.userService = userService;
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/orderings")
    public String findAll(Model model) {
        List<Ordering> orderings = orderingService.findAll();
        model.addAttribute("orderings", orderings);
        return "ordering-list";
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/orderings/create")
    public String createOrderingForm(Ordering ordering, Model model) {
        List<Product> products = productService.findAll();
        List<User> users = userService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("users", users);
        return "ordering-create";
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @PostMapping("/orderings/create")
    public String createOrdering(Ordering ordering) {
        orderingService.saveOrdering(ordering);
        return "redirect:/orderings";
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/orderings/update/{id}")
    public String updateOrderingForm(@PathVariable Long id, Model model) {
        Ordering ordering = orderingService.findById(id);
        List<Product> products = productService.findAll();
        List<User> users = userService.findAll();
        model.addAttribute("ordering", ordering);
        model.addAttribute("products", products);
        model.addAttribute("users", users);
        return "ordering-update";
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @PostMapping("/orderings/update/")
    public String updateOrdering(@ModelAttribute("ordering") Ordering ordering) {
        orderingService.saveOrdering(ordering);
        return "redirect:/orderings";
    }


    @GetMapping("/orderings/delete/{id}")
    public String deleteOrdering(@PathVariable Long id) {
        orderingService.deleteById(id);
        return "redirect:/orderings";
    }
}
