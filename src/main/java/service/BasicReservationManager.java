package service;

import entity.Reservation;
import entity.Room;
import service.management.ModelOpManagement;
import service.management.factory.OperationManagementFactory;

import java.util.List;

public class BasicReservationManager implements ReservationManager{
    private OperationManagementFactory<ModelOpManagement> modelOps;

    public BasicReservationManager(OperationManagementFactory<ModelOpManagement> modelOps) {
        this.modelOps = modelOps;
    }

    @Override
    public List<Reservation> all(Room room) {
        return null;
    }

    @Override
    public Reservation makeReservation(Room room, int seq) throws IllegalStateException {
        return null;
    }

    @Override
    public void remove(Reservation reservation) {

    }
}
