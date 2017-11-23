/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privatecondo.model;

/**
 *
 * @author poom029
 */
public class RoomServiceStaff {
    private int staffId;
    private String fname;
    private String lname;
    private String staffImagePath;
    private WorkTime[] worktime;

    public RoomServiceStaff() {
    }

    public RoomServiceStaff(int staffId, String fname, String lname, String staffImagePath, WorkTime[] worktime) {
        this.staffId = staffId;
        this.fname = fname;
        this.lname = lname;
        this.staffImagePath = staffImagePath;
        this.worktime = worktime;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getStaffImagePath() {
        return staffImagePath;
    }

    public void setStaffImagePath(String staffImagePath) {
        this.staffImagePath = staffImagePath;
    }

    public WorkTime[] getWorktime() {
        return worktime;
    }

    public void setWorktime(WorkTime[] worktime) {
        this.worktime = worktime;
    }

    @Override
    public String toString() {
        return "RoomServiceStaff{" + "staffId=" + staffId + ", fname=" + fname + ", lname=" + lname + ", staffImagePath=" + staffImagePath + ", worktime=" + worktime + '}';
    }
    
    
    
    
}
