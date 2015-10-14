package ru.antowka.entity;

/**
 * Created by Anton Nik on 13.10.15.
 */
public class Advert {

    private int advertId;
    private String title;
    private String description;
    private String link;
    private String date;

    public int getAdvertId() {
        return advertId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
