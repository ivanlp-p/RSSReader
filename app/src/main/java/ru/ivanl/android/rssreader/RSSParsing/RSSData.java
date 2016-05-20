package ru.ivanl.android.rssreader.RSSParsing;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ivanl.android.rssreader.DI.RSSReaderApplication;

/**
 * Created by User on 20.05.2016.
 */
public class RSSData extends IntentService {

    @Inject
    RSSService rssService;

    RSSFeed rssFeed;


    public RSSData() {
        super("RSSData");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        ((RSSReaderApplication) getApplication()).getAppComponent().inject(this);
    }

    @Nullable
    public RSSFeed requestRSSData() throws IOException {



        Call<RSSFeed> call = rssService.getRSSData();
        call.enqueue(new Callback<RSSFeed>() {
            @Override
            public void onResponse(Call<RSSFeed> call, Response<RSSFeed> response) {
                rssFeed = response.body();


               /* newsItem = rssFeed.getChannel().getFeedItems();

                Log.d("happy", "Bode size:" + newsItem.size());
*/

            }

            @Override
            public void onFailure(Call<RSSFeed> call, Throwable t) {
                Log.d("happy", "This is onFailure");
            }
        });

        return rssFeed;
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
