package com.example.mandelnyamsite.controllers;

import com.example.mandelnyamsite.models.Product;
import com.example.mandelnyamsite.models.Category;
import com.example.mandelnyamsite.models.Supplier;

import com.example.mandelnyamsite.services.ProductService;
import com.example.mandelnyamsite.services.CategoryService;
import com.example.mandelnyamsite.services.SupplierService;
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
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, SupplierService supplierService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/products")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product-list";
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/products/create")
    public String createProductForm(Product product, Model model) {
//        List<Category> categorys = categoryService.findAll();
//        List<Supplier> suppliers = supplierService.findAll();
//        model.addAttribute("categorys", categorys);
//        model.addAttribute("suppliers", suppliers);
//        model.addAttribute("product", new Product());

        List<Category> categorys = productService.findAllCategorys();
        List<Supplier> suppliers = productService.findAllSuppliers();
        model.addAttribute("categorys", categorys);
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("product", new Product());

        return "product-create";
    }


    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @PostMapping("/products/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }


//    @PreAuthorize("hasAnyAuthority('admin','employee')")
//    @PostMapping("/products/create")
//    public String createProduct(Product product, Category category) {
//
//        Category category = new Category();
//        product.setCategory(category);
//        productService.saveProduct(product);
//
//        return "redirect:/products";
//    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/products/update/{id}")
    public String updateProductForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        List<Category> categorys = categoryService.findAll();
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("categorys", categorys);
        model.addAttribute("suppliers", suppliers);
        return "product-update";
    }

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @PostMapping("/products/update/")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }


    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
