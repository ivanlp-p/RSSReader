package ru.ivanl.android.rssreader.RSSParsing;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.nio.channels.Channel;

/**
 * Created by User on 18.05.2016.
 */
@Root(name = "rss", strict = false)
public class RSSFeed implements Serializable{

    @Element(name = "channel")
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }


    public RSSFeed() {
    }

    public RSSFeed(Channel channel) {
        this.channel = channel;
    }
}