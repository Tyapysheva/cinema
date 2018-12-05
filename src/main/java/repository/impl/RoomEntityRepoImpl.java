package repository.impl;

import entity.RoomEntity;
import repository.RoomEntityRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RoomEntityRepoImpl implements RoomEntityRepo {

    private Connection connection;

    public RoomEntityRepoImpl(Connection c) {
        connection = c;
    }


    @Override
    public List<RoomEntity> all() throws SQLException {
        String sql = "SELECT * FROM cinema_room ";
        try (Connection connection = this.connection;
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            List<RoomEntity> roomEntityListList = new ArrayList<RoomEntity>();
            while (rs.next()) {
                RoomEntity r = new RoomEntity(rs.getString("name_room"), rs.getInt("total_row"), rs.getInt("total_col"));
                roomEntityListList.add(r);
            }
            return roomEntityListList;
        }
    }

    @Override
    public RoomEntity byId(long id) throws SQLException {
        String sql = "SELECT name_room,total_row,total_col " +
                "FROM cinema_room WHERE id = ? ";
        try (Connection connection = this.connection;
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new RoomEntity(rs.getString("name_room"), rs.getInt("total_row"), rs.getInt("total_col"));
            }
        }
        return null;

    }

    @Override
    public RoomEntity byName(String name) throws SQLException {
        String sql = "SELECT name_room,total_row,total_col " +
                "FROM cinema_room WHERE name_room = ? ";
        try (Connection connection = this.connection;
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new RoomEntity(rs.getString("name_room"), rs.getInt("total_row"), rs.getInt("total_col"));
            }
        }
        return null;
    }

    @Override
    public void save(RoomEntity room) throws SQLException{
        String sql = "INSERT INTO cinema_room(name_room,total_row,total_col) " +
                "VALUES (?, ?, ?)";
        try (Connection connection = this.connection;
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, room.nameRoom());
            preparedStatement.setInt(2, room.rows());
            preparedStatement.setInt(3, room.columns());
            preparedStatement.executeUpdate();
        }

    }
}
