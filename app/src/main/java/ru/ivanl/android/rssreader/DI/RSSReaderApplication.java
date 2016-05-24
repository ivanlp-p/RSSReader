package ru.ivanl.android.rssreader.DI;

import android.app.Application;
import ru.ivanl.android.rssreader.Views.INewsView;

/**
 * Created by Ivan on 17.05.2016.
 */
public class RSSReaderApplication extends Application {

    public AppComponent appComponent;
    public INewsView view;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .rSSDataModule(new RSSDataModule())
                .appModule(new AppModule(view, getApplicationContext()))
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}
