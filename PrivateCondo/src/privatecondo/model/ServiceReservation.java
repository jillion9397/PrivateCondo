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
    private Room room;

    public ServiceReservation() {
    }

    public ServiceReservation(int reserveId, Date reserveDate, WorkTime workTime, Room room) {
        this.reserveId = reserveId;
        this.reserveDate = reserveDate;
        this.workTime = workTime;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "ServiceReservation{" + "reserveId=" + reserveId + ", reserveDate=" + reserveDate + ", workTime=" + workTime + ", room=" + room + '}';
    }

    

    
    
}
