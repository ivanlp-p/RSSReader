package ru.ivanl.android.rssreader.Adapters;

import android.content.Context;
import android.net.Uri;
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

import ru.ivanl.android.rssreader.MainActivity;
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

        String url = currentItem.getEnclosure().getUrl();
        Log.d("happy", url);
        //holder.imageNews.setImageURI(Uri.parse(url));
        Picasso.with(holder.imageNews.getContext()).load("https://icdn.lenta.ru/images/2016/05/20/13/20160520131651734/pic_078a0919ab34c03ba66e1fa61fa836ca.jpg").into(holder.imageNews);
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

        public RSSHolder(View itemView) {
            super(itemView);

            imageNews = (ImageView) itemView.findViewById(R.id.image_item);
            title = (TextView) itemView.findViewById(R.id.title_item);
        }
    }
}
