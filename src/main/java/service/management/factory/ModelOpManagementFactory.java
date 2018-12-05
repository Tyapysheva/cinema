package service.management.factory;

import service.management.BasicModelOpManagement;
import service.management.EntityOpManagement;
import service.management.ModelOpManagement;

public class ModelOpManagementFactory implements OperationManagementFactory<ModelOpManagement>{
    private OperationManagementFactory<EntityOpManagement> eopF;

    public ModelOpManagementFactory(OperationManagementFactory<EntityOpManagement> eopF) {
        this.eopF = eopF;
    }

    @Override
    public ModelOpManagement newManagement() {
        return new BasicModelOpManagement(eopF.newManagement());

    }
}
