package com.example.gloginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gloginform.Adapters.PropAdapter;
import com.example.gloginform.Models.ProfpModels;

import java.util.ArrayList;

public class Prop extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop);
        ArrayList<PropModel> list;
        Intent i=getIntent();
        getSupportActionBar().setTitle("Proprietor Details...");

        recyclerView=findViewById(R.id.recylerView);

        list=i.getParcelableArrayListExtra("value");
        //Toast.makeText(this, "hii", Toast.LENGTH_SHORT).show();
        PropAdapter adapter=new PropAdapter(list,this);


//        for(int j=0;j<list.size();j++) {
//            String name, address, mobile;
//            name = list.get(j).getName();
//            address = list.get(j).getAddress();
//            mobile = list.get(j).getMob();
//            ArrayList<ProfpModels> listmodel = new ArrayList<>();
//            listmodel.add(new ProfpModels(name, mobile, address));
//
//        ArrayList<ProfpModels>listmodel=new ArrayList<>();
//        listmodel.add(new ProfpModels("Abhishek Jha","Patna","9709110398"));
//        listmodel.add(new ProfpModels("Ankit","Patna","9709110398"));
////        listmodel.add(new ProfpModels("Abhishek jha","Patna","9709110398"));
            //PropAdapter adapter = new PropAdapter(list, this);
            recyclerView.setAdapter(adapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);
            recyclerView.setLayoutManager(layoutManager);
//        }
    }
}