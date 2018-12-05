package service.management;

import repository.BasicReservationRepo;
import repository.ReservationRepo;
import repository.RoomRepo;
import repository.impl.RoomRepoImpl;


public class BasicModelOpManagement implements ModelOpManagement {

    private EntityOpManagement entityOps;

    public BasicModelOpManagement(EntityOpManagement entityOpsFactory) {
        this.entityOps = entityOpsFactory;
    }

    @Override
    public ReservationRepo reservationRepo() {
        return new BasicReservationRepo(() -> entityOps);
    }

    @Override
    public RoomRepo roomRepo() {
        return new RoomRepoImpl(entityOps.roomEntityRepo());
    }

    @Override
    public void close() throws Exception {
        entityOps.close();
    }
}
