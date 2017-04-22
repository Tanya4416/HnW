package com.example.shujareshi.hnm;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class gym extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] gyms = getResources().getStringArray(R.array.nearby_gyms);

        this.setListAdapter(new ArrayAdapter<String>(this,R.layout.gym_item,R.id.t1, gyms));

    }
}
