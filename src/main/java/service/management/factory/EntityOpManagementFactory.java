package service.management.factory;

import service.management.BasicEntityOpManagement;
import service.management.EntityOpManagement;

import java.sql.Connection;
import java.util.function.Supplier;

public class EntityOpManagementFactory implements OperationManagementFactory<EntityOpManagement> {


    private static Supplier<Connection> sc;

    public EntityOpManagementFactory(Supplier<Connection> sc) {
        this.sc = sc;
    }


    @Override
    public EntityOpManagement newManagement() {
        return new BasicEntityOpManagement(sc.get(), true);

    }
}
