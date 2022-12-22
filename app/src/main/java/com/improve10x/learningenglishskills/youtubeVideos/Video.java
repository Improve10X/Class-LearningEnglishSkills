package com.improve10x.learningenglishskills.youtubeVideos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Video implements Serializable {
    @SerializedName("_id")
    String id;
    String imageUrl;
    String title;
    String channelName;
    String numberOfViews;
    String logoImageUrl;
    String uploadedDate;
    String youTubeId;
}
