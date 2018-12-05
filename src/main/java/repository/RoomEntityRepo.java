package repository;


import entity.RoomEntity;

import java.util.List;

public interface RoomEntityRepo {
    List<RoomEntity> all()throws Exception;
    RoomEntity byId(long id) throws Exception;

    RoomEntity byName(String name) throws Exception;

    void save(RoomEntity room)throws Exception;
}


