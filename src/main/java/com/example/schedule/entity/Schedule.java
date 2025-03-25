package com.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.*;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;    // id
    private String name; // 작성자명
    private String passWord; // 비밀번호
    private String createdAt; // 작성일
    private String updatedAt; // 수정일
    private String contents; // 할일 내용
}
