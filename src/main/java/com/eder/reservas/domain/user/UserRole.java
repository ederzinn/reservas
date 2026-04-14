package com.eder.reservas.domain.user;

public enum UserRole {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String role;

    UserRole(String userRole) {
        this.role = userRole;
    }

    public String getRole() {
        return this.role;
    }
}
