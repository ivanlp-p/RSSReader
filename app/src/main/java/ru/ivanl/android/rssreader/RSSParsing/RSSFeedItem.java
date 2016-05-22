package ru.ivanl.android.rssreader.RSSParsing;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by Ivan on 17.05.2016.
 */
@Root(name = "item", strict = false)
public class RSSFeedItem implements Parcelable {

    @Element(name = "guid")
    private String guid;
    @Element(name = "title")
    private String title;
    @Element(name = "enclosure", required = false)
    public RSSEnclosure enclosure;
    @Element(name = "description")
    private String description;

    public RSSFeedItem() {
    }

    public RSSFeedItem(String guid, String title, RSSEnclosure enclosure, String description) {
        this.guid = guid;
        this.title = title;
        this.enclosure = enclosure;
        this.description = description;
    }

    public RSSFeedItem(Parcel source) {
        guid = source.readString();
        title = source.readString();
        try{
            enclosure = (RSSEnclosure) source.readSerializable();
        } catch (NullPointerException e) {
            enclosure = new RSSEnclosure();
        }

        description = source.readString();
    }

    public String getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    public RSSEnclosure getEnclosure() {
        return enclosure;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(guid);
        dest.writeString(title);
        dest.writeSerializable(enclosure);
        dest.writeString(description);

    }

    public static final Parcelable.Creator<RSSFeedItem> CREATOR = new Parcelable.Creator<RSSFeedItem>() {

        @Override
        public RSSFeedItem createFromParcel(Parcel source) {
            return new RSSFeedItem(source);
        }

        @Override
        public RSSFeedItem[] newArray(int size) {
            return new RSSFeedItem[size];
        }
    };





    public static class RSSEnclosure implements Serializable {

        @Attribute(name = "url")
        private String url;

        @Attribute(name = "length")
        private String length;

        @Attribute(name = "type")
        private String type;

        public RSSEnclosure() {

        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public String getLength() {
            return length;
        }

        public String getType() {
            return type;
        }
    }


}

