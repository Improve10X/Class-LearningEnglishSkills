package com.improve10x.learningenglishskills.youtubeVideos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.improve10x.learningenglishskills.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddVideosActivity extends BaseAddEditVideosActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Video");
        handleAdd();
        handleAddBtn();

    }

    private void handleAdd() {
        binding.addBtn.setVisibility(View.VISIBLE);
    }

    private void handleAddBtn() {
        binding.addBtn.setOnClickListener(view -> {
            String imageUrl = binding.imageUrlTxt.getText().toString();
            String title = binding.titleTxt.getText().toString();
            String logoImg = binding.logoImgUrlTxt.getText().toString();
            String channelName = binding.imageUrlTxt.getText().toString();
            String views = binding.imageUrlTxt.getText().toString();
            String uploadDate = binding.imageUrlTxt.getText().toString();
            String youtubeVideoId = binding.imageUrlTxt.getText().toString();
            Video videosItem = createVideo(imageUrl, title, logoImg, channelName, views, uploadDate, youtubeVideoId);
            saveVideo(videosItem);
        });
    }

    private void saveVideo(Video videosItem) {
        Call<Video> call = videosService.createVideo(videosItem);
        call.enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Call<Video> call, Response<Video> response) {
                Toast.makeText(AddVideosActivity.this, "Successfully added video", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {
                Toast.makeText(AddVideosActivity.this, "Failed to add video", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
