package com.example.mandelnyamsite.controllers;

import com.example.mandelnyamsite.models.Category;
import com.example.mandelnyamsite.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



//    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/categorys")
    public String findAll(Model model) {
        List<Category> categorys = categoryService.findAll();
        model.addAttribute("categorys", categorys);
        return "category-list";
    }
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/categorys/create")
    public String createCategoryForm(Category category) {
        return "category-create";
    }

    @PostMapping("/categorys/create")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String createCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categorys";
    }

    @GetMapping("/categorys/update/{id}")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String updateCategoryForm(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category-update";
    }

    @PostMapping("/categorys/update")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String updateCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categorys";
    }

    @GetMapping("/categorys/delete/{id}")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "redirect:/categorys";
    }
}
