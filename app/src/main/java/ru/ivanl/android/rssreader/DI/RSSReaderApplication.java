package ru.ivanl.android.rssreader.DI;

import android.app.Application;

/**
 * Created by Ivan on 17.05.2016.
 */
public class RSSReaderApplication extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .rSSDataModule(new RSSDataModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
