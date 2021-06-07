package com.project.platform.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Size(max=120)
    @Column(name = "username")
    private String userName;

    @NotBlank
    @Size(max=120)
    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


enum  Role{
    USER,
    ADMIN
}