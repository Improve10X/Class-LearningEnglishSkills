package com.improve10x.learningenglishskills.youtubeVideos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Video implements Serializable {
    @SerializedName("_id")
    public String id;
    public String imageUrl;
    public String title;
    public String channelName;
    public String numberOfViews;
    public String logoImageUrl;
    public String uploadedDate;
    public String youtubeVideoId;
}
