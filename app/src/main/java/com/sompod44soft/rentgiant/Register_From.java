package com.sompod44soft.rentgiant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Register_From extends AppCompatActivity {

    private CheckBox checkBox;
    public static SharedPreferences sharedPreferences,sharedPreferences1;
    private EditText editText1,editText2,editText3,editText4,editText5,editText6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__from);


        checkBox = findViewById(R.id.checkboxID1);
        editText1 = findViewById(R.id.edittextID1);
        editText2 = findViewById(R.id.edittextID2);
        editText3 = findViewById(R.id.edittextID3);
        editText4 = findViewById(R.id.edittextID4);
        editText5 = findViewById(R.id.edittextID5);
        editText6 = findViewById(R.id.edittextID6);
    }


    public void Butoonandcheckbox(View view){
        if(view.getId() == R.id.buttonID1){

            if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("") || editText3.getText().toString().equals("") || editText4.getText().toString().equals("") || editText5.getText().toString().equals("") || editText6.getText().toString().equals("")){
                Toast.makeText(this, "Plz Input data into all fields.", Toast.LENGTH_SHORT).show();
            }
            else{
                if(!editText3.getText().toString().equals(editText4.getText().toString())){
                    Toast.makeText(this, "Opps!!!Your password not matching.", Toast.LENGTH_SHORT).show();
                }else{
                    if(checkBox.isChecked()){
                        sharedPreferences = getSharedPreferences("username", Context.MODE_PRIVATE);
                        sharedPreferences1 = getSharedPreferences("password", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        SharedPreferences.Editor editor1 = sharedPreferences1.edit();

                        editor.putString("UN",editText2.getText().toString());
                        editor.commit();

                        editor1.putString("pass",editText4.getText().toString());
                        editor1.commit();


                        Toast.makeText(this, "Congratulation!!!", Toast.LENGTH_SHORT).show();

                        editText1.setText("");
                        editText2.setText("");
                        editText3.setText("");
                        editText4.setText("");
                        editText5.setText("");
                        editText6.setText("");

                        checkBox.setChecked(false);

                        Toast.makeText(this, "Successful_registration", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Select team & condition!", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        }

    }
}
