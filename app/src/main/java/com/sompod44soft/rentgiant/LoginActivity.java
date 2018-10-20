package com.sompod44soft.rentgiant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
private Button button,button1;
private EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 = findViewById(R.id.UserNameID);
        editText2 = findViewById(R.id.PasswordID);
        button = findViewById(R.id.loginButtonID);
        button1 = findViewById(R.id.registerButtonID);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.loginButtonID){
            if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")){
                Toast.makeText(this, "\t\tPlz fill all the fields.\nusername&password is : admin", Toast.LENGTH_SHORT).show();
            }
            else{
                try {
                    String username = editText1.getText().toString();
                    String password = editText2.getText().toString();
                    if(username.equals("admin") && password.equals("admin")){
                        Toast.makeText(this, "Successfully login.", Toast.LENGTH_SHORT).show();
                        editText1.setText("");
                        editText2.setText("");
                        Intent intent = new Intent(this,RentGiant_Activity.class);
                        startActivity(intent);
                    }
                }catch (Exception e){
                    Toast.makeText(this, "First complete your registration.", Toast.LENGTH_SHORT).show();
                }
            }

        }
        else if(v.getId() == R.id.registerButtonID){
            Intent intent = new Intent(this,Register_From.class);
            startActivity(intent);
        }
    }
}
