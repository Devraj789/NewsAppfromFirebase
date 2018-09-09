package com.devraj.firebasenewsapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView news_title;
    ImageView news_image;

    public ViewHolder(View itemView) {
        super(itemView);

        news_title = itemView.findViewById(R.id.news_title);
        news_image = itemView.findViewById(R.id.news_image);
    }
}
