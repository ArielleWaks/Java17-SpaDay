package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message = "Username is required.")
    @Size(min = 5, max = 14, message = "Username must be between 5 and 15 characters.")
    private String username;

    @Email(message = "Valid email is required.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;

//    @NotBlank(message = "Password verification required.")
    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword(this.password, verifyPassword);
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword(password, this.verifyPassword);
    }

    private void checkPassword(String password, String verifyPassword) {
        if(!password.equals(verifyPassword)) {
            this.verifyPassword = null;
        }
    }
}

