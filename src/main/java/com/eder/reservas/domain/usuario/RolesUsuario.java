package com.eder.reservas.domain.usuario;

public enum RolesUsuario {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    final private String role;

    RolesUsuario(String role) { this.role = role; }

    public String getRole() { return this.role; }
}
