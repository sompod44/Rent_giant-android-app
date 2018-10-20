package com.sompod44soft.rentgiant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Send_Feedback extends AppCompatActivity {
    EditText editText1,editText2;
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__feedback);

        editText1 = findViewById(R.id.feedbackedittextid1);
        editText2 = findViewById(R.id.feedbackedittextid2);

        button1 = findViewById(R.id.feedbackbutton1);
        button2 = findViewById(R.id.feedbackbutton2);

        Send_Feedback.Handler handler = new Send_Feedback.Handler();

        button1.setOnClickListener(handler);

        button2.setOnClickListener(handler);
    }
    class Handler implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            try{
                String name = editText1.getText().toString();
                String openion = editText2.getText().toString();
                if(view.getId()==R.id.feedbackbutton1){
                    Intent intent = new Intent(Intent.ACTION_SEND);

                    intent.setType("text/email");

                    intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"shahrearislam3@gmail.com"});

                    intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from Country_Info App");

                    intent.putExtra(Intent.EXTRA_TEXT,"Name : "+name+"\n FeedBack : "+openion);

                    startActivity(intent.createChooser(intent," Feedback With "));

                }
                else if(view.getId()==R.id.feedbackbutton2){
                    editText1.setText("");
                    editText2.setText("");
                }
            }catch (Exception e){
                Toast.makeText(Send_Feedback.this, "Fill all Field", Toast.LENGTH_SHORT).show();
            }


        }
    }
}
