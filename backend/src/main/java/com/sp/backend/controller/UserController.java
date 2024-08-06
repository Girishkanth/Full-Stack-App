package com.sp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sp.backend.model.User;
import com.sp.backend.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Account already exists");
        }
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> foundUser = userService.findByEmail(user.getEmail());
        if (foundUser.isPresent() && foundUser.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(foundUser.get());
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Optional<User> foundUser = userService.findByEmail(user.getEmail());
        if (foundUser.isPresent()) {
            User existingUser = foundUser.get();
            existingUser.setName(user.getName());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setAge(user.getAge());
            existingUser.setHeight(user.getHeight());
            existingUser.setWeight(user.getWeight());
            existingUser.setBloodGroup(user.getBloodGroup());
            existingUser.setMedicalCondition(user.getMedicalCondition());
            existingUser.setDateOfJoining(user.getDateOfJoining());
            existingUser.setCity(user.getCity());
            existingUser.setCountry(user.getCountry());
            existingUser.setGoal(user.getGoal());
            existingUser.setRole(user.getRole());
            userService.saveUser(existingUser);
            return ResponseEntity.ok(existingUser);
        }
        return ResponseEntity.badRequest().body("User not found");
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        Optional<User> foundUser = userService.findByEmail(email);
        if (foundUser.isPresent()) {
            return ResponseEntity.ok(foundUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
