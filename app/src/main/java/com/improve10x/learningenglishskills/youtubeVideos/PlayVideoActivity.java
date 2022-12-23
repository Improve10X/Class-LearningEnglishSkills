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
import com.improve10x.learningenglishskills.databinding.ActivityPlayVideoBinding;
import com.squareup.picasso.Picasso;

public class PlayVideoActivity extends YouTubeBaseActivity {

    private ActivityPlayVideoBinding binding;
    private Video video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        intent.hasExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS);
        video = (Video) intent.getSerializableExtra(Constants.KEY_LEARNING_ENGLISH_SKILLS);
        showData();
        setupYouTubePlayerView();
    }

    private void setupYouTubePlayerView() {
        binding.youtubePlayerView.initialize(Constants.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
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
        Picasso.get().load(video.logoImageUrl).into(binding.videoLogoImageUrl);
        binding.videoTitleTxt.setText(video.title);
        binding.videoChannelNameTxt.setText(video.channelName);
        binding.videoViewsTxt.setText(video.numberOfViews);
        binding.videoUploadDateTxt.setText(video.uploadedDate);
    }
}