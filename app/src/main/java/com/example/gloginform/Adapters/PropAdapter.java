package com.example.gloginform.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gloginform.Models.ProfpModels;
import com.example.gloginform.PropModel;
import com.example.gloginform.R;

import java.util.ArrayList;

public class PropAdapter extends RecyclerView.Adapter<PropAdapter.viewHolder>{

   ArrayList<PropModel>propModels=new ArrayList<>();
    Context context;

    public PropAdapter(ArrayList<PropModel> propModels, Context context) {
        this.propModels = propModels;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.sample_prop,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    PropModel models=propModels.get(position);
    holder.propname.setText(models.getName());
    holder.propAddress.setText(models.getAddress());
    holder.propMobile.setText(models.getMob());
    holder.propfirmname.setText(models.getFirmName());

    }

    @Override
    public int getItemCount() {
        return propModels.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView propname,propAddress,propMobile,propfirmname;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            propname=itemView.findViewById(R.id.propname);
            propAddress=itemView.findViewById(R.id.propaddress);
            propMobile=itemView.findViewById(R.id.moboleprop);
            propfirmname=itemView.findViewById(R.id.firnname);
        }
    }


}
