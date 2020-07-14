package com.example.internertconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ConnectInternetTask ct;
    DownloadImageTask downloadImageTask;
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;
    public static TextView result;
    public static ImageView resultImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        resultImage = findViewById(R.id.resultImage);

        connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
    }

    public void connectInternet(View view) {
        ct= new ConnectInternetTask(this);
        ct.execute("https://reqres.in/api/users?page=2");
    }
    public void downloadImage(View view) {
        if(networkInfo!= null && networkInfo.isConnected()) {
            downloadImageTask = new DownloadImageTask();
            downloadImageTask.execute("https://www.backgroundscool.com/wp-content/uploads/2020/01/bd754bc61508c8b97e3b2557ce06acd5.jpg");
        }else{
        Toast.makeText(this,"connection not available",Toast.LENGTH_SHORT).show();
        }
    }
}