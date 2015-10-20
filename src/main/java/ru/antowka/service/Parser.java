package ru.antowka.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.antowka.entity.Advert;
import ru.antowka.entity.Setting;

import javax.lang.model.element.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton Nik on 14.10.15.
 */
@Service
public class Parser {

    private Document doc;

    private String lastPageUrl = null;

    @Autowired
    private AdvertService advertService;

    @Autowired
    private Advert advert;

    @Autowired
    private SettingService settingService;

    /**
     * Parse list links on adverts
     */
    @Async
    public void pagesParse(){

        try {

            Setting setting = settingService.getSetting(1);
            doc = Jsoup.connect(setting.getSettingValue()).get();

            //get list links on adverts
            doc.select(".item-link").stream().forEach(element -> {
                advert.setTitle("empty");
                advert.setLink(element.attr("href"));
                advert.setDescription("empty");
                advert.setDate("2015.10.14 00:10:00");
                advertService.addAds(advert);
            });

            //get new page with list links on adverts
            lastPageUrl = doc.select(".page-next a").attr("href");

            //save to DB next pars page
            setting.setSettingValue("https://m.avito.ru" + lastPageUrl);
            settingService.setSetting(setting);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pars all data from advert
     */
    @Async
    public void advertParse(){

        Setting setting = settingService.getSetting(2);
        Integer advertId = Integer.parseInt(setting.getSettingValue());
        List<Advert> adverts = advertService.getAdverts(advertId, 2);

        adverts.stream().forEach(advert -> {

            try {
                doc = Jsoup.connect("https://m.avito.ru" + advert.getLink()).get();

                advert.setTitle(doc.select(".text-main").text());
                advert.setDescription(doc.select(".description-preview-wrapper p").text());
                advert.setCity(doc.select(".avito-address-text").text());
                advert.setName(doc.select(".person-name").text());
                advert.setAgency(doc.select(".person-name .info-text").text());
                advert.setCategory(doc.select(".param-last").text());
                advertService.updateAdvert(advert);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Advert advertLast = adverts.stream().reduce((previous, current) -> current).get();
        setting.setSettingValue(Integer.toString(advertLast.getAdvertId()));

        settingService.setSetting(setting);
    }
}
