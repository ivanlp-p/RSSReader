package ru.ivanl.android.rssreader.RSSParsing;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;


/**
 * Created by User on 18.05.2016.
 */
@Root(name = "rss", strict = false)
public class RSSFeed implements Serializable{

    @Element(name = "channel")
    public RSSChannel channel;

    public RSSChannel getChannel() {
        return channel;
    }


    public RSSFeed() {
    }

    public RSSFeed(RSSChannel channel) {
        this.channel = channel;
    }


}
