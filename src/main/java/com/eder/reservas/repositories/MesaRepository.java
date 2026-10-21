package com.eder.reservas.repositories;

import com.eder.reservas.domain.mesa.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface MesaRepository extends JpaRepository<Mesa, UUID> {
    Optional<Mesa> findByNumero(Integer numero);
}
