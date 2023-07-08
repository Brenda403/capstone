package com.devmountain.capstone.entities;

import com.devmountain.capstone.dtos.UserDtos;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    //ID

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


// Username & PW
@Column(name = "username", unique = true)
private String username;

@Column(name = "password")
private String password;


//constructor created using in userservicelmpl.java
    public User(UserDtos userDtos) {
    }

// getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// constructors
    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

}
