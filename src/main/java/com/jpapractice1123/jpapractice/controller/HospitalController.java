package com.jpapractice1123.jpapractice.controller;

import com.jpapractice1123.jpapractice.domain.dto.HospitalResponse;
import com.jpapractice1123.jpapractice.domain.dto.ReviewCreateRequest;
import com.jpapractice1123.jpapractice.domain.dto.ReviewCreateResponse;
import com.jpapractice1123.jpapractice.service.HospitalService;
import com.jpapractice1123.jpapractice.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    //병원 조회하는기능 (review포함)
    @GetMapping("/{id}") //해당 id에 정보를 불러온다.
    public ResponseEntity<HospitalResponse> findById(@PathVariable Integer id) { //url에서 id값을 받기 위함
        HospitalResponse hospitalResponse = hospitalService.findById(id); //service에서 로직 구현
        return ResponseEntity.ok().body(hospitalResponse);
    }

    //리뷰 등록하는기능
    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> add(@PathVariable Integer id, @RequestBody ReviewCreateRequest reviewCreateRequest) {
        return ResponseEntity.ok().body(reviewService.add(reviewCreateRequest));
    }
}
