package com.example.mandelnyamsite.api;

import com.example.mandelnyamsite.models.Supplier;
import com.example.mandelnyamsite.models.User;
import com.example.mandelnyamsite.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierApiController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierApiController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.findAll();
    }

    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id) {
        return supplierService.findById(id);
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier updatedSupplier) {
        // Проверки, обновление и возврат обновленного поставщика
        return updatedSupplier;
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        supplierService.deleteById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return supplierService.findAllUsers();
    }
}