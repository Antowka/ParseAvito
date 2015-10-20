package ru.antowka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.antowka.dao.SettingDao;
import ru.antowka.entity.Setting;

/**
 * Created by Anton Nik on 20.10.15.
 */
@Service
public class SettingService {

    @Autowired
    private SettingDao settingDao;

    public void setSetting(Setting setting){
        settingDao.setSetting(setting);
    }

    public Setting getSetting(int settingId){
        return settingDao.getSetting(settingId);
    }
}
