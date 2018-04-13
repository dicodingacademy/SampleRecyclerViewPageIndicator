package com.nbs.samplepageindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPeople;

    private FrameLayout frameDotIndicator;

    private PeopleAdapter adapter;

    private com.nbs.samplepageindicator.custom.DotsIndicator dotsIndicator;

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

        initDots(rvPeople, frameDotIndicator, linearLayoutManager, listOfPeople.size());
    }

    void initDots(RecyclerView rv,
                  FrameLayout layout, //container for dots
                  LinearLayoutManager layoutManager,
                  int itemsNum) {

        rv.addOnScrollListener(new ScrollListener(layoutManager));

        dotsIndicator = new com.nbs.samplepageindicator.custom.DotsIndicator(layout);
        dotsIndicator.init(); //simple add linearLayout to layout

        dotsIndicator.setDots(itemsNum); //generate dots in linearlayout
        dotsIndicator.initDots(); //reset selected dot
    }

    private class ScrollListener extends RecyclerView.OnScrollListener {

        private LinearLayoutManager layoutManager;

        ScrollListener(LinearLayoutManager layoutManager) {
            this.layoutManager = layoutManager;
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            int pos = layoutManager.findFirstVisibleItemPosition();

            dotsIndicator.onScroll(pos, layoutManager.findViewByPosition(pos), dpToPx(200));
        }
    }

    private int dpToPx(int dp) {
        return (int) (getResources().getDisplayMetrics().density * dp);
    }
}
