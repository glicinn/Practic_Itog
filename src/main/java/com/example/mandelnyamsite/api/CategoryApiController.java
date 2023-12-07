package com.example.mandelnyamsite.api;

import com.example.mandelnyamsite.models.Category;
import com.example.mandelnyamsite.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryApiController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        // Проверка существования категории с заданным id
        Category existingCategory = categoryService.findById(id);
        if (existingCategory == null) {
            return ResponseEntity.notFound().build();
        }

        // Обновление полей категории
        existingCategory.setCategoryName(updatedCategory.getCategoryName());
        existingCategory.setAgeLimit(updatedCategory.getAgeLimit());

        // Сохранение обновленной категории
        Category updatedCategoryData = categoryService.saveCategory(existingCategory);

        return ResponseEntity.ok(updatedCategoryData);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}