package co.com.ceiba.adnceiba.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import co.com.ceiba.adnceiba.R;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainMenuActivity extends AppCompatActivity {


    private NavController navController;
    private NavHostFragment navHostFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this,navController);
//ParkingLotRepositoryImpl parkingLotRepository =  new ParkingLotRepositoryImpl(AppDatabase.getDataBase(this));
    }


    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
}