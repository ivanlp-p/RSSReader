package ru.ivanl.android.rssreader.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import ru.ivanl.android.rssreader.DI.RSSReaderApplication;
import ru.ivanl.android.rssreader.DetailActivity;
import ru.ivanl.android.rssreader.R;
import ru.ivanl.android.rssreader.RSSParsing.RSSFeedItem;

/**
 * Created by User on 18.05.2016.
 */
public class RSSAdapter extends RecyclerView.Adapter<RSSAdapter.RSSHolder> {

    @Inject
    Context context;

    private List<RSSFeedItem> itemList;
    private RSSFeedItem detailItem;
    private LayoutInflater inflater;

    public RSSAdapter(List<RSSFeedItem> itemList, Context context) {

        ((RSSReaderApplication) context.getApplicationContext()).getAppComponent().inject(this);
        this.itemList = itemList;
        this.context = context;
    }



    @Override
    public RSSHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        View view = inflater.inflate(R.layout.rss_news_item, parent, false);

        final RSSHolder holder = new RSSHolder(view);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("intent_out",itemList.get(holder.getAdapterPosition()).getTitle());
                detailItem = itemList.get(holder.getAdapterPosition());
                Intent intent = DetailActivity.prepareIntent(context, detailItem);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RSSHolder holder, int position) {
        RSSFeedItem currentItem = itemList.get(position);
        String url = "";

        try{
            url = currentItem.getEnclosure().getUrl();
            Picasso.with(holder.imageNews.getContext()).load(url).resize(420,280).centerInside().into(holder.imageNews);

        } catch (NullPointerException e) {
            Picasso.with(holder.imageNews.getContext()).load(R.drawable.loga_lentaru).resize(420,280).centerInside().into(holder.imageNews);
        }


        holder.title.setText(currentItem.getTitle());
    }

    @Override
    public int getItemCount() {
        if (itemList == null){
            return 0;
        }
        return itemList.size();
    }

    public class RSSHolder extends RecyclerView.ViewHolder {

        private final ImageView imageNews;
        private final TextView title;

        public RSSHolder(final View itemView) {
            super(itemView);

            imageNews = (ImageView) itemView.findViewById(R.id.image_item);
            title = (TextView) itemView.findViewById(R.id.title_item);

        }
    }

}
