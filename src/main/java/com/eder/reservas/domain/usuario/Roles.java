package com.eder.reservas.domain.usuario;

public enum Roles {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    final private String role;

    Roles(String role) { this.role = role; }

    public String getRole() { return this.role; }
}
