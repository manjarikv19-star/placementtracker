package com.project.placementtracker.controller;

import com.project.placementtracker.model.PlacementApplication;
import com.project.placementtracker.repository.PlacementRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@CrossOrigin("*")
public class ApplicationController {

    private final PlacementRepository repository;

    public ApplicationController(PlacementRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public PlacementApplication addApplication(@RequestBody PlacementApplication application) {
        return repository.save(application);
    }

    @GetMapping
    public List<PlacementApplication> getAllApplications() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public PlacementApplication updateApplication(@PathVariable Long id, @RequestBody PlacementApplication updatedApp) {
        PlacementApplication app = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        app.setCompanyName(updatedApp.getCompanyName());
        app.setRole(updatedApp.getRole());
        app.setStatus(updatedApp.getStatus());
        app.setApplicationDate(updatedApp.getApplicationDate());

        return repository.save(app);
    }

    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {
        repository.deleteById(id);
        return "Application deleted successfully";
    }
}