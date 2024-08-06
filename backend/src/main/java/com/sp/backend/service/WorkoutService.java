package com.sp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sp.backend.model.Workout;
import com.sp.backend.repository.WorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> findAllWorkouts() {
        return workoutRepository.findAll();
    }

    public List<Workout> searchWorkouts(String keyword) {
        return workoutRepository.findByNameContainingIgnoreCaseOrTargetMuscleContainingIgnoreCase(keyword, keyword);
    }

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Optional<Workout> findWorkoutById(Long id) {
        return workoutRepository.findById(id);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}
