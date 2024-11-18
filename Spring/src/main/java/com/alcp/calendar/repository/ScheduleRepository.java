package com.alcp.calendar.repository;

import com.alcp.calendar.model.Schedule;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ScheduleRepository {
    private static final Map<Long,Schedule> scheduleList=new HashMap<>();
    private static long sequence=0L;
    public void save(Schedule schedule){
        schedule.setId(++sequence);
        scheduleList.put(schedule.getId(),schedule);
    }
    public Schedule findById(Long id){
        return scheduleList.get(id);
    }
    public List<Schedule> findAll(){
        return new ArrayList<>(scheduleList.values());
    }
}
