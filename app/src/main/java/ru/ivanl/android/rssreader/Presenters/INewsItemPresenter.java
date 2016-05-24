package ru.ivanl.android.rssreader.Presenters;

import ru.ivanl.android.rssreader.RSSParsing.RSSFeedItem;

/**
 * Created by Ivan on 23.05.2016.
 */
public interface INewsItemPresenter {
    void setData();

    RSSFeedItem returnItem();
}
