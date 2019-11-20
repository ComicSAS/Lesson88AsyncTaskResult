package com.example.lesson88asynctaskresult;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MyTask extends AsyncTask<Void, Void, Integer> {

    final String LOG_TAG = "myLogs";

    private TextView mTV;

    public MyTask(TextView mTV) {
        this.mTV = mTV;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mTV.setText("Begin");
        Log.d(LOG_TAG, "Begin");
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100500;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        mTV.setText("End. Result = " + integer);
        Log.d(LOG_TAG, "End. Result = " + integer);
    }
}
