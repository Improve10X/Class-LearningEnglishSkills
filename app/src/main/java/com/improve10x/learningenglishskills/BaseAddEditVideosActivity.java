package com.improve10x.learningenglishskills;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseAddEditVideosActivity extends BaseActivity {

    protected Video videosItem;
    protected EditText imageUrlTxt;
    protected EditText titleTxt;
    protected EditText channelLogoTxt;
    protected EditText logoImgUrlTxt;
    protected EditText numberOfViewsTxt;
    protected EditText uploadedDateTxt;
    protected Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_add_edit_videos);
        setupViews();
        handleAddBtn();
    }

    private void handleAddBtn() {
        addBtn.setOnClickListener(view -> {
            String imageUrl = imageUrlTxt.getText().toString();
            String title = titleTxt.getText().toString();
            String logoImg = logoImgUrlTxt.getText().toString();
            String channelName = channelLogoTxt.getText().toString();
            String views = numberOfViewsTxt.getText().toString();
            String uploadDate = uploadedDateTxt.getText().toString();
            Video videosItem = createVideo(imageUrl, title,logoImg, channelName, views, uploadDate);
            saveVideo(videosItem);
        });
    }

    private void saveVideo(Video videosItem) {
        Call<Video> call = videosService.createVideo(videosItem);
        call.enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Call<Video> call, Response<Video> response) {
                Toast.makeText(BaseAddEditVideosActivity.this, "Successfully added video", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {
                Toast.makeText(BaseAddEditVideosActivity.this, "Failed to add video", Toast.LENGTH_SHORT).show();
            }
        });
    }


    protected Video createVideo(String imageUrl, String title, String logoImageUrl, String channelName, String numberOfViews, String uploadedDate) {
        Video videosItem = new Video();
        videosItem.imageUrl = imageUrl;
        videosItem.title = title;
        videosItem.logoImageUrl = logoImageUrl;
        videosItem.channelName = channelName;
        videosItem.numberOfViews = numberOfViews;
        videosItem.uploadedDate = uploadedDate;
        return videosItem;
    }

    private void setupViews() {
        imageUrlTxt = findViewById(R.id.image_url_txt);
        titleTxt = findViewById(R.id.title_txt);
        channelLogoTxt = findViewById(R.id.channel_name_txt);
        logoImgUrlTxt = findViewById(R.id.logo_img_url_txt);
        numberOfViewsTxt = findViewById(R.id.number_of_views_txt);
        uploadedDateTxt = findViewById(R.id.upload_date_txt);
        addBtn = findViewById(R.id.add_btn);
    }
}