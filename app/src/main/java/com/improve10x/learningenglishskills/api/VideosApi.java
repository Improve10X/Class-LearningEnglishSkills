package com.improve10x.learningenglishskills.api;

import com.improve10x.learningenglishskills.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideosApi {

    public VideosService createVideosService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VideosService videosService = retrofit.create(VideosService.class);
        return videosService;
    }
}
