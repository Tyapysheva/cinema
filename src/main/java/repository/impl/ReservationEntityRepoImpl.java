package repository.impl;

import entity.ReservationEntity;
import repository.ReservationEntityRepo;

import java.util.List;

public class ReservationEntityRepoImpl implements ReservationEntityRepo {
    @Override
    public ReservationEntity byId(long id) {
        return null;
    }

    @Override
    public ReservationEntity bySeq(long fk, int seq) {
        return null;
    }

    @Override
    public List<ReservationEntity> all(long fk) {
        return null;
    }

    @Override
    public ReservationEntity save(ReservationEntity reservationEntity) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void deleteBySeq(long fk, int seq) {

    }
}
