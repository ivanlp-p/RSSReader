package ru.ivanl.android.rssreader.Presenters;

import ru.ivanl.android.rssreader.Views.INewsView;

/**
 * Created by Ivan on 23.05.2016.
 */
public class NewsPresenter implements INewsPresenter {
    private INewsView newsView;

    public NewsPresenter(INewsView newsView) {
        this.newsView = newsView;
    }
}
