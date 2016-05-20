package ru.ivanl.android.rssreader.RSSParsing;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 18.05.2016.
 */
@Root(name = "channel", strict = false)
public class RSSChannel implements Serializable {
    @ElementList(inline = true, name = "item")
    public List<RSSFeedItem> feedItems;

    public List<RSSFeedItem> getFeedItems() {
        return feedItems;
    }

    public RSSChannel() {
    }

    public RSSChannel(List<RSSFeedItem> feedItems) {
        this.feedItems = feedItems;
    }
}
