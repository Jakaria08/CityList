package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        Intent intent=getIntent();
        String city=intent.getStringExtra("nameOfCity");
        TextView textView=findViewById(R.id.textView);
        textView.setText(city);
        Button back=findViewById(R.id.back);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            Intent intent1=new Intent(Activity1.this,MainActivity.class);
//            startActivity(intent1);
            finish();
        }
    });}
}