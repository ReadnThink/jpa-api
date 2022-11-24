package com.jpapractice1123.jpapractice.service;

import com.jpapractice1123.jpapractice.domain.dto.HospitalResponse;
import com.jpapractice1123.jpapractice.domain.entity.Hospital;
import com.jpapractice1123.jpapractice.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse findById(Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        HospitalResponse hospitalResponse = HospitalResponse.of(optionalHospital.get());
        return hospitalResponse;
    }

}
