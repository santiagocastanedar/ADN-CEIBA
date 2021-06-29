package co.com.ceiba.dataaccess.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "vehicles",
        foreignKeys = {@ForeignKey(entity = ParkingLotRoom.class,parentColumns = "id",childColumns = "parkingLotId"),
        @ForeignKey(entity = VehicleTypeRoom.class,parentColumns = "id",childColumns = "vehicleType")})
public class VehicleRoom {
    @PrimaryKey
    @NonNull
    public String plate;

    @ColumnInfo(name="color")
    public String color;
    @ColumnInfo(name="brand")
    public String brand;
    @ColumnInfo(name="cylinder")
    public int cylinder;
    @ColumnInfo(name="vehicleType")
    public int vehicleType;
    @ColumnInfo(name="vehicleTypeName")
    public String vehicleTypeName;
    @ColumnInfo(name="parkingLotId")
    public int parkingLotId;
    @ColumnInfo(name="entryDate")
    public String entryDate;
    @ColumnInfo(name="departureDate")
    public String departureDate;

    public VehicleRoom(String plate, String color, String brand, int cylinder, int vehicleType,String vehicleTypeName, int parkingLotId, String entryDate) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.cylinder = cylinder;
        this.vehicleType = vehicleType;
        this.vehicleTypeName = vehicleTypeName;
        this.parkingLotId = parkingLotId;
        this.entryDate = entryDate;
    }
}
