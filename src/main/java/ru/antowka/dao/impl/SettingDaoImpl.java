package ru.antowka.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.antowka.dao.HibernateSessionFactory;
import ru.antowka.dao.SettingDao;
import ru.antowka.entity.Setting;

import javax.transaction.Transactional;

/**
 * Created by Anton Nik on 20.10.15.
 */
@Repository
public class SettingDaoImpl implements SettingDao {


    @Autowired
    private HibernateSessionFactory hibernateSessionFactory;


    @Override
    @Transactional
    public void setSetting(Setting setting) {

        Session session = hibernateSessionFactory.getSession();
        session.saveOrUpdate(setting);
    }

    @Override
    @Transactional
    public Setting getSetting(int settingId) {

            Session session = hibernateSessionFactory.getSession();
            return (Setting) session.get(Setting.class, settingId);
    }

    @Override
    @Transactional
    public Setting getSetting(String settingName) {

        Session session = hibernateSessionFactory.getSession();
        return (Setting)session.createCriteria(Setting.class)
                                                    .add(Restrictions.eq("settingName", settingName))
                                                    .uniqueResult();
    }
}
