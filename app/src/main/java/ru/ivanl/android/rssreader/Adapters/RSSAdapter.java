package ru.ivanl.android.rssreader.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import ru.ivanl.android.rssreader.R;
import ru.ivanl.android.rssreader.RSSParsing.RSSFeedItem;

/**
 * Created by User on 18.05.2016.
 */
public class RSSAdapter extends RecyclerView.Adapter<RSSAdapter.RSSHolder> {

    @Inject
    Context context;

    private List<RSSFeedItem> itemList;
    private LayoutInflater inflater;

    String guid;

    public RSSAdapter(List<RSSFeedItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public RSSHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        View view = inflater.inflate(R.layout.rss_news_item, parent, false);

        return new RSSHolder(view);
    }

    @Override
    public void onBindViewHolder(RSSHolder holder, int position) {
        RSSFeedItem currentItem = itemList.get(position);

        guid = currentItem.getGuid();
        Picasso.with(context).load(currentItem.getImageNews()).fit().into(holder.imageNews);
        holder.title.setText(currentItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class RSSHolder extends RecyclerView.ViewHolder {

        private final ImageView imageNews;
        private final TextView title;

        public RSSHolder(View itemView) {
            super(itemView);

            imageNews = (ImageView) itemView.findViewById(R.id.image_item);
            title = (TextView) itemView.findViewById(R.id.title_item);
        }
    }
}
