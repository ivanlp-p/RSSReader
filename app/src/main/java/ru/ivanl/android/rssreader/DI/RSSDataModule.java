package ru.ivanl.android.rssreader.DI;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.ivanl.android.rssreader.RSSParsing.RSSService;

/**
 * Created by Ivan on 17.05.2016.
 */
@Module
public class RSSDataModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {

        HttpLoggingInterceptor fullLogInterceptor = new HttpLoggingInterceptor();
        fullLogInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(RSSService.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(RSSService.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(RSSService.TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(fullLogInterceptor)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .baseUrl(RSSService.URL_BASE)
                .client(httpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    RSSService provideRSSService (Retrofit retrofit) {return retrofit.create(RSSService.class);}
}
