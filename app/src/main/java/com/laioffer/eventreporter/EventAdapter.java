package com.laioffer.eventreporter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.laioffer.eventreporter.artifact.Event;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tianyisun on 7/7/18.
 */

/*
* our ListView want a ListAdapter to render the view
* BaseAdapter extends ListAdapter, so can be use for ListView
* */
public class EventAdapter extends BaseAdapter {
    Context context;
    List<Event> eventData;


    public EventAdapter(Context context) {
        this.context = context;
        eventData = DataService.getEventData();
    }

    @Override
    public int getCount() {
        return eventData.size();
    }

    @Override
    public Event getItem(int position) {
        return eventData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
    * View convertView: how the current element is rendered
    *
    * */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // like setview
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.event_item,
                    parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.event_thumbnail);
        // read image from library
        Picasso.get().load("http://www.urbanfarmhub.org/wp-content/uploads/2012/07/apple.png ").into(imageView);
        TextView eventTitle = (TextView) convertView.findViewById(
                R.id.event_title);
        TextView eventAddress = (TextView) convertView.findViewById(
                R.id.event_address);
        TextView eventDescription = (TextView) convertView.findViewById(
                R.id.event_description);

        Event r = eventData.get(position);
        eventTitle.setText(r.getTitle());
        eventAddress.setText(r.getAddress());
        eventDescription.setText(r.getDescription());
        return convertView;
    }
}
