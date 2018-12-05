package entity;

import java.time.LocalDateTime;

public interface Reservation {
    int sequence();

    Room room();

    LocalDateTime timed();

    String userd();
}
