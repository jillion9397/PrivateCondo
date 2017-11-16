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
    private int roomNumber;
    private User owner;
    private ServiceReservation serviceRev;

    public Room() {
    }

    public Room(int roomNumber, User owner, ServiceReservation serviceRev) {
        this.roomNumber = roomNumber;
        this.owner = owner;
        this.serviceRev = serviceRev;
    }
    
    
}
