package repository;

import entity.Reservation;
import entity.Room;

import java.util.List;

public interface ReservationRepo {
    List<Reservation> all(Room room);

    Reservation bySeq(Room room, int seq);

    void delete(Reservation reservation);

    void save(Reservation reservation);

}
