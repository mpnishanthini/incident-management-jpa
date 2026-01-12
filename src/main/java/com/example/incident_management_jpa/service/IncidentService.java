package com.example.incident_management_jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.incident_management_jpa.entity.Incident;
import com.example.incident_management_jpa.exception.ResourceNotFoundException;
import com.example.incident_management_jpa.repository.IncidentRepository;


@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }
    // GET
    public Incident getIncidentById(Long id) {
        return incidentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Incident not found with id: " + id)
                );
    }


    // 🔹 UPDATE
    public Incident updateIncident(Long id, Incident updatedIncident) {
        Incident existing = incidentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found with id " + id));
        
        existing.setTitle(updatedIncident.getTitle());
        existing.setDescription(updatedIncident.getDescription());
        existing.setStatus(updatedIncident.getStatus());

        return incidentRepository.save(existing);
    }

    // 🔹 DELETE
    public void deleteIncident(Long id) {
        Incident existing = incidentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found with id " + id));

        incidentRepository.delete(existing);
    }
}
