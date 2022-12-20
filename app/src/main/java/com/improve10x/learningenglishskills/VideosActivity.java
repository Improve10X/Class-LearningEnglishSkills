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
        setupViews();
        setupData();
        setupAdapter();
        setupVideosRv();
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

    private void setupData() {
        videosItems = new ArrayList<>();
        VideosItem video = new VideosItem();
        video.imageUrl = "https://i.ytimg.com/an_webp/dzxpUiwDZS0/mqdefault_6s.webp?du=3000&sqp=CIyQh50G&rs=AOn4CLC8ccV8xyhVqagYCFYfLweYToCuPw";
        video.logoImageUrl = "https://yt3.ggpht.com/ytc/AMLnZu_lmrsZYsl7NvS4PbztGPON3C236wLivT6bICl7vw=s68-c-k-c0x00ffffff-no-rj";
        video.title = "Kung fu panda";
        video.channelName = "Pullaiah";
        video.numberOfViewers = "10M views";
        video.uploadedDate =  "10Months ago";
        videosItems.add(video);

    }

}