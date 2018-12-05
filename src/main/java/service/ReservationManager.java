package service;

import entity.Reservation;
import entity.Room;

import java.util.List;

public interface ReservationManager {
    List<Reservation> all(Room room);

    Reservation makeReservation(Room room, int seq) throws IllegalStateException;

    void remove(Reservation reservation);

}
