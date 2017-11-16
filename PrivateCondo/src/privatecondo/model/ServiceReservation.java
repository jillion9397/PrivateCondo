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
    private WorkTime workTimeId;

    public ServiceReservation() {
    }

    public ServiceReservation(int reserveId, Date reserveDate, WorkTime workTimeId) {
        this.reserveId = reserveId;
        this.reserveDate = reserveDate;
        this.workTimeId = workTimeId;
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

    public WorkTime getWorkTimeId() {
        return workTimeId;
    }

    public void setWorkTimeId(WorkTime workTimeId) {
        this.workTimeId = workTimeId;
    }
    
    
}
