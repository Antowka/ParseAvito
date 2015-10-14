package ru.antowka.dao;

import org.hibernate.Session;

/**
 * Created by Anton Nik on 13.10.15.
 */
public interface HibernateSessionFactory {

    public Session getSession();
}
