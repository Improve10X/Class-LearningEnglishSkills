package com.improve10x.learningenglishskills.youtubeVideos;

import android.os.Bundle;
import android.widget.EditText;

import com.improve10x.learningenglishskills.BaseActivity;
import com.improve10x.learningenglishskills.R;

public class BaseAddEditVideosActivity extends BaseActivity {

    protected EditText imageUrlTxt;
    protected EditText titleTxt;
    protected EditText channelLogoTxt;
    protected EditText logoImgUrlTxt;
    protected EditText numberOfViewsTxt;
    protected EditText uploadedDateTxt;
    protected EditText youtubeVideoIdTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_add_edit_videos);
        setupViews();
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

    private void setupViews() {
        imageUrlTxt = findViewById(R.id.image_url_txt);
        titleTxt = findViewById(R.id.title_txt);
        channelLogoTxt = findViewById(R.id.channel_name_txt);
        logoImgUrlTxt = findViewById(R.id.logo_img_url_txt);
        numberOfViewsTxt = findViewById(R.id.number_of_views_txt);
        uploadedDateTxt = findViewById(R.id.upload_date_txt);
        youtubeVideoIdTxt = findViewById(R.id.youtube_video_id_txt);
    }
}