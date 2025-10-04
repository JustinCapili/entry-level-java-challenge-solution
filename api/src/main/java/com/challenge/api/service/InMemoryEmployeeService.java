package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class InMemoryEmployeeService implements EmployeeService {
    private final Map<UUID, Employee> employees = new ConcurrentHashMap<>();

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee findById(UUID uuid) {
        return employees.get(uuid);
    }

    @Override
    public Employee create(Employee e) {
        if (e.getUuid() == null) {
            e.setUuid(UUID.randomUUID());
        }
        employees.put(e.getUuid(), e);
        return e;
    }
}
