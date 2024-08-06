package com.sp.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sp.backend.model.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByNameContainingIgnoreCaseOrTargetMuscleContainingIgnoreCase(String name, String targetMuscle);
}
