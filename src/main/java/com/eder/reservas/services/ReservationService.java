package com.eder.reservas.services;

import com.eder.reservas.domain.reservation.Reservation;
import com.eder.reservas.domain.reservation.ReservationStatus;
import com.eder.reservas.domain.table.Table;
import com.eder.reservas.domain.table.TableStatus;
import com.eder.reservas.domain.user.User;
import com.eder.reservas.repositories.ReservationRepository;
import com.eder.reservas.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TableRepository tableRepository;

    public Reservation addReservation(Reservation reservation) {
        Table table = tableRepository.findById(reservation.getTable().getId())
                .orElseThrow(() -> new RuntimeException("Table not Found"));

        if(table.getStatus() == TableStatus.INACTIVE || table.getStatus() == TableStatus.UNAVAILABLE) {
            throw new RuntimeException("Table not available");
        }

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservationsByUser(User user) {
        return reservationRepository.findAllByUser(user);
    }

    public Reservation cancelReservation(UUID id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        if(reservation.getReservationStatus() == ReservationStatus.CANCELED) {
            throw new RuntimeException("Reservation is already canceled");
        }

        reservation.setReservationStatus(ReservationStatus.CANCELED);
        return reservationRepository.save(reservation);
    }
}
