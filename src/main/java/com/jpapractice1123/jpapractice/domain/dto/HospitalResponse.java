package com.jpapractice1123.jpapractice.domain.dto;

import com.jpapractice1123.jpapractice.domain.entity.Hospital;
import com.jpapractice1123.jpapractice.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponse {
    @Id
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Review> reviews; //oneToMany로 일대 다 관계를 설정해 주어서 review를 불러올 수 있다.


    public static HospitalResponse of(Hospital hospital) {
        //HospitalResponse로 변환하주는 로직
        return HospitalResponse.builder()
                .id(hospital.getId())
                .roadNameAddress(hospital.getRoadNameAddress())
                .hospitalName(hospital.getHospitalName())
                .reviews(hospital.getReviews())
                .build();
    }
}
