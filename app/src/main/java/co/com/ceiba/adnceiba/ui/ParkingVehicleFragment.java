package co.com.ceiba.adnceiba.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import co.com.ceiba.adnceiba.R;
import co.com.ceiba.adnceiba.databinding.FragmentParkingVehicleBinding;
import co.com.ceiba.adnceiba.viewmodel.ParkingLotCarViewModel;
import co.com.ceiba.adnceiba.viewmodel.ParkingLotMotorcycleViewModel;
import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ParkingVehicleFragment extends Fragment {


    ParkingLotCarViewModel parkingLotCarViewModel;

    private FragmentParkingVehicleBinding binding;
    private String entryDate;
    private ParkingLotMotorcycleViewModel parkingLotMotorcycleViewModel;
    private ParkingLot parkingLot;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentParkingVehicleBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parkingLotCarViewModel = new ViewModelProvider(requireActivity()).get(ParkingLotCarViewModel.class);
        //parkingLotMotorcycleViewModel =  new ViewModelProvider(requireActivity()).get(ParkingLotMotorcycleViewModel.class);
        parkingLot =  new ParkingLot(1,"Santiagos ParkingLot",
                new ParkingInformationRate(1000,
                        8000,
                        500,
                        4000,
                        9,
                        24),
                null,20,10);
        binding.btnCreateVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dateS = entryDate;
                if(binding.radioCar.isChecked()){
                    try{
                        Car car = new Car(binding.txtPlate.getText().toString(),entryDate);
                    }catch (Exception e){
                        Toast.makeText(getContext(), "Error: "+ e.getMessage() , Toast.LENGTH_LONG).show();
                    }

                    //parkingLotCarViewModel.executeSaveCar(car);
                }else if(binding.radioMotorcycle.isChecked()){
                }else{
                    Toast.makeText(getContext(), "Debe seleccionar el tipo de vehiculo.", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getContext(), " Se creo correctamente: "+dateS, Toast.LENGTH_SHORT).show();

            }
        });

        binding.calendarEntryDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month = month+1;
                String time = new SimpleDateFormat("HH:mm").format(new Date());
                entryDate = year+"-"+month+"-"+dayOfMonth+" "+time;

            }
        });


    }




}