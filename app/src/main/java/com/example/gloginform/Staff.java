package com.example.gloginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.gloginform.Adapters.PropAdapter;
import com.example.gloginform.Adapters.StaffAdapter;
import com.example.gloginform.Models.ProfpModels;
import com.example.gloginform.Models.StafModel;

import java.util.ArrayList;
import java.util.List;

public class Staff extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        ArrayList<StaffModel> list;
        ArrayList<StafModel>list1;
        Intent i=getIntent();
        getSupportActionBar().setTitle("Staff Details...");
        recyclerView=findViewById(R.id.recylerView);
        list=i.getParcelableArrayListExtra("value");
        //Toast.makeText(this, list.size()+"", Toast.LENGTH_SHORT).show();
       StaffAdapter staffAdapter=new StaffAdapter(list,this);
       recyclerView.setAdapter(staffAdapter);
       LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);
       recyclerView.setLayoutManager(layoutManager);
    }
}