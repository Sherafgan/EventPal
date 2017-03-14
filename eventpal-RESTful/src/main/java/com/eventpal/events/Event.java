package com.eventpal.events;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Event")
@XmlRootElement
public class Event {

    public Event() {
    }

    public Event(int id) {
        setId(id);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "author")
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "latitude")
    private double latitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "longitude")
    private double longitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) {
            return false;
        }
        if (Double.compare((event.latitude + event.longitude), (latitude + longitude)) != 0) {
            return false;
        }
        if (author != null ? !author.equals(event.author) : event.author != null) {
            return false;
        }
        if (name != null ? !name.equals(event.name) : event.name != null) {
            return false;
        }
        if (description != null ? !description.equals(event.description) : event.description != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude + longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
