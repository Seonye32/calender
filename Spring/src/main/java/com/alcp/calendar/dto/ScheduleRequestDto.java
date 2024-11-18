package com.alcp.calendar.dto;

import lombok.Getter;
import java.util.Date;

@Getter
public class ScheduleRequestDto {
    private String name;
    private String password;
    private String todo;
    private String date;
}
