package com.challenge.api.controller;

import com.challenge.api.dto.CreateEmployeeRequest;
import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeClass;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Fill in the missing aspects of this Spring Web REST Controller. Don't forget to add a Service layer.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee models as necessary.
     * @return One or more Employees.
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.findAll();
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee model as necessary.
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */
    @GetMapping("/{uuid}")
    public Employee getEmployeeByUuid(@PathVariable UUID uuid) {
        Employee employee = service.findById(uuid);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with UUID " + uuid + "not found");
        }
        return employee;
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer.
     * @return Newly created Employee
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {
        var e = new EmployeeClass();
        e.setFirstName(request.firstName());
        e.setLastName(request.lastName());
        e.setEmail(request.email());
        e.setUuid(request.uuid());
        e.setSalary(request.salary());
        e.setJobTitle(request.jobTitle());
        e.setContractHireDate(request.contractHireDate());
        return service.create(e);
    }
}
