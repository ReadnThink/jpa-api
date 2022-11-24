package com.jpapractice1123.jpapractice.repository;

import com.jpapractice1123.jpapractice.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
