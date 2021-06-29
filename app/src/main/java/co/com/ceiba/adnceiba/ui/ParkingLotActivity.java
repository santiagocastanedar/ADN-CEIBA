package co.com.ceiba.adnceiba.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import co.com.ceiba.adnceiba.R;
import co.com.ceiba.adnceiba.viewmodel.ParkingLotViewModel;
import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.service.ParkingLotService;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ParkingLotActivity extends AppCompatActivity {

    private TextView tvTitleParking,tvStartDay,tvRateCar,tvRateMotorcycle;
    private Button btnCreateParking,btnBack;
    private EditText txtRateMotorcycleDay,txtRateMotorcyclePerHour,txtRateCarPerDay,txtRateCarPerHour,txtHoraEnd,txtHoraStart,
            txtMaxQuantityMotorcycle,txtMaxQuantityCar,txtName;

    private ParkingLotViewModel parkingLotViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lot);
        parkingLotViewModel = new ViewModelProvider(this).get(ParkingLotViewModel.class);
        init();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        btnCreateParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createParkingLot();
            }
        });
    }


    public void createParkingLot(){
        String name = txtName.getText().toString();
        double rateCarPerHour = Double.parseDouble(txtRateCarPerHour.getText().toString());
        double rateCarPerDay = Double.parseDouble(txtRateCarPerDay.getText().toString());
        double ratMotorPerHour = Double.parseDouble(txtRateMotorcyclePerHour.getText().toString());
        double ratMotorPerDay = Double.parseDouble(txtRateMotorcycleDay.getText().toString());
        int startDay = Integer.parseInt(txtHoraStart.getText().toString());
        int endDay = Integer.parseInt(txtHoraEnd.getText().toString());
        int maxQuantityCar = Integer.parseInt(txtMaxQuantityCar.getText().toString());
        int maxQuantityMotor = Integer.parseInt(txtMaxQuantityMotorcycle.getText().toString());
        ParkingInformationRate parkingInformationRate = new ParkingInformationRate(rateCarPerHour,
                rateCarPerDay,ratMotorPerHour,ratMotorPerDay,startDay,endDay);

        ParkingLot parkingLot = new ParkingLot(1,name,parkingInformationRate,null,maxQuantityCar,maxQuantityMotor);
        parkingLotViewModel.createParkingLot(parkingLot);

    }

    public void init(){
        btnBack = (Button) findViewById(R.id.btnBack);
        btnCreateParking = (Button) findViewById(R.id.btnCreateParking);
        txtRateMotorcycleDay = (EditText) findViewById(R.id.txtRateMotorcycleDay);
        txtRateMotorcyclePerHour = (EditText) findViewById(R.id.txtRateMotorcyclePerHour);
        txtRateCarPerHour = (EditText) findViewById(R.id.txtRateCarPerHour);
        txtRateCarPerDay = (EditText) findViewById(R.id.txtRateMotorcycleDay);
        txtHoraEnd = (EditText) findViewById(R.id.txtHoraEnd);
        txtHoraStart = (EditText) findViewById(R.id.txtHoraStart);
        txtMaxQuantityMotorcycle = (EditText) findViewById(R.id.txtMaxQuantityMotorcycle);
        txtMaxQuantityCar = (EditText) findViewById(R.id.txtMaxQuantityCar);
        txtName = (EditText) findViewById(R.id.txtName);
    }
}