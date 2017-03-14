package com.eventpal.events;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventDao {

    private static volatile EventDao instance = null;
    private EventDao() { }

    public static synchronized EventDao getInstance() {
        if (instance == null) {
            instance = new EventDao();
        }
        return instance;
    }

    public void deleteAllEvents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("delete from Event").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public List<Event> getAllEvents() {
        return getAllEvents(0, 0);
    }
    public List<Event> getAllEvents(int firstResult, int maxResult) {
        List<Event> events = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select id, name from Event");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        @SuppressWarnings("unchecked")
        List allUsers = query.list();
        for (Iterator it = allUsers.iterator(); it.hasNext(); ) {
            Object[] eventObject = (Object[]) it.next();
            Event event = new Event((Integer) eventObject[0]);
            event.setName((String) eventObject[1]);
            events.add(event);
        }
        session.getTransaction().commit();
        session.close();
        return events;
    }

    public Event getEvent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Event event = (Event) session.get(Event.class, id);
        session.getTransaction().commit();
        session.close();
        return event;
    }

    public void saveOrUpdateEvent(Event event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(event);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public Event deleteEvent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Event event = getEvent(id);
        if (event != null) {
            session.delete(event);
            session.flush();
        }
        session.getTransaction().commit();
        session.close();
        return event;
    }

}
