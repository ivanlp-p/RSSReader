package ru.ivanl.android.rssreader;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ru.ivanl.android.rssreader.RSSParsing.RSSFeedItem;

/**
 * Created by Ivan on 22.05.2016.
 */
public class DetailActivity extends AppCompatActivity {

    private static final String INTENT_GUID = "guid";
    private ImageView imageNews;
    private TextView description;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item_activity);

        imageNews = (ImageView) findViewById(R.id.detail_imagenews);
        description = (TextView) findViewById(R.id.detail_item_description);

        RSSFeedItem detailItem = getIntent().getParcelableExtra(INTENT_GUID);

        try{
            Picasso.with(this).load(detailItem.getEnclosure().getUrl()).into(imageNews);
        } catch (NullPointerException e) {
            Picasso.with(this).load(R.drawable.loga_lentaru).resize(420,280).centerInside().into(imageNews);
        }

        description.setText(detailItem.getDescription());


    }

    public static Intent prepareIntent (Context context, RSSFeedItem detailItem) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(INTENT_GUID, detailItem);

        return intent;
    }
}
