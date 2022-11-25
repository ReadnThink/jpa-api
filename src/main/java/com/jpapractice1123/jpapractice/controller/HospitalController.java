package com.jpapractice1123.jpapractice.controller;

import com.jpapractice1123.jpapractice.domain.dto.HospitalResponse;
import com.jpapractice1123.jpapractice.domain.dto.ReviewCreateRequest;
import com.jpapractice1123.jpapractice.domain.dto.ReviewCreateResponse;
import com.jpapractice1123.jpapractice.domain.dto.ReviewReadResponse;
import com.jpapractice1123.jpapractice.domain.entity.Hospital;
import com.jpapractice1123.jpapractice.service.HospitalService;
import com.jpapractice1123.jpapractice.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    //해당 병원의 reviews만 조회하는 기능
    //왜 list로 받아야 하는가? -> 리뷰 1개가 아니라 해당 병원의 리뷰 전체를 받아야 하기 때문이다.
    //그렇기 때문에 병원 id를 넘겨야 한다.
    @GetMapping("/{hospitalId}/reviews")
    public ResponseEntity<List<ReviewReadResponse>> reviews(@PathVariable Integer hospitalId){
        return ResponseEntity.ok().body(reviewService.findAllByHospitalId(hospitalId));
    }



    //리뷰 등록하는기능
    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> add(@PathVariable Integer id, @RequestBody ReviewCreateRequest reviewCreateRequest) {
        return ResponseEntity.ok().body(reviewService.add(reviewCreateRequest));
    }
}
