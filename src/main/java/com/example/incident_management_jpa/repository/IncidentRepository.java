package com.example.incident_management_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.incident_management_jpa.entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    // Spring Data JPA auto-implements CRUD methods
}
