package com.devraj.firebasenewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devraj.firebasenewsapp.Modelclass.Newsinfo;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class SportsFragment extends Fragment {

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    Query databaseReference;
    FirebaseRecyclerAdapter<Newsinfo, ViewHolder> firebaseRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, null);

        recyclerView = view.findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("News").orderByChild("news_category").equalTo("Sports");
//        databaseReference.keepSynced(true);

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

                        Intent intent = new Intent(getActivity(), DetailActivity.class);

                        intent.putExtra("news_title", model.getNews_title());
                        intent.putExtra("news_description", model.getNews_description());
                        intent.putExtra("news_image", model.getNews_image());

                        startActivity(intent);
                    }
                });
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);


        return view;
    }
}
