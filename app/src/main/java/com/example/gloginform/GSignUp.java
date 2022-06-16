package com.example.gloginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class GSignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String name,address,password,mobileno;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gsign_up);
        Button b2 = findViewById(R.id.btnSignUp);
        setTitle("Sign Up");
        mydatabase obj = new mydatabase(this);

        EditText et00 = findViewById(R.id.editTextnm);
        et00.requestFocus();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText etname = findViewById(R.id.editTextnm);
                EditText etaddress = findViewById(R.id.editTextAddress);
                EditText etpassword = findViewById(R.id.editTextpswd);
                EditText etmobno = findViewById(R.id.editTextMobno);
                EditText etfrmnm = findViewById(R.id.editTextFirmName);

                String name = etname.getText().toString();
                String address = etaddress.getText().toString();
                String password = etpassword.getText().toString();
                String mobileno = etmobno.getText().toString();
                String firmname = etfrmnm.getText().toString();

                RadioGroup rg2=findViewById(R.id.radioGrp);
                int i2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2;
                rb2 = findViewById(i2);
//                Toast.makeText(getApplicationContext(),radioButton1.getText().toString(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(GSignUp.this,radioButton1.getText().toString() , Toast.LENGTH_SHORT).show();
                if(rb2.getText().toString().equals("Staff"))
                {
                    //Log.d("abhis","insertsrec");
                    Boolean var = obj.insertsrec(name, mobileno, password, address);
                    if (var == true)
                    {
                        Toast.makeText(GSignUp.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                        Intent iwa = new Intent(GSignUp.this,MainActivity.class);
                        startActivity(iwa);
                    }
                    else
                        Toast.makeText(GSignUp.this, "Record Not Inserted", Toast.LENGTH_SHORT).show();
                }
                else if(rb2.getText().toString().equals("Proprietor"))
                {
                    Boolean var = obj.insertprec(name, mobileno, password, address, firmname);
                    if (var == true)
                    {
                        Toast.makeText(GSignUp.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                        Intent iwa = new Intent(GSignUp.this,MainActivity.class);
                        startActivity(iwa);
                    }
                    else
                        Toast.makeText(GSignUp.this, "Record Not Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(GSignUp.this, "not selected", Toast.LENGTH_SHORT).show();
            }
        });
        RadioGroup rg=findViewById(R.id.radioGrp);

        EditText frmnm=findViewById(R.id.editTextFirmName);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            String str;
            RadioButton rb;
              @Override
              public void onCheckedChanged(RadioGroup radioGroup, int i)
              {
                  switch (i)
                  {
                      case R.id.radioBtnProp:
                          frmnm.setVisibility(View.VISIBLE);
                          rb=findViewById(R.id.radioBtnProp);
                          str=rb.getText().toString();
                          Toast.makeText(GSignUp.this, str, Toast.LENGTH_SHORT).show();
                          break;
                      case R.id.radioBtnStaff:
                          frmnm.setVisibility(View.INVISIBLE);
                          rb=findViewById(R.id.radioBtnStaff);
                          str=rb.getText().toString();
                          Toast.makeText(GSignUp.this, str.toString(), Toast.LENGTH_SHORT).show();
                          break;
                  }
              }
            });
    }
}

//        public void checkButton(View view){
//        int radioId = radioGroup.getCheckedRadioButtonId();
//        radioButton = findViewById(radioId);
//        Toast.makeText(this,"Selected Radio Button: "+ radioButton.getText(),Toast.LENGTH_LONG).show();
//}

//Code}

//                EditText et1=findViewById(R.id.editTextnm);
//                EditText et2=findViewById(R.id.editTextMobno);
//                EditText et3=findViewById(R.id.editTextpswd);
//                EditText et4=findViewById(R.id.editTextAddress);
//
//                RadioGroup radio=findViewById(R.id.radioGrp);

//
//                int i=radio.getCheckedRadioButtonId();
//                if(i==2131296601) {
//                    obj.insertprec(et1.getText().toString(),et2.getText());
//                }
