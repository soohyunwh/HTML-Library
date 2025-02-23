package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Getter, Setter, toString 자동 생성
@AllArgsConstructor  // 모든 필드를 포함하는 생성자 자동 생성
@NoArgsConstructor  // 기본 생성자 자동 생성
public class Book {
    private String title;
    private String author;
    private String location;
}
