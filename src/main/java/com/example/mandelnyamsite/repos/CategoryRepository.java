package com.example.mandelnyamsite.repos;

import com.example.mandelnyamsite.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}