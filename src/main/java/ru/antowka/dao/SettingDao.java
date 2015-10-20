package ru.antowka.dao;

import ru.antowka.entity.Setting;

/**
 * Created by anton on 20.10.15.
 */
public interface SettingDao {

    void setSetting(Setting setting);
    Setting getSetting(int settingId);
    Setting getSetting(String settingName);
}
