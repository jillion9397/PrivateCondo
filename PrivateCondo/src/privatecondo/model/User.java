/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privatecondo.model;

import java.util.ArrayList;

/**
 *
 * @author poom029
 */
public class User {
    public static final int TYPE_ADMIN=0;
    public static final int TYPE_USER=1;
       
    private int userId;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private ArrayList<Room> roomOwn;
    private Room roomLive;
    private String phone;
    private String line;
    private int userType;
    private String userTypeStr;
    

    public User() {
    }

    public User(int userId, String fname, String lname, String username, String password, ArrayList<Room> roomOwn, Room roomLive, String phone, String line, int userType, String userTypeStr) {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.roomOwn = roomOwn;
        this.roomLive = roomLive;
        this.phone = phone;
        this.line = line;
        this.userType = userType;
        this.userTypeStr = userTypeStr;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Room> getRoomOwn() {
        return roomOwn;
    }

    public void setRoomOwn(ArrayList<Room> roomOwn) {
        this.roomOwn = roomOwn;
    }

    public Room getRoomLive() {
        return roomLive;
    }

    public void setRoomLive(Room roomLive) {
        this.roomLive = roomLive;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserTypeStr() {
        return userTypeStr;
    }

    public void setUserTypeStr(String userTypeStr) {
        this.userTypeStr = userTypeStr;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", username=" + username + ", password=" + password + ", roomOwn=" + roomOwn + ", roomLive=" + roomLive + ", phone=" + phone + ", line=" + line + ", userType=" + userType + ", userTypeStr=" + userTypeStr + '}';
    }

   

    
    
    
}
