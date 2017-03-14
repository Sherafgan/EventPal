package com.eventpal.events;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EventDaoTest extends CommonTest {

    @Before
    public void beforeBookDaoTest() {
        eventDao.saveOrUpdateEvent(event);
        System.out.println();
    }

    @After
    public void afterBookDaoTest() {
        eventDao.deleteAllEvents();
    }

    @Test
    public void getAllBooksShouldReturnAllBooks() {
        assertThat(eventDao.getAllEvents().size(), is(equalTo(1)));
    }

    @Test
    public void deleteAllBooksShouldDeleteAllBooks() {
        eventDao.deleteAllEvents();
        assertThat(eventDao.getAllEvents().size(), is(equalTo(0)));
    }

    @Test
    public void getAllBooksShouldReturnsBooksWithId() {
        Event actual = eventDao.getAllEvents().get(0);
        assertThat(actual.getId(), is(equalTo(id)));
    }

    @Test
    public void getAllBooksShouldReturnsBooksWithTitle() {
        Event actual = eventDao.getAllEvents().get(0);
        assertThat(actual.getName(), is(equalTo(name)));
    }

    @Test
    public void getAllBooksShouldReturnsBooksWithoutAuthor() {
        Event actual = eventDao.getAllEvents().get(0);
        assertThat(actual.getAuthor(), is(nullValue()));
    }

    @Test
    public void getAllBooksShouldReturnBooksStartingFromSpecifiedFirstResult() {
        int size = 10;
        int firstResult = 5;
        int expected = size - firstResult;
        eventDao.deleteAllEvents();
        insertBooks(size);
        assertThat(eventDao.getAllEvents(firstResult, 0).size(), is(equalTo(expected)));
    }

    @Test
    public void getAllBooksShouldReturnBooksWithSpecifiedMaxResult() {
        int size = 20;
        int maxResult = 10;
        eventDao.deleteAllEvents();
        insertBooks(size);
        assertThat(eventDao.getAllEvents(0, maxResult).size(), is(equalTo(maxResult)));
    }

    @Test
    public void getAllBooksShouldReturnBooksWithSpecifiedMaxResultStartingFromSpecifiedFirstResult() {
        int size = 20;
        int firstResult = 5;
        int maxResult = 10;
        eventDao.deleteAllEvents();
        insertBooks(size);
        List<Event> actual = eventDao.getAllEvents(firstResult, maxResult);
        assertThat(actual.size(), is(equalTo(maxResult)));
        assertThat(actual.get(0).getId(), is(equalTo(firstResult + 1)));
    }

    @Test
    public void getBookShouldReturnBookWithTheSpecifiedId() {
        Event actual = eventDao.getEvent(id);
        assertThat(actual, is(equalTo(actual)));
    }

    @Test
    public void getBookShouldReturnNullIfIdDoesNotExist() {
        Event actual = eventDao.getEvent(123);
        assertThat(actual, is(nullValue()));
    }

    @Test
    public void saveOrUpdateBookShouldSaveTheNewBook() {
        int actualId = 123;
        event.setId(actualId);
        eventDao.saveOrUpdateEvent(event);
        assertThat(eventDao.getAllEvents().size(), is(equalTo(2)));
        assertThat(eventDao.getEvent(actualId), is(equalTo(event)));
    }

    @Test
    public void saveOrUpdateBookShouldUpdateExistingBook() {
        event.setAuthor("this is new author");
        eventDao.saveOrUpdateEvent(event);
        assertThat(eventDao.getAllEvents().size(), is(equalTo(1)));
        assertThat(eventDao.getEvent(id), is(equalTo(event)));
    }

    @Test
    public void deleteBookShouldReturnDeletedBook() {
        Event actual = eventDao.deleteEvent(id);
        assertThat(actual, is(equalTo(event)));
    }

    @Test
    public void deleteBookShouldReturnNullIfBookDoesNotExist() {
        Event actual = eventDao.deleteEvent(123);
        assertThat(actual, is(nullValue()));
    }

    @Test
    public void deleteBookShouldDeleteSpecifiedBook() {
        eventDao.deleteEvent(id);
        assertThat(eventDao.getAllEvents().size(), is(equalTo(0)));
    }

}
