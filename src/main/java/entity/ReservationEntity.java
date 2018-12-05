package entity;

import java.time.LocalDateTime;

public class ReservationEntity implements Reservation {

    private long id;
    private LocalDateTime timed;
    private String userd;
    private int sequence;
    private RoomEntity room;

    public ReservationEntity(int sequence, RoomEntity room, LocalDateTime timed, String userd) {
        this.sequence = sequence;
        this.room = room;
        this.timed = timed;
        this.userd = userd;
    }

    @Override
    public int sequence() {
        return sequence;
    }

    @Override
    public RoomEntity room() {
        return room;
    }

    @Override
    public LocalDateTime timed() {
        return timed;
    }

    @Override
    public String userd() {
        return userd;
    }
}
