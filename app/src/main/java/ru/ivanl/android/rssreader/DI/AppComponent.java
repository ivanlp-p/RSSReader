package ru.ivanl.android.rssreader.DI;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ivan on 17.05.2016.
 */
@Singleton
@Component(modules={RSSDataModule.class})
public interface AppComponent {
    void inject(RSSReaderApplication obj);
}
