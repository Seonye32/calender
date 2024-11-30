package com.alcp.calendar.controller;

import com.alcp.calendar.dto.ScheduleRequestDto;
import com.alcp.calendar.dto.ScheduleResponseDto;
import com.alcp.calendar.model.Schedule;
import com.alcp.calendar.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/schedule")

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
    // 일정 목록 조회 (GET 요청)
    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll(); // 모든 일정 조회
        List<ScheduleResponseDto> response = new ArrayList<>();

        // 모든 일정을 ResponseDto로 변환하여 반환
        for (Schedule schedule : schedules) {
            response.add(new ScheduleResponseDto(schedule));
        }

        return response;
    }
}
