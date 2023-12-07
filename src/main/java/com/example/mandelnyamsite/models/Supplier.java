package com.example.mandelnyamsite.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.DecimalMax;
//import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_supplier;


    @NotBlank(message = "Название поставщика не может быть пустым")
//    @Max(value = 100, message = "Название поставщика должно быть не более 100 символов")
    @Column(name = "name_supplier")
    private String name_supplier;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;



    public Supplier(){}
    public Supplier(Long supplierID, String Supplier_Name, User user) {
        this.id_supplier = supplierID;
        this.name_supplier = Supplier_Name;
        this.user = user;
    }

    public Long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Long supplierID) {
        this.id_supplier = supplierID;
    }

    public String getSupplierName() {
        return name_supplier;
    }

    public void setSupplierName(String Supplier_Name) {
        this.name_supplier = Supplier_Name;
    }


    public User getSupplierUser() {
        return user;
    }

    public void setSupplierUser(User user) {
        this.user = user;
    }


}

