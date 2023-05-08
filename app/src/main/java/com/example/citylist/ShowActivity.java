package com.example.citylist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.citylist.databinding.ActivityShowBinding;

public class ShowActivity extends AppCompatActivity {

    private ActivityShowBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String city = getIntent().getStringExtra("city");
        binding.tvCityName.setText(city);

        binding.buttonBack.setOnClickListener(view-> finish());
    }

}
