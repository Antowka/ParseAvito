package ru.antowka.dao;

import ru.antowka.entity.AdvertUser;

/**
 * Created by Anton on 13.10.15.
 */
public interface AdvertUserDao {

    void create(AdvertUser advertUser);
    AdvertUser get();
    AdvertUser update(AdvertUser advertUser);
    void remove(AdvertUser advertUser);
}
