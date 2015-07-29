package com.downeydarragh.popularmovies;

import android.app.IntentService;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Darragh on 22/07/2015.
 */
public class DownloadService extends AsyncTask<Void, Void, Void>{
    private HttpURLConnection urlConnection = null;
    private BufferedReader reader = null;
    private ProgressDialog progressDialog;

    private String movieJsonStr = null;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(getApplicationContext());
    }


    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected void doInBackground(void... params) {
        try{
            URL url = new URL("");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();

            if(inputStream == null) return;

            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = reader.readLine()) != null){
                buffer.append(line + "\n");
            }

            if(buffer.length() == 0) return;

            movieJsonStr = buffer.toString();
        }catch (IOException e){
            Log.e("", "Error", e);
            return;
        }finally {
            if(urlConnection != null){
                urlConnection.disconnect();
            }
            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    Log.e("", "Error closing stream", e);
                }
            }
            Toast.makeText(this, "Successful download", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
