package com.improve10x.learningenglishskills;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlayVideoActivity extends BaseActivity {

    private Video video;
    private ImageView videoImageUrl;
    private ImageView videoLogoImageUrl;
    private TextView videoTitleText;
    private TextView videoChannelNameTxt;
    private TextView videoViewsTxt;
    private TextView videoUploadedDateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        getSupportActionBar().setTitle("Play Video");
        Intent intent = getIntent();
        intent.hasExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS);
        video = (Video) intent.getSerializableExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS);
        setupViews();
        showData();
    }

    private void showData() {
        Picasso.get().load(video.imageUrl).into(videoImageUrl);
        Picasso.get().load(video.logoImageUrl).into(videoLogoImageUrl);
        videoTitleText.setText(video.title);
        videoChannelNameTxt.setText(video.channelName);
        videoViewsTxt.setText(video.numberOfViews);
        videoUploadedDateTxt.setText(video.uploadedDate);
    }

    private void setupViews() {
        videoImageUrl = findViewById(R.id.video_image_url);
        videoLogoImageUrl = findViewById(R.id.video_logo_image_url);
        videoTitleText = findViewById(R.id.video_title_txt);
        videoChannelNameTxt = findViewById(R.id.video_channel_name_txt);
        videoViewsTxt = findViewById(R.id.video_views_txt);
        videoUploadedDateTxt = findViewById(R.id.video_upload_date_txt);
    }
}