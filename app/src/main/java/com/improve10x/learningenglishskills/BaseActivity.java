package com.improve10x.learningenglishskills;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.improve10x.learningenglishskills.api.VideosApi;
import com.improve10x.learningenglishskills.api.VideosService;

public class BaseActivity extends AppCompatActivity {
    protected VideosService videosService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setApiService();
    }

    private void setApiService() {
        VideosApi videosApi = new VideosApi();
        videosService = videosApi.createVideosService();
    }
}
