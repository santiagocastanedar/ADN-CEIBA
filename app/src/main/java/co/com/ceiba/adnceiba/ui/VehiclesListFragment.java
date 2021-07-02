package co.com.ceiba.adnceiba.ui;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.adnceiba.R;
import co.com.ceiba.adnceiba.adapters.VehiclesAdapter;
import co.com.ceiba.adnceiba.databinding.FragmentParkingVehicleBinding;
import co.com.ceiba.adnceiba.databinding.FragmentVehiclesListBinding;
import co.com.ceiba.adnceiba.viewmodel.ParkingLotCarViewModel;
import co.com.ceiba.adnceiba.viewmodel.ParkingLotMotorcycleViewModel;
import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class VehiclesListFragment extends Fragment {

    private FragmentVehiclesListBinding binding;

    ParkingLotCarViewModel parkingLotCarViewModel;
    ParkingLotMotorcycleViewModel parkingLotMotorcycleViewModel;

    private ParkingLot parkingLot;
    private ArrayList<Vehicle> vehicleArrayList;
    List<Car> cars = new ArrayList<>();
    List<Motorcycle> motorcycleList = new ArrayList<>();






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVehiclesListBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = binding.rvVehicles;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        vehicleArrayList = new ArrayList<Vehicle>();
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


        cars =  parkingLotCarViewModel.getCars();
        motorcycleList = parkingLotMotorcycleViewModel.getMotorcycles();

        vehicleArrayList.addAll(cars);
        vehicleArrayList.addAll(motorcycleList);

        VehiclesAdapter adapter = new VehiclesAdapter(vehicleArrayList);
        recyclerView.setAdapter(adapter);

        adapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = adapter.getPayment(parkingLot);
                Toast.makeText(getContext(), "El total a pagar por el vehiculo es: "+total, Toast.LENGTH_SHORT).show();
            }
        });


    }
}