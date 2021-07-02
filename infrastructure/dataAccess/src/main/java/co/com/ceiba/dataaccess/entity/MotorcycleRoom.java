package co.com.ceiba.dataaccess.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "motorcycles")
public class MotorcycleRoom {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String plate;

    @ColumnInfo(name="cylinder")
    public int cylinder;
    @ColumnInfo(name="entryDate")
    public String entryDate;
    @ColumnInfo(name="departureDate")
    public String departureDate;


    public MotorcycleRoom(@NonNull String plate, int cylinder, String entryDate) {
        this.plate = plate;
        this.cylinder = cylinder;
        this.entryDate = entryDate;

    }
}
