package com.improve10x.learningenglishskills.api;

import com.improve10x.learningenglishskills.Constants;
import com.improve10x.learningenglishskills.youtubeVideos.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface VideosService {

    @GET(Constants.LEARNING_ENGLISH_END_POINT)
    Call<List<Video>> fetchVideos();

    @POST(Constants.LEARNING_ENGLISH_END_POINT)
    Call<Video> createVideo(@Body Video videosItem);

    @DELETE(Constants.LEARNING_ENGLISH_END_POINT + "/{id}")
    Call<Void> deleteVideo(@Path("id") String id);

    @PUT(Constants.LEARNING_ENGLISH_END_POINT + "/{id}")
    Call<Void> updateVideo(@Path("id")String id , @Body Video videosItem);
}
