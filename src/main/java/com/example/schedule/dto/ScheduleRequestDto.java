package com.example.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {

    private Long id;    // id
    private String name; // 작성자명
    private String passWord; // 비밀번호
    private String contents; // 할일 내용
}
