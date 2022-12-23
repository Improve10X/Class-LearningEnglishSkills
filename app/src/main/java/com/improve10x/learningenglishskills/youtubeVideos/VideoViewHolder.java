package com.improve10x.learningenglishskills.youtubeVideos;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.learningenglishskills.R;
import com.improve10x.learningenglishskills.databinding.VideosItemBinding;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    VideosItemBinding binding;

    public VideoViewHolder(VideosItemBinding videosItemBinding) {
        super(videosItemBinding.getRoot());
        binding = videosItemBinding;
    }
}
