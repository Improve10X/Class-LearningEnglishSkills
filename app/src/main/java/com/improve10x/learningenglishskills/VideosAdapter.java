package com.improve10x.learningenglishskills;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    public List<VideosItem> videosItems;

    void setData(List<VideosItem> videos) {
        videosItems = videos;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videos_item, parent, false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(view);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        VideosItem videosItem = videosItems.get(position);
        Picasso.get().load(videosItem.imageUrl).into(holder.videoImg);
        Picasso.get().load(videosItem.logoImageUrl).into(holder.logoImg);
        holder.titleTxt.setText(videosItem.title);
        holder.channelNameTxt.setText(videosItem.channelName);
        holder.viewsTxt.setText(videosItem.numberOfViews);
        holder.uploadDateTxt.setText(videosItem.uploadedDate);
    }

    @Override
    public int getItemCount() {
        return videosItems.size();
    }
}
