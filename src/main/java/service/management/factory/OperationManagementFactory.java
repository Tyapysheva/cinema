package service.management.factory;


import java.util.function.Consumer;
import java.util.function.Function;

public interface OperationManagementFactory <T extends AutoCloseable>  {
    T newManagement();
    default <R> R runWith(Function<T, R> f)   {
        try(T m = newManagement()) {
            return f.apply(m);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    default void runWithVoid(Consumer<T> f) {
        Void v = runWith(m -> {
            f.accept(m);
            return null;
        });
    }

}
