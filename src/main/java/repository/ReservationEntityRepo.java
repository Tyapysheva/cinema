package repository;

import entity.ReservationEntity;

import java.util.List;

public interface ReservationEntityRepo {
    ReservationEntity byId(long id);
    ReservationEntity bySeq(long fk, int seq);

    List<ReservationEntity> all(long fk);

    ReservationEntity save(ReservationEntity reservationEntity);

    void delete(long id);

    void deleteBySeq(long fk, int seq);
}


