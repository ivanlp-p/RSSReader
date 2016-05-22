package ru.ivanl.android.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class MainActivity extends AppCompatActivity {

    @Inject
    RSSService rssService;

    private RecyclerView recyclerView;
    private List<RSSFeedItem> newsItem;
    private RSSFeed rssFeed;
    private RSSAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((RSSReaderApplication) getApplication()).getAppComponent().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.rss_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        Call<RSSFeed> call = rssService.getRSSData();
        call.enqueue(new Callback<RSSFeed>() {
            @Override
            public void onResponse(Call<RSSFeed> call, Response<RSSFeed> response) {
                rssFeed = response.body();

                Log.d("happy1", rssFeed.toString());

                newsItem = rssFeed.getChannel().getFeedItems();
                Log.d("happy2", "Bode size:" + newsItem.size());
                adapter = new RSSAdapter(newsItem, getApplicationContext());

                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<RSSFeed> call, Throwable t) {
                Log.d("happy3", t.getMessage());
            }
        });






    }

}


