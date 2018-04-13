package com.nbs.samplepageindicator;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewholder>{

    private ArrayList<String> list;

    private String image = "https://paulonfilm.files.wordpress.com/2016/04/avengers-age.jpg";

    public PeopleAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PeopleViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people, parent, false);
        return new PeopleViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewholder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PeopleViewholder extends RecyclerView.ViewHolder{

        private TextView tvPeople;

        private ImageView imgBanner;

        public PeopleViewholder(View itemView) {
            super(itemView);

            tvPeople = itemView.findViewById(R.id.tv_people);

            imgBanner = itemView.findViewById(R.id.iv_banner_promo);
        }

        public void bind(String s){
            tvPeople.setText(s);
            Picasso.get().load(image).into(imgBanner);
        }
    }
}
