package ru.antowka.dao;

import ru.antowka.entity.Advert;

/**
 * Created by Anton on 13.10.15.
 */
public interface AdvertDao {

    void create(Advert advert);
    Advert get();
    Advert update(Advert advert);
    void remove(Advert advert);
}
