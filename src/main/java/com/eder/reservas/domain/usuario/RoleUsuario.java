package com.eder.reservas.domain.usuario;

public enum RoleUsuario {
    USER,
    ADMIN;

    public String getRole() {
        return "ROLE_" + this.name();
    }
}
