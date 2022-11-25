package com.jpapractice1123.jpapractice.controller;

import com.jpapractice1123.jpapractice.domain.dto.ReviewReadResponse;
import com.jpapractice1123.jpapractice.domain.entity.Hospital;
import com.jpapractice1123.jpapractice.domain.entity.Review;
import com.jpapractice1123.jpapractice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
@Slf4j
@RequiredArgsConstructor // 필요한 constructor argument를 넣어준다.
public class ReviewController {

    private final ReviewService reviewService;
    // @RequiredArgsConstructor를 활용해 Constructor없이 DI가 가능하다.

    //1개 조회 기능
    //Get /api/v1/reviews/{id}
//    @GetMapping("/{id}")
//    public ResponseEntity<Review> get(@PathVariable Long id){
//        Review review = reviewService.getReview(id);
//        return ResponseEntity.ok().body(review);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<ReviewReadResponse> get(@PathVariable Long id) {
        Review review = reviewService.getReview(id);
        ReviewReadResponse response = ReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getUserName())
//                .hospitalName("병원이름 빈칸") Hospital과 양방향 맵핑이 되어있기 때문에 참조가 가능하다.
                .hospitalName(review.getHospital().getHospitalName())
                .build();
        return ResponseEntity.ok().body(response);
    }
}
