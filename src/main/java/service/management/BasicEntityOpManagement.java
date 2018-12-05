package service.management;

import repository.ReservationEntityRepo;
import repository.RoomEntityRepo;
import repository.impl.RoomEntityRepoImpl;

import java.sql.Connection;

public class BasicEntityOpManagement implements EntityOpManagement{

    private final Connection connection;

    private final boolean closeConnectionOnClose;

    public BasicEntityOpManagement(Connection connection, boolean closeConnectionOnClose) {
        this.connection = connection;
        this.closeConnectionOnClose = closeConnectionOnClose;
    }

    @Override
    public ReservationEntityRepo reservationEntityRepo() {

        // create repo, set connection to it
        return null;
    }

    @Override
    public RoomEntityRepo roomEntityRepo() {
        return new RoomEntityRepoImpl(connection);
    }

    @Override
    public void close() throws Exception {
        if (closeConnectionOnClose) {
            connection.close();
        }

    }
}
