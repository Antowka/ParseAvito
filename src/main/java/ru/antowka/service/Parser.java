package ru.antowka.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.antowka.entity.Advert;

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

    @Async
    public void pagesParse(String url){

        //set last page for parsing
        if(lastPageUrl != null){
            url = lastPageUrl;
        }

        try {

            doc = Jsoup.connect(url).get();

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

            System.out.println(doc.title());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
