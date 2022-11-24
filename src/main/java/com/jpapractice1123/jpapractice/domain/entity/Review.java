package com.jpapractice1123.jpapractice.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Column(name = "patient_name") //Table에 있는 column명과 일치하게 맞춤
    private String userName;

    @ManyToOne // 하나의 병원에 여러개의 리뷰를 작성할 수 있음
    @JoinColumn(name = "hospital_id") //hospital의 id와 외래키관계를 갖는다.
    @JsonBackReference //순환참조를 방어하기위한 Annotation
    private Hospital hospital;
}

