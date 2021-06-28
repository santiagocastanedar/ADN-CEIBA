package co.com.ceiba.dataaccess.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "parkingLots")
public class ParkingLotRoom {
    @PrimaryKey
    public int id;

    @ColumnInfo(name="name")
    public String name;
    @ColumnInfo(name="maxQuantityCar")
    public int maxQuantityCar;
    @ColumnInfo(name="maxQuantityMotorcycle")
    public int maxQuantityMotorcycle;
    @ColumnInfo(name="rateCarPerHour")
    public double rateCarPerHour;
    @ColumnInfo(name="rateCarPerDay")
    public double rateCarPerDay;
    @ColumnInfo(name="rateMotorcyclePerHour")
    public double rateMotorcyclePerHour;
    @ColumnInfo(name="rateMotorcyclePerDay")
    public double rateMotorcyclePerDay;
    @ColumnInfo(name="hourStartDay")
    public int hourStartDay;
    @ColumnInfo(name="hourEndDay")
    public int hourEndDay;

    public ParkingLotRoom(int id, String name, int maxQuantityCar, int maxQuantityMotorcycle, double rateCarPerHour, double rateCarPerDay, double rateMotorcyclePerHour, double rateMotorcyclePerDay, int hourStartDay, int hourEndDay) {
        this.id = id;
        this.name = name;
        this.maxQuantityCar = maxQuantityCar;
        this.maxQuantityMotorcycle = maxQuantityMotorcycle;
        this.rateCarPerHour = rateCarPerHour;
        this.rateCarPerDay = rateCarPerDay;
        this.rateMotorcyclePerHour = rateMotorcyclePerHour;
        this.rateMotorcyclePerDay = rateMotorcyclePerDay;
        this.hourStartDay = hourStartDay;
        this.hourEndDay = hourEndDay;
    }
}
