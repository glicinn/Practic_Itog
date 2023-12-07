package com.example.mandelnyamsite.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.DecimalMax;
//import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product")
    private Long id_product;


    @NotBlank(message = "Название товара не может быть пустым")
//    @Max(value = 80, message = "Название товара должно быть не более 80 символов")
    @Column(name = "product_name")
    private String product_name;


    @NotBlank(message = "Описание товара не может быть пустым")
//    @Max(value = 500, message = "Описание товара должно быть не более 500 символов")
    @Column(name = "product_description")
    private String product_description;

    @NotBlank(message = "Фото товара не может быть пустым")
//    @Max(value = 500, message = "Фото товара должно быть не более 500 символов")
    @Column(name = "product_photo")
    private String product_photo;

//    @DecimalMin(value = "0.0", message = "Значение должно быть больше 0")
//    @DecimalMax(value = "100000.0", message = "Значение должно быть меньше 100000")
    @Column(name = "product_price")
    private double product_price;


//    @OneToOne
//    @JoinColumn(name = "id_category", referencedColumnName = "id_category") // Указывает на столбец, который связывает сущности
//    private Category category;
//
//    @OneToOne
//    @JoinColumn(name = "id_supplier", referencedColumnName = "id_supplier") // Указывает на столбец, который связывает сущности
//    private Supplier supplier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category", nullable = false, referencedColumnName = "id_category")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_supplier", nullable = false, referencedColumnName = "id_supplier")
    private Supplier supplier;


    public Product(){}
    public Product(Long productID, String Product_Name, String Product_Description, String product_photo, Double product_price, Category category, Supplier supplier) {
        this.id_product = productID;
        this.product_name = Product_Name;
        this.product_description = Product_Description;
        this.product_photo = product_photo;
        this.product_price = product_price;
        this.category = category;
        this.supplier = supplier;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long productID) {
        this.id_product = productID;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String Product_Name) {
        this.product_name = Product_Name;
    }

    public String getProductDescription() {
        return product_description;
    }

    public void setProductDescription(String Product_Description) {
        this.product_description = Product_Description;
    }



    public String getProductPhoto() {
        return product_photo;
    }

    public void setProductPhoto(String product_photo) {
        this.product_photo = product_photo;
    }

    public Double getProductPrice() {
        return product_price;
    }

    public void setProductPrice(Double product_price) {
        this.product_price = product_price;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

}

