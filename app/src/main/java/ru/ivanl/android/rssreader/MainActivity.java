package ru.ivanl.android.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import ru.ivanl.android.rssreader.DI.RSSReaderApplication;
import ru.ivanl.android.rssreader.RSSParsing.RSSService;

public class MainActivity extends AppCompatActivity {

    @Inject
    RSSService rssService;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((RSSReaderApplication) getApplication()).getAppComponent().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.rss_recyclerview);

        rssService.getRSSData()


    }
}
