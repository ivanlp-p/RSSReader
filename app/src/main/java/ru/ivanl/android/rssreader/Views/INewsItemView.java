package ru.ivanl.android.rssreader.Views;

import ru.ivanl.android.rssreader.RSSParsing.RSSFeedItem;

/**
 * Created by Ivan on 23.05.2016.
 */
public interface INewsItemView {
    RSSFeedItem getData();
    void setImage();

    void setDescription();
}
