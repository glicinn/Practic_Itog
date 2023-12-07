package com.example.mandelnyamsite.services;

import com.example.mandelnyamsite.models.Benefit;
import com.example.mandelnyamsite.models.Category;
import com.example.mandelnyamsite.repos.BenefitRepository;
import com.example.mandelnyamsite.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category) { return categoryRepository.save(category); }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

}
