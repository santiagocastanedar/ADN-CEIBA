package co.com.ceiba.adnceiba.ui;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.adnceiba.databinding.FragmentParkingVehicleBinding;
import co.com.ceiba.adnceiba.viewmodel.ParkingLotCarViewModel;
import co.com.ceiba.adnceiba.viewmodel.ParkingLotMotorcycleViewModel;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ParkingVehicleFragment extends Fragment {

    private ParkingLotCarViewModel parkingLotCarViewModel;
    private ParkingLotMotorcycleViewModel parkingLotMotorcycleViewModel;
    private FragmentParkingVehicleBinding binding;
    private String entryDate;
    private AlertDialog.Builder builder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentParkingVehicleBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        binding.buttonCreateVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String plate = binding.editTextPlate.getText().toString();

                if(binding.radioButtonCar.isChecked()){
                    parkingLotCarViewModel.executeSaveCar(plate,entryDate).observe(getViewLifecycleOwner(),carSaved -> {
                        builder.setMessage(carSaved);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    });
                }else if(binding.radioButtonMotorcycle.isChecked()){
                    int cylinder = Integer.parseInt(binding.editTextCylinder.getText().toString());
                    parkingLotMotorcycleViewModel.executeSaveMotorcycle(plate,entryDate,cylinder).observe(getViewLifecycleOwner(),motorcycleSaved ->{
                        builder.setMessage(motorcycleSaved);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    });
                }else{
                    builder.setMessage("Debe seleccionar el tipo de vehiculo.");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                binding.editTextPlate.setText("");
                binding.editTextCylinder.setText("");
            }
        });

        binding.calendarEntryDate.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear = monthOfYear+1;
                String time = new SimpleDateFormat("HH:mm").format(new Date());
                entryDate = year+"-"+monthOfYear+"-"+dayOfMonth+" "+time;
            }
        });

        binding.radioGroupTypeVehicle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(binding.radioButtonMotorcycle.isChecked()){
                    binding.editTextCylinder.setVisibility(View.VISIBLE);
                }else{
                    binding.editTextCylinder.setVisibility(View.GONE);
                }
            }
        });
    }

    public void init(){
        parkingLotMotorcycleViewModel =  new ViewModelProvider(requireActivity()).get(ParkingLotMotorcycleViewModel.class);
        parkingLotCarViewModel = new ViewModelProvider(requireActivity()).get(ParkingLotCarViewModel.class);
        binding.calendarEntryDate.setMaxDate(System.currentTimeMillis());
        builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
    }
}