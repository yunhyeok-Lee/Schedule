package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;    // id
    private String name; // 작성자명
    private String createdAt; // 작성일
    private String updatedAt; // 수정일
    private String contents; // 할일 내용

    public  ScheduleResponseDto(Schedule schedule){
        this.id= schedule.getId();
        this.contents = schedule.getContents();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
        this.name = schedule.getName();
    }
}
