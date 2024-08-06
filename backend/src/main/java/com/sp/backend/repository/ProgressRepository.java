package com.sp.backend.repository;

import com.sp.backend.model.Progress;
import com.sp.backend.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findByUser(User user);
}
