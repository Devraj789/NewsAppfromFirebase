package com.devraj.firebasenewsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.devraj.firebasenewsapp.Modelclass.Newsinfo;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<Newsinfo, ViewHolder> firebaseRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("News");
        databaseReference.keepSynced(true);

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Newsinfo, ViewHolder>
                (Newsinfo.class,
                        R.layout.list_news,
                        ViewHolder.class,
                        databaseReference) {

            @Override
            protected void populateViewHolder(ViewHolder viewHolder, final Newsinfo model, int position) {

                viewHolder.news_title.setText(model.getNews_title());

                Picasso.get().load(model.getNews_image()).into(viewHolder.news_image);

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                        intent.putExtra("news_title", model.getNews_title());
                        intent.putExtra("news_description", model.getNews_description());
                        intent.putExtra("news_image", model.getNews_image());

                        startActivity(intent);
                    }
                });
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
