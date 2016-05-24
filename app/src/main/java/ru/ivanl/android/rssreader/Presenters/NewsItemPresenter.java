package ru.ivanl.android.rssreader.Presenters;

import android.content.Context;
import android.content.Intent;

import ru.ivanl.android.rssreader.DetailActivity;
import ru.ivanl.android.rssreader.RSSParsing.RSSFeedItem;
import ru.ivanl.android.rssreader.Views.INewsItemView;

/**
 * Created by Ivan on 23.05.2016.
 */
public class NewsItemPresenter implements INewsItemPresenter {

    private static final String INTENT_GUID = "guid";

    private INewsItemView iNewsItemView;
    private RSSFeedItem rssFeedItem;

    public NewsItemPresenter(INewsItemView iNewsItemView) {
        this.iNewsItemView = iNewsItemView;
    }

    @Override
    public void setData() {
        rssFeedItem = iNewsItemView.getData();
        iNewsItemView.setImage();
        iNewsItemView.setDescription();
    }

    @Override
    public RSSFeedItem returnItem() {
        return rssFeedItem;
    }

    public static Intent prepareIntent (Context context, RSSFeedItem detailItem) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(INTENT_GUID, detailItem);

        return intent;
    }
}
