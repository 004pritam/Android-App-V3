package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView r;
    String s1[], s2[];
    MyOwnAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = findViewById(R.id.myrecylcler);
        s1= getResources().getStringArray(R.array.pets);
        s2= getResources().getStringArray(R.array.descripription);

        ad = new MyOwnAdapter(this,s1,s2);
        r.setAdapter(ad);
        r.setLayoutManager(new LinearLayoutManager(this));

    }
}