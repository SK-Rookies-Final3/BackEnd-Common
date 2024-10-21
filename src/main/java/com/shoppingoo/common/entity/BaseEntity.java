package com.shoppingoo.common.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass // 이 클래스를 상속받는 엔티티 클래스에 이 매핑 정보를 포함
@SuperBuilder
public class BaseEntity {

    // 식별키 (Primary Key)
    @Id // 이 필드가 기본 키임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 값을 자동 생성
    private int id; // 엔티티의 고유 식별자
}
