package org.excavator.boot.optaplanner.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Timeslot {
    private DayOfWeek dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    public Timeslot(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
