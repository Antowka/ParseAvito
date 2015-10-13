package ru.antowka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Anton Nik on 10.10.15.
 */
public class Parser {

    public static void main(String [] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
        String test = "456";
    }
}
