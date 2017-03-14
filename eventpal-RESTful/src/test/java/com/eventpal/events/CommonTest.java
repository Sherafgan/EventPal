package com.eventpal.events;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class CommonTest {

    protected final int id = 42;
    protected final String name = "Big Party";
    protected final String description = "Big Testing Event";
    protected final String author = "Sherafgan Kandov";
    protected final double latitude = 3.12321312;
    protected final double longitude = 2.3434455;
    protected final String link = "/eventpal-api/v1/events/42";
    protected Event event;
    protected EventDao eventDao = EventDao.getInstance();

    @Before
    public void beforeCommonTest() {
        event = new Event(id);
        event.setName(name);
        event.setDescription(description);
        event.setAuthor(author);
        event.setLatitude(latitude);
        event.setLongitude(longitude);
    }

    protected List<Event> insertBooks(int count) {
        List<Event> events = new ArrayList<>();
        for (int index = 1; index <= count; index++) {
            Event event = new Event(index);
            event.setName(name);
            event.setDescription(description);
            event.setAuthor(author);
            event.setLatitude(latitude);
            event.setLongitude(longitude);
            eventDao.saveOrUpdateEvent(event);
            events.add(event);
        }
        return events;
    }

}
