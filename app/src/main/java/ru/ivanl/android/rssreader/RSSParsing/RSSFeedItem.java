package ru.ivanl.android.rssreader.RSSParsing;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.nio.channels.Channel;

/**
 * Created by Ivan on 17.05.2016.
 */
@Root(name = "item", strict = false)
public class RSSFeedItem implements Serializable {

    @Element(name = "guid")
    private String guid;
    @Element(name = "title")
    private String title;
    @Element(name = "link")
    private String imageNews;
    @Element(name = "description")
    private String description;

    public RSSFeedItem(String guid, String title, String imageNews, String description) {
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
