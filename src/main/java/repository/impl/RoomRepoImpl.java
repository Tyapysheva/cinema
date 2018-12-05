package repository.impl;

import entity.Room;
import entity.RoomEntity;
import repository.RoomEntityRepo;
import repository.RoomRepo;

import java.util.ArrayList;
import java.util.List;

public class RoomRepoImpl implements RoomRepo {

    private RoomEntityRepo roomEntityRepo;
    public RoomRepoImpl(RoomEntityRepo roomEntityRepo){
        this.roomEntityRepo=roomEntityRepo;
    }

    @Override
    public List<Room> all() throws Exception{
        List<RoomEntity> roomEntityList = roomEntityRepo.all();
        List<Room> roomList = new ArrayList<>();
        for (RoomEntity roomEntity : roomEntityList){
            Room r = new RoomEntity(roomEntity.nameRoom(),roomEntity.rows(),roomEntity.columns());
            roomList.add(r);
        }
        return roomList;
    }

    @Override
    public Room byId(int id) throws Exception {
        RoomEntity roomEntity = roomEntityRepo.byId(id);
        Room r = new RoomEntity(roomEntity.nameRoom(),roomEntity.rows(),roomEntity.columns());
        return r;
    }

    @Override
    public Room byName(String name) throws Exception {
        RoomEntity roomEntity = roomEntityRepo.byName(name);
        Room r = new RoomEntity(roomEntity.nameRoom(),roomEntity.rows(),roomEntity.columns());
        return r;
    }

    @Override
    public void save(Room room) throws Exception{
       RoomEntity r = new RoomEntity(room.nameRoom(),room.rows(),room.columns());
       roomEntityRepo.save(r);
    }
}
