package co.com.ceiba.adnceiba.ui;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
import co.com.ceiba.adnceiba.databinding.FragmentVehiclesListBinding;
import co.com.ceiba.adnceiba.viewmodel.ParkingLotCarViewModel;
import co.com.ceiba.adnceiba.viewmodel.ParkingLotMotorcycleViewModel;
import co.com.ceiba.application.services.PaymentAplication;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class VehiclesListFragment extends Fragment implements VehicleView{

    private FragmentVehiclesListBinding binding;
    private ParkingLotCarViewModel parkingLotCarViewModel;
    private ParkingLotMotorcycleViewModel parkingLotMotorcycleViewModel;
    private PaymentAplication paymentAplication;
    private ArrayList<Vehicle> vehicleArrayList;
    private List<Car> cars = new ArrayList<>();
    private List<Motorcycle> motorcycleList = new ArrayList<>();
    private AlertDialog.Builder builder;
    private VehiclesAdapter adapter;

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
        init();
        try {
            setUpRecyclerView();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClickPost(Vehicle vehicle) {
        double total = paymentAplication.calculatePayment(vehicle);
        builder.setPositiveButton(R.string.pay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                vehicleArrayList.remove(vehicle);
                adapter.updateList(vehicleArrayList);
                Toast.makeText(getContext(), "Pago realizado con exito.", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setMessage("El total a pagar por el vehiculo es: "+total);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void init(){
        parkingLotMotorcycleViewModel =  new ViewModelProvider(requireActivity()).get(ParkingLotMotorcycleViewModel.class);
        parkingLotCarViewModel = new ViewModelProvider(requireActivity()).get(ParkingLotCarViewModel.class);
        paymentAplication = new PaymentAplication();
        vehicleArrayList = new ArrayList<Vehicle>();
        builder = new AlertDialog.Builder(getActivity());
    }

    public void setUpRecyclerView() throws InterruptedException {
        RecyclerView recyclerView = binding.recyclerViewVehicles;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        cars =  parkingLotCarViewModel.getCars();
        motorcycleList = parkingLotMotorcycleViewModel.getMotorcycles();
        vehicleArrayList.addAll(cars);
        vehicleArrayList.addAll(motorcycleList);
        adapter = new VehiclesAdapter(vehicleArrayList,this);
        recyclerView.setAdapter(adapter);
    }
}