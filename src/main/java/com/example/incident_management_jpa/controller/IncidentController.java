package com.example.incident_management_jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.incident_management_jpa.entity.Incident;
import com.example.incident_management_jpa.service.IncidentService;
/*import com.example.incident_management_jpa.service.PathVariable;
import com.example.incident_management_jpa.service.PutMapping;
import com.example.incident_management_jpa.service.RequestBody;
import com.example.incident_management_jpa.service.ResponseEntity;
import com.example.incident_management_jpa.service.Valid;*/

import jakarta.validation.Valid;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    // POST: Create Incident
    @PostMapping
    public Incident createIncident(@Valid @RequestBody Incident incident) {
        return incidentService.createIncident(incident);
    }

    // GET: Fetch all incidents
    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }
    
    // PUT:
    @PutMapping("/{id}")
    public ResponseEntity<Incident> updateIncident(
            @PathVariable Long id,
            @Valid @RequestBody Incident incident) {

        Incident updated = incidentService.updateIncident(id, incident);
        return ResponseEntity.ok(updated);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncident(id);
        return ResponseEntity.noContent().build();
    }
}
