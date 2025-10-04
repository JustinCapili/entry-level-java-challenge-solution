package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(UUID uuid);

    Employee create(Employee employee);
}
