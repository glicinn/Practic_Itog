package com.example.mandelnyamsite.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;



@Entity
@Table(name = "benefit")
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_benefit")
    private Long id_benefit;

    @NotBlank(message = "Название льготы не может быть пустым")
//    @Max(value = 100, message = "Название льготы должно быть не более 100 символов")
    @Column(name = "name_benefit")
    private String name_benefit;


//    @Min(value = 0, message = "Размер скидки не может быть отрицательным")
    @Column(name = "discount_benefit", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'someDefaultValue'")
    private int discount_benefit;



    public Benefit(){}
    public Benefit(Long benefitID, String Benefit_Name, int Benefit_Discount) {
        this.id_benefit = benefitID;
        this.name_benefit = Benefit_Name;
        this.discount_benefit = Benefit_Discount;
    }

    public Long getId_benefit() {
        return id_benefit;
    }

    public void setId_benefit(Long benefitID) {
        this.id_benefit = benefitID;
    }

    public String getBenefitName() {
        return name_benefit;
    }

    public void setBenefitName(String Benefit_Name) {
        this.name_benefit = Benefit_Name;
    }

    public int getBenefitDiscount() {
        return discount_benefit;
    }

    public void setBenefitDiscount(int Benefit_Discount) {
        this.discount_benefit = Benefit_Discount;
    }


}

