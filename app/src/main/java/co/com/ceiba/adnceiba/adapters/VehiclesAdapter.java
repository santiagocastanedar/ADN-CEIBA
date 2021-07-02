package co.com.ceiba.adnceiba.adapters;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.com.ceiba.adnceiba.R;
import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.service.PaymentVehicleCar;
import co.com.ceiba.domain.service.PaymentVehicleMotorcycle;

import static co.com.ceiba.domain.utils.Constant.CAR;


public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.ViewHolder> implements View.OnClickListener{

    ArrayList<Vehicle> vehicleArrayList;
    private View.OnClickListener listener;
    int positionSelected = 0;

    public VehiclesAdapter(ArrayList<Vehicle> vehicleArrayList) {
        this.vehicleArrayList = vehicleArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VehiclesAdapter.ViewHolder holder, int position) {
        holder.addVehicles(vehicleArrayList.get(position));
        final int pos = position;
        holder.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionSelected = position;
            }
        });

    }

    @Override
    public int getItemCount() {
        return vehicleArrayList.size();
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }

    }

    public double getPayment(ParkingLot parkingLot){
        double total = 0;
        long time = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = dateFormat.format(new Date());
        Vehicle vehicleSelected =  new Vehicle(vehicleArrayList.get(positionSelected).getPlate(),
                vehicleArrayList.get(positionSelected).getEntryDate(),vehicleArrayList.get(positionSelected).getDepartureDate());

        if(vehicleArrayList.get(positionSelected).getType() == CAR){
            PaymentVehicleCar paymentVehicleCar = new PaymentVehicleCar(parkingLot);
            time = parkingLot.calculateTimeInParkingLot(vehicleSelected.getEntryDate(),date);
            total = paymentVehicleCar.calculatePaymentVehicle(time,parkingLot.getParkingInformationRate().getHourStartDay(),
                    parkingLot.getParkingInformationRate().getHourStartDay());
        }else{
            //TODO
        }
        return total;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlate;
        TextView tvEntryDate;
        TextView tvType;
        Button btnPay;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvPlate = itemView.findViewById(R.id.tvPlate);
            tvEntryDate = itemView.findViewById(R.id.tvEntryDate);
            tvType = itemView.findViewById(R.id.tvType);
            btnPay = itemView.findViewById(R.id.btnPay);
        }

        public void addVehicles(Vehicle vehicle) {
            tvPlate.setText(vehicle.getPlate());
            tvEntryDate.setText(vehicle.getEntryDate());
            tvType.setText(vehicle.getType());
        }
    }
}
