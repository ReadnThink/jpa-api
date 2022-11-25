package com.jpapractice1123.jpapractice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class ReviewReadResponse {
    private Long id;
    private String title;
    private String content;
    private String patientName;
    private String hospitalName;
}
