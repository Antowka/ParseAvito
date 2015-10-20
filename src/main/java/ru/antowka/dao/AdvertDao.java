package ru.antowka.dao;

import ru.antowka.entity.Advert;

import java.util.List;

/**
 * Created by Anton on 13.10.15.
 */
public interface AdvertDao {

    void create(Advert advert);
    List<Advert> getAdverts(int lastAdvertId, int offset);
    Advert get();
    void update(Advert advert);
    void remove(Advert advert);
}
