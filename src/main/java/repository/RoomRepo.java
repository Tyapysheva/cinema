package repository;

import entity.Room;

import java.util.List;

public interface RoomRepo {
    List<Room> all()throws Exception;

    Room byId(int id) throws Exception;

    Room byName(String name) throws Exception;

    void save(Room room)throws Exception;

}
