package ru.ivanl.android.rssreader.DI;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.ivanl.android.rssreader.MainActivity;
import ru.ivanl.android.rssreader.Presenters.NewsPresenter;
import ru.ivanl.android.rssreader.Views.INewsView;

/**
 * Created by User on 18.05.2016.
 */
@Module
public class AppModule {

    private Context context;
    private INewsView view;

    public AppModule(INewsView view, Context context) {
        this.context = context;
        this.view = view;
    }

    @Singleton
    @Provides
    Context provideContext() {return context;}

    @Singleton
    @Provides
    INewsView provideView(){
        return view;
    }

    @Singleton
    @Provides
    NewsPresenter provideNewsPresenter(INewsView view, Context context){return new NewsPresenter(view, context);}

}
