package com.eventpal.events;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/events")
@Produces(MediaType.APPLICATION_JSON)
public class EventApi {

    private static final String EVENTS_URL = "/eventpal-api/v1/events";

    @GET
    @JSONP(queryParam = "callback")
    public String getAllEvents(@QueryParam("offset") int offset,
                               @QueryParam("count") int count,
                               @QueryParam("callback") String callback) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        List<Event> events = EventDao.getInstance().getAllEvents(offset, count);
        for (Event event : events) {
            event.setLink(EVENTS_URL + "/" + event.getId());
        }
        return mapper.writeValueAsString(events);
    }

    @DELETE
    @JSONP(queryParam = "callback")
    public void deleteAllEvents() throws Exception {
        EventDao.getInstance().deleteAllEvents();
    }

    @GET
    @Path("/{id}")
    @JSONP(queryParam = "callback")
    public String getEvent(@PathParam("id") int id) throws Exception {
        Event event = EventDao.getInstance().getEvent(id);
        return new ObjectMapper().writeValueAsString(event);
    }


    @PUT
    @JSONP(queryParam = "callback")
    public void putEvent(String eventJson) throws Exception {
        Event event = new ObjectMapper().readValue(eventJson, Event.class);
        EventDao.getInstance().saveOrUpdateEvent(event);
    }

    @DELETE
    @Path("/{id}")
    @JSONP(queryParam = "callback")
    public void deleteEvent(@PathParam("id") int id) throws Exception {
        EventDao.getInstance().deleteEvent(id);
    }

}
