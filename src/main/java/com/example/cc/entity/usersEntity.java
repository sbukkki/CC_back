package com.example.cc.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class usersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    //닉네임
    @Column(nullable = false)
    private String nickName;

    //비밀번호
    @Column(nullable = false)
    private String password;

    //생일
    @Column(nullable = false)
    private Date birthday;

    //국적
    @Column(nullable = false)
    private String nationality;

    //프로필 이미지
    @Column(nullable = true)
    private String imgUrl;

    //구사 언어
    @OneToMany(mappedBy = "userId")
    private List<availableLangEntity> availableLang;

    //희망 학습 언어
    @OneToMany(mappedBy = "userId")
    private List<desiredLangEntity> desiredLang;

    @OneToOne
    @JoinColumn(name = "studentId")
    private userAuthenticationEntity studentId;
}
