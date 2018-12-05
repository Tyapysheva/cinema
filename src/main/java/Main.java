import entity.Reservation;
import entity.Room;
import entity.RoomEntity;
import helper.JDBCConnectionHelper;
import repository.RoomRepo;
import service.BasicReservationManager;
import service.management.EntityOpManagement;
import service.management.ModelOpManagement;
import service.management.factory.EntityOpManagementFactory;
import service.management.factory.ModelOpManagementFactory;
import service.management.factory.OperationManagementFactory;

import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        OperationManagementFactory<EntityOpManagement> entityOpFactory = new EntityOpManagementFactory(
                () -> {
                    try {
                        try {
                            return JDBCConnectionHelper.getConnection();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

        ); //provide connection

        OperationManagementFactory<ModelOpManagement> modelOpFactory = new ModelOpManagementFactory(entityOpFactory);

        BasicReservationManager reservationManager = new BasicReservationManager(modelOpFactory);

        Room room = modelOpFactory.runWith(management -> {
            RoomRepo roomRepo = management.roomRepo();
            Room test;
            try {
                test=roomRepo.byId(1);
                return test;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("oy");
            }
            return null;
        });
        System.out.println(room.nameRoom());
        List<Reservation> allReservations = reservationManager.all(room);
       // allReservations.forEach(System.out::println);


    }
}
