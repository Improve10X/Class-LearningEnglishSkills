package com.improve10x.learningenglishskills.youtubeVideos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.improve10x.learningenglishskills.Constants;
import com.improve10x.learningenglishskills.R;
import com.improve10x.learningenglishskills.databinding.ActivityBaseAddEditVideosBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditVideoActivity extends BaseAddEditVideosActivity {

    private Video video;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent.hasExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS)) {
            getSupportActionBar().setTitle("Edit Video");
            video = (Video)  intent.getSerializableExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS);
            showData();
            handleEdit();
            handleEditBtn();
        }
    }

    private void handleEdit() {
        binding.editBtn.setOnClickListener(view -> {
            String imageUrl = binding.imageUrlTxt.getText().toString();
            String title = binding.titleTxt.getText().toString();
            String logoImg = binding.logoImgUrlTxt.getText().toString();
            String channelName = binding.channelNameTxt.getText().toString();
            String views = binding.numberOfViewsTxt.getText().toString();
            String uploadDate = binding.uploadDateTxt.getText().toString();
            String youtubeVideoId = binding.youtubeVideoIdTxt.getText().toString();
            Video updatedVideo = createVideo(imageUrl, title,logoImg, channelName, views, uploadDate, youtubeVideoId);
            updateVideo(video.id, updatedVideo);
        });
    }

    private void updateVideo(String id, Video updatedVideo) {
        Call<Void> call = videosService.updateVideo(id,updatedVideo);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(EditVideoActivity.this, "Successfully updated video", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(EditVideoActivity.this, "Failed to update video", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleEditBtn() {
        binding.editBtn.setVisibility(View.VISIBLE);
    }

    private void showData() {
        binding.imageUrlTxt.setText(video.imageUrl);
        binding.titleTxt.setText(video.title);
        binding.channelNameTxt.setText(video.channelName);
        binding.logoImgUrlTxt.setText(video.logoImageUrl);
        binding.numberOfViewsTxt.setText(video.numberOfViews);
        binding.uploadDateTxt.setText(video.uploadedDate);
        binding.youtubeVideoIdTxt.setText(video.youtubeVideoId);
    }
}
