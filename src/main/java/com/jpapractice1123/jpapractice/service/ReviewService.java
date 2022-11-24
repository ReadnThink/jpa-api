package com.jpapractice1123.jpapractice.service;

import com.jpapractice1123.jpapractice.domain.dto.ReviewCreateRequest;
import com.jpapractice1123.jpapractice.domain.dto.ReviewCreateResponse;
import com.jpapractice1123.jpapractice.domain.entity.Hospital;
import com.jpapractice1123.jpapractice.domain.entity.Review;
import com.jpapractice1123.jpapractice.repository.HospitalRepository;
import com.jpapractice1123.jpapractice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    //review를 client에게 받고 데이터를 다듬어 반환하기위해 ReviewCreateResponse와 ReviewCreateRequest를 만든다.
    public ReviewCreateResponse add(ReviewCreateRequest reviewCreateRequest) {
        //Request에서 받은 hospitalId로 hospital을 찾고, hospital정보와 request정보를 review에 담는다.
        //review에 저장할때 hospital도 같이 저장하기 때문에 외래키를 통해 hopitalId와 일치하는 hopital정보를 review로 받아온다.
        Optional<Hospital> hospital = hospitalRepository.findById(reviewCreateRequest.getHospitalId());
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .userName(reviewCreateRequest.getUserName())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewCreateResponse(savedReview.getId(), savedReview.getTitle(),
                savedReview.getContent(), savedReview.getUserName(), "리뷰 등록이 성공했습니다.");
    }
}
