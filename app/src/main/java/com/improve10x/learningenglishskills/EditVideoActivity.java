package com.improve10x.learningenglishskills;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditVideoActivity extends BaseAddEditVideosActivity{
    private Video video;
    Button editBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
        Intent intent = getIntent();
        getSupportActionBar().setTitle("Edit Video");
        video = (Video)  intent.getSerializableExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS);
        showData();
        handleEdit();
        handleEditBtn();
    }

    private void handleEdit() {
        editBtn.setOnClickListener(view -> {
            String imageUrl = imageUrlTxt.getText().toString();
            String title = titleTxt.getText().toString();
            String logoImg = logoImgUrlTxt.getText().toString();
            String channelName = channelLogoTxt.getText().toString();
            String views = numberOfViewsTxt.getText().toString();
            String uploadDate = uploadedDateTxt.getText().toString();
            Video updatedVideo = createVideo(imageUrl, title,logoImg, channelName, views, uploadDate);
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
        editBtn.setVisibility(View.VISIBLE);
    }

    private void showData() {
        imageUrlTxt.setText(video.imageUrl);
        titleTxt.setText(video.title);
        channelLogoTxt.setText(video.channelName);
        logoImgUrlTxt.setText(video.logoImageUrl);
        numberOfViewsTxt.setText(video.numberOfViews);
        uploadedDateTxt.setText(video.uploadedDate);

    }

    private void setupViews() {
        editBtn = findViewById(R.id.edit_btn);
    }
}
