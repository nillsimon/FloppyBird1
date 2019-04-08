package com.example.mvp_mosby.model;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

public class InfoModelImpl implements InfoModel {

    @SuppressLint("StaticFieldLeak")
    @Override
    public void retrieveInfo(final MyAction<String> onDownland) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Some string";
            }

            @Override
            protected void onPostExecute(String s) {
                onDownland.call(s);
            }
        }.execute();
    }
}