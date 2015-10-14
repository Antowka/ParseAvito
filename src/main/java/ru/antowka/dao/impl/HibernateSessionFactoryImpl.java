package ru.antowka.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.antowka.dao.HibernateSessionFactory;

/**
 * Created by Anton Nik on 15.10.15.
 */
public class HibernateSessionFactoryImpl implements HibernateSessionFactory {

    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
