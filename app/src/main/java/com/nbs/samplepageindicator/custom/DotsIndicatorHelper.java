package com.nbs.samplepageindicator.custom;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

public class DotsIndicatorHelper {
    private DotsIndicator dotsIndicator;

    private LinearLayoutManager layoutManager;

    private Context context;

    public DotsIndicatorHelper(Context context, FrameLayout viewContainer, RecyclerView recyclerView, LinearLayoutManager layoutManager) {
        dotsIndicator = new DotsIndicator(viewContainer);
        dotsIndicator.init();
        recyclerView.addOnScrollListener(new ScrollListener());
        this.layoutManager = layoutManager;
        this.context = context;
    }

    public void updateData(int num) {
        dotsIndicator.setDots(num);
        dotsIndicator.initDots();
    }

    private class ScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            int pos = layoutManager.findFirstVisibleItemPosition();

            dotsIndicator.onScroll(pos, layoutManager.findViewByPosition(pos).getRight(), dpToPx(200));
        }
    }

    private int dpToPx(int dp) {
        return (int) (context.getResources().getDisplayMetrics().density * dp);
    }
}