package ru.antowka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.antowka.dao.AdvertDao;
import ru.antowka.entity.Advert;

/**
 * Created by Anton Nik on 13.10.15.
 */
@Service
public class AdvertService {

    @Autowired
    private AdvertDao advertDao;

    public void addAds(Advert advert){
        advertDao.create(advert);
    }
}
