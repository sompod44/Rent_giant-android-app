package com.sompod44soft.rentgiant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Itemshow_Activity extends AppCompatActivity {

    private ListView listView;
    private String[] PlaceName;

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
        setContentView(R.layout.activity_itemshow_);

        listView = findViewById(R.id.listviewid);

        Bundle bundle;
        bundle = getIntent().getExtras();
        try {
            if (bundle != null) {
                value = bundle.getInt("checkvalue");
            }
        } catch (Exception e) {
            Toast.makeText(this, "I see problem something.", Toast.LENGTH_SHORT).show();
        }

        if(value == 1){
            PlaceName = getResources().getStringArray(R.array.Place_Name);

            CustomAdaptor customAdaptor = new CustomAdaptor(this,PlaceName,vehicel); // This is Custom Adaptor
            listView.setAdapter(customAdaptor);
        }else if(value == 2){
            PlaceName = getResources().getStringArray(R.array.Place_Name);

            CustomAdaptor customAdaptor = new CustomAdaptor(this,PlaceName,house); // This is Custom Adaptor
            listView.setAdapter(customAdaptor);
        }else if(value == 3){
            PlaceName = getResources().getStringArray(R.array.Place_Name);

            CustomAdaptor customAdaptor = new CustomAdaptor(this,PlaceName,boyshostel); // This is Custom Adaptor
            listView.setAdapter(customAdaptor);
        }else if(value == 4){
            PlaceName = getResources().getStringArray(R.array.Place_Name);

            CustomAdaptor customAdaptor = new CustomAdaptor(this,PlaceName,girlshostel); // This is Custom Adaptor
            listView.setAdapter(customAdaptor);
        }



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { // int i here position of listview item
                String value1 = PlaceName[i];
                Toast.makeText(Itemshow_Activity.this, value1, Toast.LENGTH_SHORT).show();
                try{
                    Intent intent =  new Intent(Itemshow_Activity.this,ItemDetails_showing_Activity.class);
                    intent.putExtra("key_value",i);
                    if(value == 1){
                        intent.putExtra("checkvalue",1);
                    }
                    else if(value == 2){
                        intent.putExtra("checkvalue",2);
                    }
                    else if(value == 3){
                        intent.putExtra("checkvalue",3);
                    }
                    else if(value == 4){
                        intent.putExtra("checkvalue",4);
                    }
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(Itemshow_Activity.this, "This is problem", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
