package com.bugtrackertool.bugtrackertool.models;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

    private String username;

    private String hashedPassword;

    public User() {}

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(String username, String password) {
        this.username = username;
        this.hashedPassword = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean checkHashedPasswords(String password){
        return encoder.matches(password, hashedPassword);
    }
}
