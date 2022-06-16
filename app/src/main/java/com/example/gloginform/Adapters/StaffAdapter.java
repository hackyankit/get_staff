package com.example.gloginform.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gloginform.Models.StafModel;
import com.example.gloginform.R;
import com.example.gloginform.StaffModel;

import java.util.ArrayList;

public class StaffAdapter extends  RecyclerView.Adapter<StaffAdapter.viewHolder>{
    ArrayList<StaffModel>staffModels=new ArrayList<>();
    Context context;

    public StaffAdapter(ArrayList<StaffModel> staffModels, Context context) {
        this.staffModels = staffModels;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_staff,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    StaffModel staffModel=staffModels.get(position);
    holder.name.setText(staffModel.getName());
    holder.phone.setText(staffModel.getMob());
    holder.address.setText(staffModel.getAddress());
    //holder.firmname.setText(staffModel.getName());
    }

    @Override
    public int getItemCount() {
        return staffModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name,address,phone,firmname;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.propName);
            address=itemView.findViewById(R.id.propAddress);
            phone=itemView.findViewById(R.id.propPhone);
            //firmname=itemView.findViewById(R.id.firnname);
        }
    }
}
