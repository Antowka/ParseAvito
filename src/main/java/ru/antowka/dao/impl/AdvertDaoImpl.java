package ru.antowka.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.antowka.dao.AdvertDao;
import ru.antowka.dao.HibernateSessionFactory;
import ru.antowka.entity.Advert;

import javax.transaction.Transactional;
import java.util.List;

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

        Session session = hibernateSessionFactory.getSession();
        session.save(advert);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Advert> getAdverts(int lastAdvertId, int offset) {

        Session session = hibernateSessionFactory.getSession();

        return (List<Advert>)session.createCriteria(Advert.class)
                                    .addOrder(Order.asc("advertId"))
                                    .add(Restrictions.gt("advertId", lastAdvertId))
                                    .setMaxResults(offset)
                                    .list();
    }

    @Override
    @Transactional
    public Advert get() {
        return null;
    }

    @Override
    @Transactional
    public void update(Advert advert) {
        Session session = hibernateSessionFactory.getSession();
        session.update(advert);
    }

    @Override
    @Transactional
    public void remove(Advert advert) {

    }
}
