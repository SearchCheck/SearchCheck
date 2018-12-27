package com.gxl.searchcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.search.baselibrary.widget.WaterView;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private WaterView mWaterView;
    private List<WaterView.Water> mWaters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mWaterView = findViewById(R.id.wv_water);
        for (int i = 0; i <4; i++) {
            mWaters.add(new WaterView.Water(i, "item" + i));
        }
        mWaterView.setWaters(mWaters);
    }

    public void onRest(View view) {
        mWaterView.setWaters(mWaters);
    }
}
