package com.jpapractice1123.jpapractice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateRequest {
    private Integer hospitalId;
    private String title;
    private String content;
    private String userName;
}
