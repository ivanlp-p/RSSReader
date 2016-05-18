package ru.ivanl.android.rssreader;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.ivanl.android.rssreader.Adapters.RSSAdapter;
import ru.ivanl.android.rssreader.DI.RSSReaderApplication;
import ru.ivanl.android.rssreader.RSSParsing.RSSFeed;
import ru.ivanl.android.rssreader.RSSParsing.RSSFeedItem;
import ru.ivanl.android.rssreader.RSSParsing.RSSService;

public class MainActivity extends AppCompatActivity {

    @Inject
    RSSService rssService;

    private RecyclerView recyclerView;
    private List<RSSFeedItem> newsItem = new ArrayList<>();
    private RSSAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ((RSSReaderApplication) getApplication()).getAppComponent().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.rss_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        try {
            newsItem = requestRSSData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        adapter = new RSSAdapter(newsItem);

        recyclerView.setAdapter(adapter);


    }

    @Nullable
    private List<RSSFeedItem> requestRSSData() throws IOException {
        return rssService.getRSSData().execute().body();
    }
}
