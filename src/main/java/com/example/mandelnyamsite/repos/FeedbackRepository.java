package com.example.mandelnyamsite.repos;

import com.example.mandelnyamsite.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {


}