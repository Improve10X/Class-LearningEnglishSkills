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

    private Button addBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Video");
        setupViews();
        handleAdd();
        handleAddBtn();

    }

    private void setupViews() {
        addBtn = findViewById(R.id.add_btn);
    }

    private void handleAdd() {
        addBtn.setVisibility(View.VISIBLE);
    }

    private void handleAddBtn() {
        addBtn.setOnClickListener(view -> {
            String imageUrl = imageUrlTxt.getText().toString();
            String title = titleTxt.getText().toString();
            String logoImg = logoImgUrlTxt.getText().toString();
            String channelName = channelLogoTxt.getText().toString();
            String views = numberOfViewsTxt.getText().toString();
            String uploadDate = uploadedDateTxt.getText().toString();
            String youtubeVideoId = youtubeVideoIdTxt.getText().toString();
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
