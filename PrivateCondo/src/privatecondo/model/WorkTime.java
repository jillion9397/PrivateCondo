/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privatecondo.model;

import java.sql.Time;

/**
 *
 * @author poom029
 */
public class WorkTime {
    private int workTimeId;
    private int dayId;
    private String dayStr;
    private Time startTime;
    private Time endTime;

    public WorkTime() {
    }

    public WorkTime(int workTimeId, int dayId, String dayStr, Time startTime, Time endTime) {
        this.workTimeId = workTimeId;
        this.dayId = dayId;
        this.dayStr = dayStr;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getWorkTimeId() {
        return workTimeId;
    }

    public void setWorkTimeId(int workTimeId) {
        this.workTimeId = workTimeId;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public String getDayStr() {
        return dayStr;
    }

    public void setDayStr(String dayStr) {
        this.dayStr = dayStr;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    
    
}
