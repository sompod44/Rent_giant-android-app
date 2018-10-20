package com.sompod44soft.rentgiant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sompod_Programmer on 11/22/2017.
 */
// This class java for custom adaptor

public class CustomAdaptor extends BaseAdapter {

    String[] countryname;
    int[] pictures;
    Context context;
    private LayoutInflater inflater;

    CustomAdaptor(Context context, String[] countryname, int[] pictures) {
        this.context = context;
        this.countryname = countryname;
        this.pictures = pictures;
    }

    @Override
    public int getCount() {
        return countryname.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { //View view mean Convert View int i mean position
        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.sample_layout, viewGroup, false);
        }
        ImageView imageView = view.findViewById(R.id.imageviewid);
        TextView textView = view.findViewById(R.id.textviewid1);
        imageView.setImageResource(pictures[i]);
        textView.setText(countryname[i]);
        return view;
    }
}
