package dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class RoomDTO {

    private String name;
    private int rows;
    private int columns;

    public RoomDTO() {
    }

    public RoomDTO(String name,int rows,int columns) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
    }


}
