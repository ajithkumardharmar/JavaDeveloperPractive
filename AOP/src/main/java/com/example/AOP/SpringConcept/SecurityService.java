package com.example.AOP.SpringConcept;


import org.springframework.stereotype.Component;

@Component
public class SecurityService {
    private String currentUserRole = "USER";  // Default role

    public void setRole(String role) {
        this.currentUserRole = role;
    }

    public boolean isAdmin() {
        return "ADMIN".equals(currentUserRole);
    }
}

