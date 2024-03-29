package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.ckuspis.jokeactivity.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

class AsyncJoke extends AsyncTask<Void, Void, String> {
    private MyApi myApiService = null;
    private JokeResponseListener<String> mListener;
    private Exception mException;
    private Context mContext;

    public AsyncJoke(Context context, JokeResponseListener<String> listener){
        mContext = context;
        mListener = listener;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                // end options for devappserver

                myApiService = builder.build();
            }



            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            mException = e;
            return null;
        }
    }


    @Override
    protected void onPostExecute(String result) {
        if(mListener != null) {
            if(mException == null){
                if(result != null)
                    mListener.onSuccess(result);
                else{
                    Exception ex = new NullPointerException();
                    mListener.onFailure(ex);
                }
            }
            else{
                mListener.onFailure(mException);
            }

        }

    }
}
