package com.eder.reservas.services;

import com.eder.reservas.domain.table.Table;
import com.eder.reservas.domain.table.TableStatus;
import com.eder.reservas.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public Table addTable(Table table) {
        if(tableRepository.findByNumber(table.getNumber()) != null) {
            throw new RuntimeException("Table number already exists");
        }
        return tableRepository.save(table);
    }

    public Table patchTable(UUID id, Integer number, Integer capacity, TableStatus status) {
        Table table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found"));

        if(number != null) {
            table.setNumber(number);
        }
        if(capacity != null) {
            table.setCapacity(capacity);
        }
        if(status != null) {
            table.setStatus(status);
        }

        return tableRepository.save(table);
    }

    public void deleteTable(UUID id) {
        Table table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found"));

        tableRepository.delete(table);
    }
}
