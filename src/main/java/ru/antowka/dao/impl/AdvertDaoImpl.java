package ru.antowka.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.antowka.dao.AdvertDao;
import ru.antowka.dao.HibernateSessionFactory;
import ru.antowka.entity.Advert;

import javax.transaction.Transactional;

/**
 * Created by Anton Nik on 13.10.15.
 */
@Repository
public class AdvertDaoImpl implements AdvertDao{

    @Autowired
    private HibernateSessionFactory hibernateSessionFactory;

    @Override
    @Transactional
    public void create(Advert advert) {
        try {
            Session session = hibernateSessionFactory.getSession();
            session.save(advert);
        }catch (Exception e){
            String test = "";
        }
    }

    @Override
    @Transactional
    public Advert get() {
        return null;
    }

    @Override
    @Transactional
    public Advert update(Advert advert) {
        return null;
    }

    @Override
    @Transactional
    public void remove(Advert advert) {

    }
}
