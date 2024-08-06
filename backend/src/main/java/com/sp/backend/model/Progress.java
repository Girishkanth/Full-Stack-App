package com.sp.backend.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Exercise Tracker details
    private String exerciseName;
    private int sets;
    private int reps;

    @Column(name = "exercise_datetime")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime exerciseDateTime;

    // BMI Tracker details
    private double height;
    private double weight;
    private double bmi;

    @Column(name = "bmi_date")
    private LocalDateTime bmiDate;

    // Calorie Tracker details
    private int calories;

    @Column(name = "calorie_date")
    private LocalDateTime calorieDate;

    // ManyToOne relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    // Constructors
    public Progress() {}

    public Progress(String exerciseName, int sets, int reps, LocalDateTime exerciseDateTime, double height, double weight, double bmi, LocalDateTime bmiDate, int calories, LocalDateTime calorieDate, User user) {
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.exerciseDateTime = exerciseDateTime;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.bmiDate = bmiDate;
        this.calories = calories;
        this.calorieDate = calorieDate;
        this.user = user;
    }

    //Getters and Setters
    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public LocalDateTime getExerciseDateTime() {
        return exerciseDateTime;
    }

    public void setExerciseDateTime(LocalDateTime exerciseDateTime) {
        this.exerciseDateTime = exerciseDateTime;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public LocalDateTime getBmiDate() {
        return bmiDate;
    }

    public void setBmiDate(LocalDateTime bmiDate) {
        this.bmiDate = bmiDate;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public LocalDateTime getCalorieDate() {
        return calorieDate;
    }

    public void setCalorieDate(LocalDateTime calorieDate) {
        this.calorieDate = calorieDate;
    }
}
