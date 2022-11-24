package com.jpapractice1123.jpapractice.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    private Integer id;
    private String roadNameAddress;
    @Column(name = "name")
    private String hospitalName;

    //fetch =
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY) //mappedBy : 양방향 관계의 주인을 hospital로 정한다는 뜻이다.
    @JsonManagedReference//순환참조를 방어하기위한 Annotation
    private List<Review> reviews;
}
