package com.improve10x.learningenglishskills;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddVideosActivity extends BaseActivity{

    private Button addBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();

    }

    private void setupViews() {
        addBtn = findViewById(R.id.add_btn);
    }
}
