package com.project.placementtracker.repository;

import com.project.placementtracker.model.PlacementApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacementRepository extends JpaRepository<PlacementApplication, Long> {
}