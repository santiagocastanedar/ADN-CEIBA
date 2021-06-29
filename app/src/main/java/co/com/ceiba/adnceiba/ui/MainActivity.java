package co.com.ceiba.adnceiba.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.com.ceiba.adnceiba.R;
import co.com.ceiba.dataaccess.AppDatabase;
import co.com.ceiba.dataaccess.repository.ParkingLotRepositoryImpl;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private TextView tvTitle,tvDescription;
    private Button btnAddParkingLot,btnAddVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        btnAddParkingLot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ParkingLotActivity.class);
                startActivity(i);
            }
        });
        //ParkingLotRepositoryImpl parkingLotRepository =  new ParkingLotRepositoryImpl(AppDatabase.getDataBase(this));
    }

    public void init(){
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        btnAddParkingLot = (Button) findViewById(R.id.btnAddParkinfLot);
        btnAddVehicle = (Button) findViewById(R.id.btnAddVehicle);
    }
}