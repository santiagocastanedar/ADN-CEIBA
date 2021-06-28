package co.com.ceiba.dataaccess.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "vehicles_type",
        foreignKeys = {@ForeignKey(entity = ParkingLotRoom.class,parentColumns = "id",childColumns = "parkingLotId")})
public class VehicleTypeRoom {
    @PrimaryKey
    private int id;
    @ColumnInfo(name="name")
    private String name;
    @ColumnInfo(name="parkingLotId")
    public int parkingLotId;

    public VehicleTypeRoom(int id, String name, int parkingLotId) {
        this.id = id;
        this.name = name;
        this.parkingLotId = parkingLotId;
    }
}
