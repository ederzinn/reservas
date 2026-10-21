package com.eder.reservas.repositories;

import com.eder.reservas.domain.reserva.Reserva;
import com.eder.reservas.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReservaRepository extends JpaRepository<Reserva, UUID> {
    List<Reserva> findAllByUsuario(Usuario usuario);
}
