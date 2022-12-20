package com.improve10x.learningenglishskills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class VideosActivity extends AppCompatActivity {
    private ArrayList<VideosItem> videosItems;
    private RecyclerView videosRv;
    private VideosAdapter videosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        getSupportActionBar().setTitle("YouTube");
        setupData();
        setupViews();
        setupVideosRv();
        setupAdapter();
    }

    private void setupAdapter() {
        videosAdapter = new VideosAdapter();
        videosRv.setAdapter(videosAdapter);
    }

    private void setupVideosRv() {
        videosRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupViews() {
        videosRv = findViewById(R.id.videos_rv);
    }

    private void setupData() {
        videosItems = new ArrayList<>();
    }

}