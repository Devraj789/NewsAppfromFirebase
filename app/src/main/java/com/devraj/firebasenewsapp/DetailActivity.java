package com.devraj.firebasenewsapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView news_title, news_descripton;
    ImageView news_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        news_title = findViewById(R.id.news_title);
        news_descripton = findViewById(R.id.news_description);
        news_image = findViewById(R.id.news_image);

        String title = getIntent().getStringExtra("news_title");
        String description = getIntent().getStringExtra("news_description");
        String image = getIntent().getStringExtra("news_image");

        Picasso.get().load(image).fit().into(news_image);
        news_title.setText(title);
        news_descripton.setText(description);

    }
}
