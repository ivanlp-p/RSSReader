package ru.ivanl.android.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import ru.ivanl.android.rssreader.Adapters.RSSAdapter;
import ru.ivanl.android.rssreader.DI.RSSReaderApplication;
import ru.ivanl.android.rssreader.Presenters.NewsPresenter;
import ru.ivanl.android.rssreader.Views.INewsView;

public class MainActivity extends AppCompatActivity implements INewsView{

    private RecyclerView recyclerView;
    private NewsPresenter newsPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((RSSReaderApplication) getApplication()).getAppComponent().inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.rss_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        newsPresenter = new NewsPresenter(this, getApplicationContext());
        newsPresenter.callResponce();

    }

    @Override
    public void setAdapter(RSSAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

}


