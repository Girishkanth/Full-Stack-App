package com.sp.backend.controller;

import com.sp.backend.model.Progress;
import com.sp.backend.model.User;
import com.sp.backend.service.ProgressService;
import com.sp.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Progress> getAllProgress() {
        return progressService.getAllProgress();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progress> getProgressById(@PathVariable Long id) {
        Optional<Progress> progress = progressService.getProgressById(id);
        return progress.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Progress>> getProgressByUserId(@PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);
        return user.map(u -> ResponseEntity.ok(progressService.getProgressByUser(u)))
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Progress> createProgress(@PathVariable Long userId, @RequestBody Progress progress) {
        Optional<User> user = userService.findById(userId);
        return user.map(u -> {
            progress.setUser(u);
            return ResponseEntity.ok(progressService.saveProgress(progress));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Progress> updateProgress(@PathVariable Long id, @RequestBody Progress progressDetails) {
        Progress updatedProgress = progressService.updateProgress(id, progressDetails);
        return updatedProgress != null ? ResponseEntity.ok(updatedProgress) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgress(@PathVariable Long id) {
        if (progressService.getProgressById(id).isPresent()) {
            progressService.deleteProgress(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
