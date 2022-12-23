package com.improve10x.learningenglishskills.youtubeVideos;

import android.os.Bundle;
import android.widget.EditText;

import com.improve10x.learningenglishskills.BaseActivity;
import com.improve10x.learningenglishskills.R;
import com.improve10x.learningenglishskills.databinding.ActivityBaseAddEditVideosBinding;

public class BaseAddEditVideosActivity extends BaseActivity {

    protected ActivityBaseAddEditVideosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBaseAddEditVideosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    protected Video createVideo(String imageUrl, String title, String logoImageUrl, String channelName, String numberOfViews, String uploadedDate, String youtubeVideoId) {
        Video videosItem = new Video();
        videosItem.imageUrl = imageUrl;
        videosItem.title = title;
        videosItem.logoImageUrl = logoImageUrl;
        videosItem.channelName = channelName;
        videosItem.numberOfViews = numberOfViews;
        videosItem.uploadedDate = uploadedDate;
        videosItem.youtubeVideoId = youtubeVideoId;
        return videosItem;
    }
}