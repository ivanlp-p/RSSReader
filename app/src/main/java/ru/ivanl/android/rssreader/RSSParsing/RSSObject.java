package ru.ivanl.android.rssreader.RSSParsing;

/**
 * Created by Ivan on 17.05.2016.
 */
public class RSSObject {

    private String guid;
    private String title;
    private String imageNews;
    private String description;

    public RSSObject(String guid, String title, String imageNews, String description) {
        this.guid = guid;
        this.title = title;
        this.imageNews = imageNews;
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    public String getImageNews() {
        return imageNews;
    }

    public String getDescription() {
        return description;
    }
}
