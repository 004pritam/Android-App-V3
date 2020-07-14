package com.example.internertconnection;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

public class ConnectInternetTask extends AsyncTask<String, Void, String> {
    Context ctx;
    public ConnectInternetTask(Context ct) {
        ctx = ct;
    }
    @Override
    protected String doInBackground(String... strings) {
        String s = strings[0];
        URL url = null;
        InputStream in;
        try {
            url = new URL(s);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.connect();

            //for reading only
            in = conn.getInputStream();
            BufferedReader buff = new BufferedReader(new InputStreamReader(in));

            StringBuilder sb = new StringBuilder();
            String line= new String("");

            while ((line = buff.readLine())!=null) {
                sb.append(line + " \n");
            }
            buff.close();
            in.close();
            return  sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        MainActivity.result.setText(s);
    }
}
