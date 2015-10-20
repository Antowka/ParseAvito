package ru.antowka.job;

import org.springframework.beans.factory.annotation.Autowired;
import ru.antowka.service.Parser;

/**
 * Created by Anton Nik on 14.10.15.
 */
public class Pars {

    @Autowired
    private Parser parser;

    /**
     * Method parse links ads from startPage and reset next start page
     */
    public void parseLinks(){
        //parser.pagesParse();
        parser.advertParse();
        System.out.println("Iteration quartz!");
    }
}
