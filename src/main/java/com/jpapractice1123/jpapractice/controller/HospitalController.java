package com.jpapractice1123.jpapractice.controller;

import com.jpapractice1123.jpapractice.domain.dto.HospitalResponse;
import com.jpapractice1123.jpapractice.domain.entity.Hospital;
import com.jpapractice1123.jpapractice.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> findById(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = hospitalService.findById(id);
        return ResponseEntity.ok().body(hospitalResponse);
    }
}
