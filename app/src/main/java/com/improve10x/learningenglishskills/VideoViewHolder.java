package com.improve10x.learningenglishskills;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    ImageView videoImg;
    ImageButton deleteImgBtn;
    ImageButton logoImgBtn;
    EditText titleTxt;
    TextView channelNameTxt;
    TextView viewsTxt;
    TextView uploadDateTxt;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        videoImg = itemView.findViewById(R.id.video_img);
        deleteImgBtn = itemView.findViewById(R.id.delete_img_btn);
        logoImgBtn = itemView.findViewById(R.id.logo_img_btn);
        titleTxt = itemView.findViewById(R.id.title_txt);
        channelNameTxt = itemView.findViewById(R.id.channel_name_txt);
        viewsTxt = itemView.findViewById(R.id.views_txt);
        uploadDateTxt = itemView.findViewById(R.id.upload_date_txt);
    }
}
