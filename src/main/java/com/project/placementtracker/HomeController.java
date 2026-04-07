package com.project.placementtracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Placement Tracker Application is running successfully on Render!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is UP";
    }
}