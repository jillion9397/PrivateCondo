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
public class User {
    public static final int TYPE_ADMIN=1;
    public static final int TYPE_USER=2;
       
    private int userId;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private Room[] roomOwn;
    private Room roomLive;
    private String phone;
    private String line;
    private int userType;
    private String userTypeStr;
    

    public User() {
    }

    public User(int userId, String fname, String lname, String username, String password, Room[] roomOwn, Room roomLive, String phone, String line, int userType, String userTypeStr) {
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

    public Room[] getRoomOwn() {
        return roomOwn;
    }

    public void setRoomOwn(Room[] roomOwn) {
        this.roomOwn = roomOwn;
    }

    public Room getRoomLive() {
        return roomLive;
    }

    public void setRoomLive(Room roomLive) {
        this.roomLive = roomLive;
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


    
    
    
}
