package service.management;

import repository.ReservationEntityRepo;
import repository.RoomEntityRepo;

public interface EntityOpManagement extends AutoCloseable {
    ReservationEntityRepo reservationEntityRepo();
    RoomEntityRepo roomEntityRepo();
}
