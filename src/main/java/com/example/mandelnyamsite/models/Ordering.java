package com.example.mandelnyamsite.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "ordering")
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_ordering;


    @NotBlank(message = "Номер заказа не может быть пустым")
    @Max(value = 8, message = "Номер заказа должен быть 8 символов")
    @Min(value = 8, message = "Номер заказа должен быть 8 символов")
    @Column(name = "ordering_number")
    private String ordering_number;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

//    @OneToMany (mappedBy = "ordering", fetch = FetchType.LAZY)
//    private Collection<Product> product;



    public Ordering(){}
    public Ordering(int orderingID, String Ordering_Number, User user, List<Product> product) {
        this.id_ordering = orderingID;
        this.ordering_number = Ordering_Number;
        this.user = user;
//        this.product = product;
    }

    public int getId_ordering() {
        return id_ordering;
    }

    public void setId_ordering(int orderingID) {
        this.id_ordering = orderingID;
    }

    public String getOrderingNumber() {
        return ordering_number;
    }

    public void setOrderingNumber(String Ordering_Number) {
        this.ordering_number = Ordering_Number;
    }

    public User getOrderingUser() {
        return user;
    }

    public void setOrderingUser(User user) {
        this.user = user;
    }

}

