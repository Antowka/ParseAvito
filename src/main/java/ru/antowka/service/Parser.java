package ru.antowka.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.antowka.entity.Advert;

import java.io.IOException;

/**
 * Created by Anton Nik on 14.10.15.
 */
@Service
public class Parser {

    private Document doc;

    @Autowired
    private AdvertService advertService;

    @Autowired
    private Advert advert;

    @Async
    public void pagesParse(String url){

        try {

            doc = Jsoup.connect(url).get();

            advert.setTitle(doc.title());
            advert.setLink(url);
            advert.setDescription("Test description");
            advert.setDate("2014.10.14 00:10:00");

            advertService.addAds(advert);

            System.out.println(doc.title());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
