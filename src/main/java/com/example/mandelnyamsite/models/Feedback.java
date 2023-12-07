package com.example.mandelnyamsite.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_feedback")
    private Long id_feedback;


    @NotBlank(message = "Текст отзыва не может быть пустым")
    @Max(value = 500, message = "Текст отзыва должен быть не более 500 символов")
    @Column(name = "feedback_text")
    private String feedback_text;


    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @OneToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product") // Указывает на столбец, который связывает сущности
    private Product product;



    public Feedback(){}
    public Feedback(Long feedbackID, String Feedback_Text, User user, Product product) {
        this.id_feedback = feedbackID;
        this.feedback_text = Feedback_Text;
        this.user = user;
        this.product = product;
    }

    public Long getId_feedback() {
        return id_feedback;
    }

    public void setId_feedback(Long feedbackID) {
        this.id_feedback = feedbackID;
    }

    public String getFeedbackText() {
        return feedback_text;
    }

    public void setFeedbackText(String Feedback_Text) {
        this.feedback_text = Feedback_Text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}

