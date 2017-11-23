/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privatecondo.model;

import java.util.Date;

/**
 *
 * @author poom029
 */
public class ServiceReservation {
    private int reserveId;
    private Date reserveDate;
    private WorkTime workTime;

    public ServiceReservation() {
    }

    public ServiceReservation(int reserveId, Date reserveDate, WorkTime workTime) {
        this.reserveId = reserveId;
        this.reserveDate = reserveDate;
        this.workTime = workTime;
    }

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public WorkTime getWorkTime() {
        return workTime;
    }

    public void setWorkTime(WorkTime workTime) {
        this.workTime = workTime;
    }

    @Override
    public String toString() {
        return "ServiceReservation{" + "reserveId=" + reserveId + ", reserveDate=" + reserveDate + ", workTime=" + workTime + '}';
    }

    
    
}
