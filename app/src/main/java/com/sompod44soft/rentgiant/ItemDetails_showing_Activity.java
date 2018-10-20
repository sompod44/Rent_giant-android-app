package com.sompod44soft.rentgiant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetails_showing_Activity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    private int[] vehicel = {R.drawable.vehicel1,R.drawable.vehicel2,R.drawable.vehicel3,R.drawable.vehicel4,R.drawable.vehicel5,
            R.drawable.vehicel1,R.drawable.vehicel2,R.drawable.vehicel3,R.drawable.vehicel4,R.drawable.vehicel5,
            R.drawable.vehicel1,R.drawable.vehicel2
    };

    private int[] house = {R.drawable.house1,R.drawable.house2,R.drawable.house3,R.drawable.house4,R.drawable.house5,
            R.drawable.house1,R.drawable.house2,R.drawable.house3,R.drawable.house4,R.drawable.house5,
            R.drawable.house1,R.drawable.house2

    };
    private int[] boyshostel = {R.drawable.bh1,R.drawable.bh2,R.drawable.bh3,R.drawable.bh4,R.drawable.bh5,
            R.drawable.bh1,R.drawable.bh2,R.drawable.bh3,R.drawable.bh4,R.drawable.bh5,
            R.drawable.bh1,R.drawable.bh2
    };
    private int[] girlshostel = {R.drawable.gh1,R.drawable.gh2,R.drawable.gh3,R.drawable.gh4,R.drawable.gh5,
            R.drawable.gh1,R.drawable.gh2,R.drawable.gh3,R.drawable.gh4,R.drawable.gh5,
            R.drawable.gh1,R.drawable.gh2
    };

    private int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details_showing_);

        String detailsOfvehicel = getResources().getString(R.string.bikedetails);
        String detailsOfhouse = getResources().getString(R.string.house_details);
        String detailsOfboyhostel = getResources().getString(R.string.boyhostel_details);
        String detailsOfgirlhostel = getResources().getString(R.string.girlshostel_details);

        imageView = findViewById(R.id.PlacePictureID);
        textView = findViewById(R.id.TextView_forDetailsID);

        Bundle bundle;
        bundle = getIntent().getExtras();
        try {
            if (bundle != null) {
                int value1 = bundle.getInt("key_value");
                value = bundle.getInt("checkvalue");
                if(value ==1){
                    imageView.setImageResource(vehicel[value1]);
                    textView.setText(detailsOfvehicel);
                }else if(value == 2){
                    imageView.setImageResource(house[value1]);
                    textView.setText(detailsOfhouse);
                }else if(value == 3){
                    imageView.setImageResource(boyshostel[value1]);
                    textView.setText(detailsOfboyhostel);
                }else if(value == 4){
                    imageView.setImageResource(girlshostel[value1]);
                    textView.setText(detailsOfgirlhostel);
                }

            }
        } catch (Exception e) {
            Toast.makeText(this, "I see problem something.", Toast.LENGTH_SHORT).show();
        }
    }
}
