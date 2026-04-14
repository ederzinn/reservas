package com.eder.reservas.domain.table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@jakarta.persistence.Table(name = "tables")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Integer capacity;
    private TableStatus status;
}
