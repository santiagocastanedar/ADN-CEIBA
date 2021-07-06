package co.com.ceiba.dataaccess;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import javax.inject.Inject;

import co.com.ceiba.dataaccess.dao.CarDao;
import co.com.ceiba.dataaccess.dao.MotorcycleDao;
import co.com.ceiba.dataaccess.entity.CarRoom;
import co.com.ceiba.dataaccess.entity.MotorcycleRoom;
import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;


@Database(entities = {CarRoom.class, MotorcycleRoom.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MotorcycleDao motorcycleDao();
    public abstract CarDao carDao();
}
