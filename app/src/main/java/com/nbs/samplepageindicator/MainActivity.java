package com.nbs.samplepageindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.nbs.samplepageindicator.custom.DotsIndicatorHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPeople;

    private FrameLayout frameDotIndicator;

    private PeopleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPeople = findViewById(R.id.rv_people);
        frameDotIndicator = findViewById(R.id.frame_dot_indicator);

        rvPeople.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvPeople.setLayoutManager(linearLayoutManager);

        ArrayList<String> listOfPeople = new ArrayList<>();
        listOfPeople.add("Sidiq");
        listOfPeople.add("Keenan");
        listOfPeople.add("Ifah");
        listOfPeople.add("Ayumi");

        adapter = new PeopleAdapter(listOfPeople);
        rvPeople.setAdapter(adapter);

        DotsIndicatorHelper dotsIndicatorHelper = new
                DotsIndicatorHelper(this, frameDotIndicator, rvPeople, linearLayoutManager);
        dotsIndicatorHelper.updateData(listOfPeople.size());
    }
}
