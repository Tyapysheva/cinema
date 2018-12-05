package repository;

import entity.Reservation;
import entity.Room;
import entity.RoomEntity;
import service.management.EntityOpManagement;
import service.management.factory.OperationManagementFactory;

import java.util.List;
import java.util.function.BiFunction;

public class BasicReservationRepo implements ReservationRepo {

    private OperationManagementFactory<EntityOpManagement> opManagementFactory;

    public BasicReservationRepo(OperationManagementFactory<EntityOpManagement> opManagementFactory) {
        this.opManagementFactory = opManagementFactory;
    }

    private <R> R runWithRoom(Room room, BiFunction<RoomEntity, ReservationEntityRepo, R> f) {
        return opManagementFactory.runWith(
                m -> {
                    try {
                        return f.apply(
                                m.roomEntityRepo().byName(room.nameRoom()),
                                m.reservationEntityRepo()
                        );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }
        );
    }

    @Override
    public List<Reservation> all(Room room) {
        runWithRoom(room, (re, rd) -> {
            rd.all(re.id);
            return null;
        });
        return null;

    }

    @Override
    public Reservation bySeq(Room room, int seq) {
        runWithRoom(room, (re, rd) -> {
            rd.bySeq(re.id, seq);
            return null;
        });
        return null;

    }

    @Override
    public void delete(Reservation reservation) {
        runWithRoom(reservation.room(), (re, rd) -> {
            rd.deleteBySeq(re.id, reservation.sequence());
            return null;
        });

    }

    @Override
    public void save(Reservation reservation) {
        runWithRoom(reservation.room(), (re, rd) -> {
            rd.save(/*Please create reservation entity instance here*/null);
            return null;
        });

    }
}
