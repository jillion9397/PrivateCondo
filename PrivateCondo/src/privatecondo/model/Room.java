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
public class Room {
    private int roomId;
    private String roomNumber;
    private int floor;
    private User owner;
    private ServiceReservation serviceRev;

    public Room() {
    }

    public Room(int roomId, String roomNumber, int floor, User owner, ServiceReservation serviceRev) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.owner = owner;
        this.serviceRev = serviceRev;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ServiceReservation getServiceRev() {
        return serviceRev;
    }

    public void setServiceRev(ServiceReservation serviceRev) {
        this.serviceRev = serviceRev;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", roomNumber=" + roomNumber + ", floor=" + floor + ", owner="+owner.getFname() + ", serviceRev=" + serviceRev + '}';
    }

    
    
    
    
}
