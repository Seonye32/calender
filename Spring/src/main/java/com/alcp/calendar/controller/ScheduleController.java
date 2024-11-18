package com.alcp.calendar.controller;

import com.alcp.calendar.dto.ScheduleRequestDto;
import com.alcp.calendar.dto.ScheduleResponseDto;
import com.alcp.calendar.model.Schedule;
import com.alcp.calendar.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/shcedule")

public class ScheduleController {
    private final ScheduleRepository scheduleRepository;
    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository){
        this.scheduleRepository=scheduleRepository;
    }
    //일정 등록
    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto){
        //RequestDto -> Entity
        Schedule schedule=new Schedule(requestDto);
        //임시저장소 저장
        scheduleRepository.save(schedule);
        //Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto=new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }
}
