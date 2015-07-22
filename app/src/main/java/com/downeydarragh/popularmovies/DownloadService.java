package com.downeydarragh.popularmovies;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Darragh on 22/07/2015.
 */
public class DownloadService extends IntentService{

    public DownloadService(){
        super(DownloadService.class.getName());
    }
    /**
     * This method is invoked on the worker thread with a request to process.
     * Only one Intent is processed at a time, but the processing happens on a
     * worker thread that runs independently from other application logic.
     * So, if this code takes a long time, it will hold up other requests to
     * the same IntentService, but it will not hold up anything else.
     * When all requests have been handled, the IntentService stops itself,
     * so you should not call {@link #stopSelf}.
     *
     * @param intent The value passed to {@link
     *               Context#startService(Intent)}.
     */
    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
