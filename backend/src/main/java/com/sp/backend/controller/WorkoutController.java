package com.sp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sp.backend.model.Workout;
import com.sp.backend.service.WorkoutService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllWorkouts() {
        List<Workout> workouts = workoutService.findAllWorkouts();
        return ResponseEntity.ok(workouts);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchWorkouts(@RequestParam String keyword) {
        List<Workout> workouts = workoutService.searchWorkouts(keyword);
        return ResponseEntity.ok(workouts);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addWorkout(@RequestBody Workout workout) {
        Workout savedWorkout = workoutService.saveWorkout(workout);
        return ResponseEntity.ok(savedWorkout);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {
        Optional<Workout> foundWorkout = workoutService.findWorkoutById(id);
        if (foundWorkout.isPresent()) {
            Workout existingWorkout = foundWorkout.get();
            existingWorkout.setName(workout.getName());
            existingWorkout.setTargetMuscle(workout.getTargetMuscle());
            existingWorkout.setDescription(workout.getDescription());
            workoutService.saveWorkout(existingWorkout);
            return ResponseEntity.ok(existingWorkout);
        }
        return ResponseEntity.badRequest().body("Workout not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return ResponseEntity.ok("Workout deleted successfully");
    }
}
