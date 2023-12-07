package com.example.mandelnyamsite.controllers;

import com.example.mandelnyamsite.models.Supplier;
import com.example.mandelnyamsite.models.User;
import com.example.mandelnyamsite.services.SupplierService;
import com.example.mandelnyamsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/suppliers")
    public String findAll(Model model) {
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("suppliers", suppliers);
        return "supplier-list";
    }


    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/suppliers/create")
    public String createSupplierForm(Supplier supplier, Model model) {
//        model.addAttribute("users", supplierService.findAllUsers());
//        return "supplier-create";
        List<User> users = supplierService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("supplier", new Supplier());
        System.out.println(supplier.getSupplierName());
        System.out.println(supplier.getSupplierUser());
        return "supplier-create";
    }


    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @PostMapping("/suppliers/create")
    public String createSupplier(Supplier supplier) {
        supplierService.saveSupplier(supplier);
        System.out.println(supplier.getSupplierName());
        System.out.println(supplier.getSupplierUser());
        return "redirect:/suppliers";
    }
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/suppliers/update/{id}")
    public String updateSupplierForm(@PathVariable Long id, Model model) {
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        model.addAttribute("users", supplierService.findAllUsers());
        return "supplier-update";
    }
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @PostMapping("/suppliers/update")
    public String updateSupplier(Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/suppliers/delete/{id}")
    public String deleteSupplier(@PathVariable Long id) {
        supplierService.deleteById(id);
        return "redirect:/suppliers";
    }
}
