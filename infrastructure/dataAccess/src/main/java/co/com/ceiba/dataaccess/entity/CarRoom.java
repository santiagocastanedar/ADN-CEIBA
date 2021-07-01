package co.com.ceiba.dataaccess.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cars")
public class CarRoom {
    @PrimaryKey
    @NonNull
    public String plate;

    @ColumnInfo(name="entryDate")
    public String entryDate;
    @ColumnInfo(name="departureDate")
    public String departureDate;

    public CarRoom(@NonNull String plate, String entryDate) {
        this.plate = plate;
        this.entryDate = entryDate;
    }
}
