package ru.ivanl.android.rssreader.Presenters;

import android.content.Context;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ivanl.android.rssreader.Adapters.RSSAdapter;
import ru.ivanl.android.rssreader.DI.RSSReaderApplication;
import ru.ivanl.android.rssreader.RSSParsing.RSSFeed;
import ru.ivanl.android.rssreader.RSSParsing.RSSFeedItem;
import ru.ivanl.android.rssreader.RSSParsing.RSSService;
import ru.ivanl.android.rssreader.Views.INewsView;

/**
 * Created by Ivan on 23.05.2016.
 */
public class NewsPresenter implements INewsPresenter {

    @Inject
    RSSService rssService;
    @Inject
    Context context;
    private INewsView newsView;
    @Inject
    public NewsPresenter(INewsView newsView, Context context) {
       ((RSSReaderApplication) context.getApplicationContext()).getAppComponent().inject(this);
       this.newsView = newsView;
    }


    @Override
    public void callResponce() {

        Call<RSSFeed> call = rssService.getRSSData();
        call.enqueue(new Callback<RSSFeed>() {
            @Override
            public void onResponse(Call<RSSFeed> call, Response<RSSFeed> response) {
                RSSFeed rssFeed = response.body();

                List<RSSFeedItem> newsItem = rssFeed.getChannel().getFeedItems();
                RSSAdapter adapter = new RSSAdapter(newsItem, context.getApplicationContext());

                //recyclerView.setAdapter(adapter);
                newsView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<RSSFeed> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });
    }
}
