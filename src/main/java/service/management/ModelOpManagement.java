package service.management;

import repository.ReservationRepo;
import repository.RoomRepo;

public interface ModelOpManagement extends AutoCloseable {
    ReservationRepo reservationRepo();
    RoomRepo roomRepo();
}
