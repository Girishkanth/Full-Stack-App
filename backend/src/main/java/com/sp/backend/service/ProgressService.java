package com.sp.backend.service;

import com.sp.backend.model.Progress;
import com.sp.backend.model.User;
import com.sp.backend.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    public Optional<Progress> getProgressById(Long id) {
        return progressRepository.findById(id);
    }

    public List<Progress> getProgressByUser(User user) {
        return progressRepository.findByUser(user);
    }

    public Progress saveProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    public void deleteProgress(Long id) {
        progressRepository.deleteById(id);
    }

    public Progress updateProgress(Long id, Progress progressDetails) {
        Optional<Progress> optionalProgress = progressRepository.findById(id);
        if (optionalProgress.isPresent()) {
            Progress progress = optionalProgress.get();
            progress.setExerciseName(progressDetails.getExerciseName());
            progress.setSets(progressDetails.getSets());
            progress.setReps(progressDetails.getReps());
            progress.setExerciseDateTime(progressDetails.getExerciseDateTime());
            progress.setHeight(progressDetails.getHeight());
            progress.setWeight(progressDetails.getWeight());
            progress.setBmi(progressDetails.getBmi());
            progress.setBmiDate(progressDetails.getBmiDate());
            progress.setCalories(progressDetails.getCalories());
            progress.setCalorieDate(progressDetails.getCalorieDate());
            return progressRepository.save(progress);
        } else {
            return null;
        }
    }
}
