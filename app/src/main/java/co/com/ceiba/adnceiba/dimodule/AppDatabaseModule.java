package co.com.ceiba.adnceiba.dimodule;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import co.com.ceiba.dataaccess.AppDatabase;
import co.com.ceiba.dataaccess.dao.CarDao;
import co.com.ceiba.dataaccess.dao.MotorcycleDao;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public  class AppDatabaseModule {

    @Singleton
    @Provides
    public AppDatabase bindAppdatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context,AppDatabase.class, "parkingDatabase").build();
    }

    @Singleton
    @Provides
    public CarDao providesCarDao(AppDatabase appDatabase){
        return appDatabase.carDao();
    }

    @Singleton
    @Provides
    public MotorcycleDao providesMotorcycleDao(AppDatabase appDatabase){
        return appDatabase.motorcycleDao();
    }
}
