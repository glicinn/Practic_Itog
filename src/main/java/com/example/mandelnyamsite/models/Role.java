package com.example.mandelnyamsite.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_role;

    @NotBlank(message = "Название роли не может быть пустым")
//    @Max(value = 30, message = "Название роли должно быть не более 30 символов")
    @Column(name = "role_name")
    private String role_name;



    public Role(){}
    public Role(Long roleID, String Role_Name) {
        this.id_role = roleID;
        this.role_name = Role_Name;
    }

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long roleID) {
        this.id_role = roleID;
    }

    public String getRoleName() {
        return role_name;
    }

    public void setRoleName(String Role_Name) {
        this.role_name = Role_Name;
    }


}

