package com.improve10x.learningenglishskills;

import com.improve10x.learningenglishskills.youtubeVideos.Video;

public interface OnItemActionListener {

    void onItemClicked(Video video);

    void onItemDelete(Video video);

    void onItemEdit(Video video);
}
