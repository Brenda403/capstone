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
@Column(unique = true)
private String username;
@Column(unique = true)
private String password;

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

    public User(UserDtos userDtos) {
        if (userDtos.getUsername() != null) {
            this.username = userDtos.getUsername();
        }
        if (userDtos.getPassword() != null) {
            this.password = userDtos.getPassword();
        }
    }

}
