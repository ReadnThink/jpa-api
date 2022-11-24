package com.jpapractice1123.jpapractice.repository;

import com.jpapractice1123.jpapractice.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
