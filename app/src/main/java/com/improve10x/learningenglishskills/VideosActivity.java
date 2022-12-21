package com.improve10x.learningenglishskills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.learningenglishskills.api.VideosService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosActivity extends BaseActivity {
    private ArrayList<VideosItem> videosItems =  new  ArrayList();
    private RecyclerView videosRv;
    private VideosAdapter videosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        getSupportActionBar().setTitle("YouTube");
        setupViews();
        //setupData();
        setupAdapter();
        setupVideosRv();
        fetchVideos();
    }

    private void fetchVideos(){
        Call<List<VideosItem>> call = videosService.fetchVideos();
        call.enqueue(new Callback<List<VideosItem>>() {
            @Override
            public void onResponse(Call<List<VideosItem>> call, Response<List<VideosItem>> response) {
                List<VideosItem>videosItems = response.body();
                videosAdapter.setData(videosItems);
            }

            @Override
            public void onFailure(Call<List<VideosItem>> call, Throwable t) {
                Toast.makeText(VideosActivity.this, "Failed to fetch Videos", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setupAdapter() {
        videosAdapter = new VideosAdapter();
        videosAdapter.setData(videosItems);
        videosRv.setAdapter(videosAdapter);

    }

    private void setupVideosRv() {
        videosRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupViews() {
        videosRv = findViewById(R.id.videos_rv);
    }

   // private void setupData() {
       // videosItems = new ArrayList<>();

   // }
}