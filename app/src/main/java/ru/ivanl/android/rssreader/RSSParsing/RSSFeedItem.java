package ru.ivanl.android.rssreader.RSSParsing;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by Ivan on 17.05.2016.
 */
@Root(name = "item", strict = false)
public class RSSFeedItem implements Serializable {

    @Element(name = "guid")
    private String guid;
    @Element(name = "title")
    private String title;
    @Element(name = "enclosure")
    private Enclosure enclosure;
    @Element(name = "description")
    private String description;

    public RSSFeedItem() {
    }

    public RSSFeedItem(String guid, String title, Enclosure enclosure, String description) {
        this.guid = guid;
        this.title = title;
        this.enclosure = enclosure;
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public String getDescription() {
        return description;
    }


    public class Enclosure implements Serializable {

        @Attribute(name = "url")
        private String url;

        public Enclosure() {
        }

        public Enclosure(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }
}
