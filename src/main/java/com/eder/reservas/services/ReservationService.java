package com.eder.reservas.services;

import com.eder.reservas.domain.reservation.Reservation;
import com.eder.reservas.domain.reservation.ReservationStatus;
import com.eder.reservas.domain.table.Table;
import com.eder.reservas.domain.table.TableStatus;
import com.eder.reservas.domain.user.User;
import com.eder.reservas.repositories.ReservationRepository;
import com.eder.reservas.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

        if(reservation.getPeople() > table.getCapacity()) {
            throw new RuntimeException("Amount of people exceeds table capacity");
        }
        if(table.getStatus() == TableStatus.INACTIVE || table.getStatus() == TableStatus.UNAVAILABLE) {
            throw new RuntimeException("Table not available");
        }
        if(reservationRepository.existsByTableAndTimestamp(table, reservation.getReservationTimestamp())) {
            throw new RuntimeException("Table not available at this time");
        }

        table.setStatus(TableStatus.UNAVAILABLE);
        tableRepository.save(table);

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservationsByUser(User user) {
        return reservationRepository.findAllByUser(user);
    }

    public Reservation cancelReservation(UUID id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        Table table  = tableRepository.findById(reservation.getTable().getId())
                .orElseThrow(() -> new RuntimeException("Table not Found"));

        if(reservation.getReservationStatus() == ReservationStatus.CANCELED) {
            throw new RuntimeException("Reservation is already canceled");
        }

        table.setStatus(TableStatus.AVAILABLE);
        tableRepository.save(table);

        reservation.setReservationStatus(ReservationStatus.CANCELED);
        return reservationRepository.save(reservation);
    }
}
