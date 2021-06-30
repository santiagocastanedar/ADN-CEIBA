package co.com.ceiba.dataaccess.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "vehicles")
public class VehicleRoom {
    @PrimaryKey
    @NonNull
    public String plate;

    @ColumnInfo(name="cylinder")
    public int cylinder;
    @ColumnInfo(name="entryDate")
    public String entryDate;
    @ColumnInfo(name="departureDate")
    public String departureDate;

    public VehicleRoom(@NonNull String plate, String entryDate) {
        this.plate = plate;
        this.entryDate = entryDate;
    }
}
