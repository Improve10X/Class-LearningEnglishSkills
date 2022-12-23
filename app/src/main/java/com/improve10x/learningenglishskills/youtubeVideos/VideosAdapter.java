package com.improve10x.learningenglishskills.youtubeVideos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.learningenglishskills.OnItemActionListener;
import com.improve10x.learningenglishskills.R;
import com.improve10x.learningenglishskills.databinding.VideosItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    public List<Video> videoList;
    public OnItemActionListener onItemActionListener;

    void setOnItemActionListener(OnItemActionListener listener) {
        onItemActionListener = listener;
    }

    void setData(List<Video> videos) {
        this.videoList = videos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VideosItemBinding binding = VideosItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(binding);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videoList.get(position);
        Picasso.get().load(video.imageUrl).into(holder.binding.videoImg);
        Picasso.get().load(video.logoImageUrl).into(holder.binding.logoImg);
        holder.binding.titleTxt.setText(video.title);
        holder.binding.channelNameTxt.setText(video.channelName);
        holder.binding.viewsTxt.setText(video.numberOfViews);
        holder.binding.uploadDateTxt.setText(video.uploadedDate);
        holder.binding.deleteImgBtn.setOnClickListener(view -> {
            onItemActionListener.onItemDelete(video);
        });
        holder.binding.getRoot().setOnClickListener(view -> {
            onItemActionListener.onItemClicked(video);
        });
        holder.binding.editImgBtn.setOnClickListener(view -> {
            onItemActionListener.onItemEdit(video);
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
