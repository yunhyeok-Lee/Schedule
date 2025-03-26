package com.example.schedule.controller;


import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();


    // 일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> creatSchedule(@RequestBody ScheduleRequestDto dto) {

        // 식별자가 1씩 증가

        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        // 요청 받은 데이터로 객체 생성

        Schedule schedule = new Schedule(scheduleId, dto.getName(), dto.getPassWord(), dto.getContents());

        // DB에 저장

        scheduleList.put(scheduleId, schedule);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.CREATED);
    }


    // 전체 일정 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule(){

        // init List
        List<ScheduleResponseDto> responseList = new ArrayList<>();

        // HashMap<Schedule>
        for(Schedule schedule : scheduleList.values()){
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);

        }

        return new ResponseEntity<>(responseList, HttpStatus.OK);

    }

    // 선택 일정 조회
    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findSchedule(@PathVariable Long id){

        Schedule schedule = scheduleList.get(id);

        if (schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
        return new ResponseEntity<>(responseDto, HttpStatus.OK) ;
    }


    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateScheduleById(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto

    ){
        Schedule schedule = scheduleList.get(id);

        if (schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        schedule.update(dto);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule),HttpStatus.OK);

    }

    // 삭제
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id){

        scheduleList.remove(id);
    }



}