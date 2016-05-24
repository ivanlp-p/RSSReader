package ru.ivanl.android.rssreader;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ru.ivanl.android.rssreader.Presenters.NewsItemPresenter;
import ru.ivanl.android.rssreader.RSSParsing.RSSFeedItem;
import ru.ivanl.android.rssreader.Views.INewsItemView;

/**
 * Created by Ivan on 22.05.2016.
 */
public class DetailActivity extends AppCompatActivity implements INewsItemView {

    private static final String INTENT_GUID = "guid";

    private ImageView imageNews;
    private TextView description;
    private NewsItemPresenter newsItemPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item_activity);

        imageNews = (ImageView) findViewById(R.id.detail_imagenews);
        description = (TextView) findViewById(R.id.detail_item_description);

        newsItemPresenter = new NewsItemPresenter(this);

        newsItemPresenter.setData();

    }

    @Override
    public RSSFeedItem getData() {
        RSSFeedItem detailItem = getIntent().getParcelableExtra(INTENT_GUID);

        return detailItem;
    }

    @Override
    public void setImage() {
        try{
            Picasso.with(this).load(newsItemPresenter.returnItem().getEnclosure().getUrl()).into(imageNews);
        } catch (NullPointerException e) {
            Picasso.with(this).load(R.drawable.loga_lentaru).resize(420,280).centerInside().into(imageNews);
        }
    }

    @Override
    public void setDescription() {
        description.setText(newsItemPresenter.returnItem().getDescription());
    }
}
