package com.laioffer.eventreporter;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */

// list view in the main activity
public class EventFragment extends Fragment {

    // the main activity should implements this interface
    // and that method implemented by main activity will trigger function call in comment fragment
    OnItemSelectListener mCallback;

    // Container Activity must implement this interface
    // means that activity can do such thing
    public interface OnItemSelectListener {
        public void onItemSelected(int position);
    }

    // context is the activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            // force the main activity cast to this
            mCallback = (OnItemSelectListener) context;
        } catch (ClassCastException e) {
            //do something
        }
    }

    // once constructor with parameter
    // then the data passed from parameter will not be stored
    // once rotate, the activity and fragment will get recreated
    // all the data will be lost
    public EventFragment() {
        // Required empty public constructor
    }

    // data can be stored in bundle
    // even rotate, the newly created activity and fragment can get the previous data again
    public static EventFragment newInstance() {

        Bundle args = new Bundle();

        EventFragment fragment = new EventFragment();
        fragment.setArguments(args);
        return fragment;
    }

    // set list view to fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        ListView listView = (ListView) view.findViewById(R.id.event_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getEventNames());

        // Assign adapter to ListView.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.onItemSelected(i);
            }
        });

        return view;
    }

    private String[] getEventNames() {
        String[] names = {
                "Event1", "Event2", "Event3",
                "Event4", "Event5", "Event6",
                "Event7", "Event8", "Event9",
                "Event10", "Event11", "Event12"};
        return names;
    }
}
