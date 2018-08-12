package com.laioffer.eventreporter;

import com.laioffer.eventreporter.artifact.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianyisun on 7/7/18.
 */

/*
 * get data from network request
 * in real project: MVP
 * model: network request
 * presenter: a link between model and view
 * view: bind the data get from presenter
 *
 * */
public class DataService {
    /**
     * Fake all the event data for now. We will refine this and connect
     * to our backend later.
     */
    public static List<Event> getEventData() {
        List<Event> eventData = new ArrayList<Event>();
        for (int i = 0; i < 10; ++i) {
            eventData.add(
                    new Event("Event", "1184 W valley Blvd, CA 90101",
                            "This is a huge event"));
        }
        return eventData;
    }
}
