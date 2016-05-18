package ru.ivanl.android.rssreader.DI;

import javax.inject.Singleton;

import dagger.Component;
import ru.ivanl.android.rssreader.Adapters.RSSAdapter;
import ru.ivanl.android.rssreader.MainActivity;
import ru.ivanl.android.rssreader.RSSParsing.RSSFeed;

/**
 * Created by Ivan on 17.05.2016.
 */
@Singleton
@Component(modules={RSSDataModule.class, AppModule.class})
public interface AppComponent {
    void inject(MainActivity obj);

}
