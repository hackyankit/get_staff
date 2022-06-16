package com.example.gloginform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
//import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Log in");
        mydatabase db = new mydatabase(this);

        Button b1=findViewById(R.id.btnLogin);

        EditText e1,e2;
        e1=findViewById(R.id.editTextLoginMobno);
        e2=findViewById(R.id.editTextLoginPwsd);

        String mobno=e1.getText().toString();
        String pswd=e2.getText().toString();

        TextView signup=findViewById(R.id.signup);
        e1.requestFocus();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,GSignUp.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("aaa",e1.getText().toString());
                Log.d("aaa",e2.getText().toString());

                if(db.checkProp(e1.getText().toString(),e2.getText().toString()))
                {
                    ArrayList<StaffModel>value=new ArrayList<>();
                    value=db.getStaff();
                    //Toast.makeText(MainActivity.this, value.size()+"", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,Staff.class);
                    i.putParcelableArrayListExtra("value",value);
                    startActivity(i);
                }
                else if(db.checkStaff(e1.getText().toString(),e2.getText().toString()))
                {
                    ArrayList<PropModel>value=new ArrayList<>();
                    value=db.getProp();
                    Intent i=new Intent(MainActivity.this,Prop.class);
                    //Toast.makeText(MainActivity.this, value.size()+"", Toast.LENGTH_SHORT).show();
                    i.putParcelableArrayListExtra("value",value);
                    startActivity(i);
                }
                else
                {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Incorrect Credentials")
                            .setMessage("Do you want to signUp?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent iwa = new Intent(MainActivity.this,GSignUp.class);
                                    startActivity(iwa);
                                }
                            }).setNeutralButton("Help", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).show();
                    Toast.makeText(MainActivity.this, "Enter correct details;", Toast.LENGTH_SHORT).show();
                }
                e1.setText("");
                e2.setText("");
//                String scon = "SELECT smobno FROM Staff WHERE smobno = '" + mobno+ "'";
//
//                if(e1.getText().toString().equals("1") && e2.getText().toString().equals("1"))
//                {
//                    Log.d("adi1","func");
//                    Intent isu= new Intent(MainActivity.this,GSignUp.class);
//                    startActivity(isu);
//                }
//                else
//                    Toast.makeText(MainActivity.this, "not signin", Toast.LENGTH_SHORT).show();

            }
        });
    }
}