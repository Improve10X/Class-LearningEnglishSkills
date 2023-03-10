package com.improve10x.learningenglishskills.youtubeVideos;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.learningenglishskills.BaseActivity;
import com.improve10x.learningenglishskills.Constants;
import com.improve10x.learningenglishskills.OnItemActionListener;
import com.improve10x.learningenglishskills.databinding.ActivityVideosBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosActivity extends BaseActivity {

    private ArrayList<Video> videoItems = new ArrayList();
    private ActivityVideosBinding binding;
    private VideosAdapter videosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("YouTube");
        setupAdapter();
        setupVideosRv();
        handleAddBtn();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchVideos();
    }

    private void fetchVideos() {
        Call<List<Video>> call = videosService.fetchVideos();
        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                List<Video> videosItems = response.body();
                videosAdapter.setData(videosItems);
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Toast.makeText(VideosActivity.this, "Failed to fetch Videos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleAddBtn() {
        binding.addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddVideoActivity.class);
            startActivity(intent);
        });
    }

    private void setupAdapter() {
        videosAdapter = new VideosAdapter();
        videosAdapter.setData(videoItems);
        videosAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onItemClicked(Video video) {
                Toast.makeText(VideosActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(VideosActivity.this, PlayVideoActivity.class);
                intent.putExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS, video);
                startActivity(intent);
            }

            @Override
            public void onItemDelete(Video video) {
                onDelete(video);
                Toast.makeText(VideosActivity.this, "Successfully deleted video", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemEdit(Video video) {
                Toast.makeText(VideosActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(VideosActivity.this, EditVideoActivity.class);
                intent.putExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS, video);
                startActivity(intent);
            }
        });
        binding.videosRv.setAdapter(videosAdapter);
    }

    private void setupVideosRv() {
        binding.videosRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void onDelete(Video video) {
        Call<Void> call = videosService.deleteVideo(video.id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(VideosActivity.this, "Successfully deleted the video", Toast.LENGTH_SHORT).show();
                fetchVideos();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(VideosActivity.this, "Failed to delete video", Toast.LENGTH_SHORT).show();
            }
        });
    }
}