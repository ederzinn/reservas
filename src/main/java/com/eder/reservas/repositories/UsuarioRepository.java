package com.eder.reservas.repositories;

import com.eder.reservas.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<String> findByEmail();
}
