package com.example.mandelnyamsite.api;

import com.example.mandelnyamsite.models.Ordering;
import com.example.mandelnyamsite.services.OrderingService;
import com.example.mandelnyamsite.services.ProductService;
import com.example.mandelnyamsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderings")
public class OrderingApiController {

    private final OrderingService orderingService;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public OrderingApiController(OrderingService orderingService, ProductService productService, UserService userService) {
        this.orderingService = orderingService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
    public List<Ordering> getAllOrderings() {
        return orderingService.findAll();
    }

    @PostMapping
    public Ordering createOrdering(@RequestBody Ordering ordering) {
        return orderingService.saveOrdering(ordering);
    }

    @GetMapping("/{id}")
    public Ordering getOrderingById(@PathVariable Long id) {
        return orderingService.findById(id);
    }

    @PutMapping("/{id}")
    public Ordering updateOrdering(@PathVariable Long id, @RequestBody Ordering updatedOrdering) {
        // Проверки, обновление и возврат обновленного заказа
        return updatedOrdering;
    }

    @DeleteMapping("/{id}")
    public void deleteOrdering(@PathVariable Long id) {
        orderingService.deleteById(id);
    }
}