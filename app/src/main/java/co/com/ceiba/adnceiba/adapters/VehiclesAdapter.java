package co.com.ceiba.adnceiba.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.adnceiba.R;
import co.com.ceiba.adnceiba.ui.VehicleView;
import co.com.ceiba.domain.entity.Vehicle;


public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.ViewHolder>{

    private List<Vehicle> vehicleArrayList;
    private VehicleView vehicleView;

    public VehiclesAdapter(ArrayList<Vehicle> vehicleArrayList,VehicleView vehicleView) {
        this.vehicleArrayList = vehicleArrayList;
        this.vehicleView = vehicleView;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VehiclesAdapter.ViewHolder holder, int position) {
        holder.addVehicles(vehicleArrayList.get(position));
        final int pos = position;
        holder.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicleView.onClickPay(vehicleArrayList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return vehicleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlate;
        TextView tvEntryDate;
        TextView tvType;
        Button btnPay;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvPlate = itemView.findViewById(R.id.textViewPlate);
            tvEntryDate = itemView.findViewById(R.id.textViewEntryDateList);
            tvType = itemView.findViewById(R.id.textViewType);
            btnPay = itemView.findViewById(R.id.buttonPay);
        }

        public void addVehicles(Vehicle vehicle) {
            tvPlate.setText(vehicle.getPlate());
            tvEntryDate.setText(vehicle.getEntryDate());
            tvType.setText(vehicle.getType());
        }
    }

    public void updateList(List<Vehicle> usersFilter){
        this.vehicleArrayList = usersFilter;
        notifyDataSetChanged();
    }
}
