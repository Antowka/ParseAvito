package ru.antowka.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.antowka.entity.Page;

import java.io.IOException;
import java.util.List;

/**
 * Created by Anton Nik on 14.10.15.
 */
@Service
public class Parser {

    private Document doc;

    @Async
    public List<Page> pagesParse(String url){

        try {

            doc = Jsoup.connect(url).get();

            System.out.println(doc.title());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
