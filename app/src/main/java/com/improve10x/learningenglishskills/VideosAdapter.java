package com.improve10x.learningenglishskills;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videos_item, parent, false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(view);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videoList.get(position);
        Picasso.get().load(video.imageUrl).into(holder.videoImg);
        Picasso.get().load(video.logoImageUrl).into(holder.logoImg);
        holder.titleTxt.setText(video.title);
        holder.channelNameTxt.setText(video.channelName);
        holder.viewsTxt.setText(video.numberOfViews);
        holder.uploadDateTxt.setText(video.uploadedDate);
        holder.deleteImgBtn.setOnClickListener(view -> {
            onItemActionListener.onItemDelete(video);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionListener.onItemClicked(video);
        });
        holder.editImgBtn.setOnClickListener(view -> {
            onItemActionListener.onItemEdit(video);
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
