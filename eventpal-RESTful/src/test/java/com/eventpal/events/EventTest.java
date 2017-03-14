package com.eventpal.events;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EventTest extends CommonTest {

    @Test
    public void idShouldHaveSetterAndGetter() {
        int expected = 123;
        event.setId(expected);
        assertThat(event.getId(), is(equalTo(expected)));
    }

    @Test
    public void nameShouldHaveSetterAndGetter() {
        String expected = "new name";
        event.setName(expected);
        assertThat(event.getName(), is(equalTo(expected)));
    }

    @Test
    public void descriptionShouldHaveSetterAndGetter() {
        String expected = "new description";
        event.setDescription(expected);
        assertThat(event.getDescription(), is(equalTo(expected)));
    }

    @Test
    public void authorShouldHaveSetterAndGetter() {
        String expected = "new author";
        event.setAuthor(expected);
        assertThat(event.getAuthor(), is(equalTo(expected)));
    }

    @Test
    public void latitudeShouldHaveSetterAndGetter() {
        double expected = 123.45;
        event.setLatitude(expected);
        assertThat(event.getLatitude(), is(equalTo(expected)));
    }

    @Test
    public void longitudeShouldHaveSetterAndGetter() {
        double expected = 543.21;
        event.setLongitude(expected);
        assertThat(event.getLongitude(), is(equalTo(expected)));
    }

    @Test
    public void linkShouldHaveSetterAndGetter() {
        String expected = "new link";
        event.setLink(expected);
        assertThat(event.getLink(), is(equalTo(expected)));
    }

    @Test
    public void equalsShouldFailIfIdIsNotTheSame() {
        Event actual = new Event(123);
        actual.setName(name);
        actual.setDescription(description);
        actual.setAuthor(author);
        actual.setLatitude(latitude);
        actual.setLongitude(longitude);
        assertThat(actual, is(not(equalTo(event))));
    }

    @Test
    public void equalsShouldReturnFalseIfImageIsNotTheSame() {
        Event actual = new Event(id);
        actual.setName("new Name");
        actual.setDescription(description);
        actual.setAuthor(author);
        actual.setLatitude(latitude);
        actual.setLongitude(longitude);
        assertThat(actual, is(not(equalTo(event))));
    }

    @Test
    public void equalsShouldReturnFalseIfTitleIsNotTheSame() {
        Event actual = new Event(id);
        actual.setName(name);
        actual.setDescription("new description");
        actual.setAuthor(author);
        actual.setLatitude(latitude);
        actual.setLongitude(longitude);
        assertThat(actual, is(not(equalTo(event))));
    }

    @Test
    public void equalsShouldReturnFalseIfAuthorIsNotTheSame() {
        Event actual = new Event(id);
        actual.setName(name);
        actual.setDescription(description);
        actual.setAuthor("new author");
        actual.setLatitude(latitude);
        actual.setLongitude(longitude);
        assertThat(actual, is(not(equalTo(event))));
    }

    @Test
    public void equalsShouldReturnFalseIfPriceIsNotTheSame() {
        Event actual = new Event(id);
        actual.setName(name);
        actual.setDescription(description);
        actual.setAuthor(author);
        actual.setLatitude(123.45);
        actual.setLongitude(543.21);
        assertThat(actual, is(not(equalTo(event))));
    }

    @Test
    public void equalShouldReturnTrueIfIdImageTitleAuthorAndPriceAreTheSame() {
        Event actual = new Event(id);
        actual.setName(name);
        actual.setDescription(description);
        actual.setAuthor(author);
        actual.setLatitude(latitude);
        actual.setLongitude(longitude);
        assertThat(actual, is(equalTo(event)));
    }

}
