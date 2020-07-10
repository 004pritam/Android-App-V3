package com.example.async_task_app;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class MyProgressTask extends AsyncTask<String, Integer, String> {
    Context ctx;
    ProgressDialog pd;

    MyProgressTask(Context ct){
        this.ctx= ct;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd= new ProgressDialog(ctx);
        pd.setTitle("Downloading..");
        pd.setMessage("Please wait !");
        pd.setMax(10);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                cancel(true);
            }
        });
        pd.show();
    }

    @Override
    protected String doInBackground(String... args) {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(2000);
                Log.i("thread", "doInBackground: Excecute "+i);
                publishProgress(i);
            }
            return "successful";
        }
        catch (Exception e){
            Log.i("Exception", "doInBackground: Exception "+e);
            return "failure";
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int myvalue = values[0];
        pd.setProgress(myvalue);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(ctx,s,Toast.LENGTH_LONG).show();
        pd.dismiss();
    }
}
