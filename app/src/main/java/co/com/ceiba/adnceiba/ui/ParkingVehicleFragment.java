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
import android.widget.RadioGroup;
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
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ParkingVehicleFragment extends Fragment {


    ParkingLotCarViewModel parkingLotCarViewModel;
    ParkingLotMotorcycleViewModel parkingLotMotorcycleViewModel;

    private FragmentParkingVehicleBinding binding;
    private String entryDate;

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
        parkingLotMotorcycleViewModel =  new ViewModelProvider(requireActivity()).get(ParkingLotMotorcycleViewModel.class);
        parkingLotCarViewModel = new ViewModelProvider(requireActivity()).get(ParkingLotCarViewModel.class);
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

                String plate = binding.txtPlate.getText().toString();

                if(binding.radioCar.isChecked()){
                    try{
                        Car car = new Car(plate,entryDate);
                        parkingLotCarViewModel.executeSaveCar(car);
                        Toast.makeText(getContext(), "Vehiculo ingresado con exito ", Toast.LENGTH_LONG).show();
                        binding.txtPlate.setText("");
                        binding.txtcylinder.setText("");
                    }catch (Exception e){
                        Toast.makeText(getContext(), "Error: "+ e.getMessage() , Toast.LENGTH_LONG).show();

                    }

                }else if(binding.radioMotorcycle.isChecked()){
                    try {
                        int cylinder = Integer.parseInt(binding.txtcylinder.getText().toString());
                        Motorcycle motorcycle = new Motorcycle(plate,entryDate,cylinder);
                        parkingLotMotorcycleViewModel.executeSaveMotorcycle(motorcycle);
                        binding.txtPlate.setText("");
                        binding.txtcylinder.setText("");
                        Toast.makeText(getContext(), "Vehiculo ingresado con exito ", Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(getContext(), "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getContext(), "Debe seleccionar el tipo de vehiculo.", Toast.LENGTH_LONG).show();
                }


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

        binding.rgTypeVehicle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(binding.radioMotorcycle.isChecked()){
                    binding.txtcylinder.setVisibility(View.VISIBLE);
                }else{
                    binding.txtcylinder.setVisibility(View.GONE);
                }
            }
        });


    }




}