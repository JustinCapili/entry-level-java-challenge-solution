package com.challenge.api.dto;

import java.time.Instant;
import java.util.UUID;

public record CreateEmployeeRequest(
        String firstName,
        String lastName,
        String email,
        UUID uuid,
        Integer salary,
        String jobTitle,
        Instant contractHireDate) {}
