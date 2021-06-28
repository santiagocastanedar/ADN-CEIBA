package co.com.ceiba.dataaccess.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "vehicles",
        foreignKeys = {@ForeignKey(entity = ParkingLotRoom.class,parentColumns = "id",childColumns = "parkingLotId"),
        @ForeignKey(entity = VehicleTypeRoom.class,parentColumns = "id",childColumns = "vehicleType")})
public class VehicleRoom {
    @PrimaryKey
    public String plate;

    @ColumnInfo(name="color")
    public String color;
    @ColumnInfo(name="brand")
    public String brand;
    @ColumnInfo(name="cylinder")
    public int cylinder;
    @ColumnInfo(name="vehicleType")
    public int vehicleType;
    @ColumnInfo(name="parkingLotId")
    public int parkingLotId;

    public VehicleRoom(String plate, String color, String brand, int cylinder, int vehicleType, int parkingLotId) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.cylinder = cylinder;
        this.vehicleType = vehicleType;
        this.parkingLotId = parkingLotId;
    }
}
