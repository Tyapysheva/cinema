package entity;

public class RoomEntity implements Room {
    public long id;
    private String nameRoom;
    private int rows;
    private int columns;

    public RoomEntity(String nameRoom, int rows, int columns) {
        this.nameRoom = nameRoom;
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public String nameRoom() {
        return nameRoom;
    }

    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int columns() {
        return columns;
    }
}
