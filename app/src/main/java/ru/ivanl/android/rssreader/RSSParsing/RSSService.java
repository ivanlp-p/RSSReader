package ru.ivanl.android.rssreader.RSSParsing;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ivan on 17.05.2016.
 */
public interface RSSService {

    String URL_BASE = "https://lenta.ru/";
    String URL_PATH = "rss";

    int CONNECT_TIMEOUT = 15;
    int WRITE_TIMEOUT = 60;
    int TIMEOUT = 60;

    @GET(URL_PATH)
    Call<List<RSSFeedItem>> getRSSData();

}
