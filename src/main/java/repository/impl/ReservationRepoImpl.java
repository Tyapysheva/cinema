package repository.impl;

import entity.Reservation;
import entity.Room;
import repository.ReservationRepo;

import java.util.List;

public class ReservationRepoImpl implements ReservationRepo {
    @Override
    public List<Reservation> all(Room room) {
        return null;
    }

    @Override
    public Reservation bySeq(Room room, int seq) {
        return null;
    }

    @Override
    public void delete(Reservation reservation) {

    }

    @Override
    public void save(Reservation reservation) {

    }
}
