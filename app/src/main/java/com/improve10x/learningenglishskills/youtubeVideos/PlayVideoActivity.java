package com.improve10x.learningenglishskills.youtubeVideos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.improve10x.learningenglishskills.Constants;
import com.improve10x.learningenglishskills.R;
import com.squareup.picasso.Picasso;

public class PlayVideoActivity extends YouTubeBaseActivity {

    private Video video;
    private YouTubePlayerView youTubePlayerView;
    private ImageView videoLogoImageUrl;
    private TextView videoTitleText;
    private TextView videoChannelNameTxt;
    private TextView videoViewsTxt;
    private TextView videoUploadedDateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        Intent intent = getIntent();
        intent.hasExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS);
        video = (Video) intent.getSerializableExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS);
        setupViews();
        showData();
        setupYouTubePlayerView();
    }

    private void setupYouTubePlayerView() {
        youTubePlayerView.initialize(Constants.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(video.youtubeVideoId);
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(PlayVideoActivity.this, "Fail to load video", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void showData() {
        Picasso.get().load(video.logoImageUrl).into(videoLogoImageUrl);
        videoTitleText.setText(video.title);
        videoChannelNameTxt.setText(video.channelName);
        videoViewsTxt.setText(video.numberOfViews);
        videoUploadedDateTxt.setText(video.uploadedDate);
    }

    private void setupViews() {
        youTubePlayerView = findViewById(R.id.youtube_player_view);
        videoLogoImageUrl = findViewById(R.id.video_logo_image_url);
        videoTitleText = findViewById(R.id.video_title_txt);
        videoChannelNameTxt = findViewById(R.id.video_channel_name_txt);
        videoViewsTxt = findViewById(R.id.video_views_txt);
        videoUploadedDateTxt = findViewById(R.id.video_upload_date_txt);
    }
}