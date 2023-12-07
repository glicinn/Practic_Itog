package com.example.mandelnyamsite.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.List;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_category")
    private Long id_category;


    @NotBlank(message = "Название категории не может быть пустым")
//    @Max(value = 30, message = "Название категории должно быть не более 30 символов")
    @Column(name = "category_name")
    private String category_name;


    @NotBlank(message = "Возрастное ограничение не может быть пустым")
//    @Max(value = 3, message = "Возрастное ограничение должно быть не более 3 символов")
    @Column(name = "age_limit")
    private String age_limit;

//    @OneToMany(mappedBy = "category")
//    private List<Product> products;


    public Category(){}
    public Category(Long categoryID, String Category_Name, String Age_Limit) {
        this.id_category = categoryID;
        this.category_name = Category_Name;
        this.age_limit = Age_Limit;
    }

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long categoryID) {
        this.id_category = categoryID;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String Category_Name) {
        this.category_name = Category_Name;
    }

    public String getAgeLimit() {
        return age_limit;
    }

    public void setAgeLimit(String Age_Limit) {
        this.age_limit = Age_Limit;
    }

}

