package ru.antowka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Anton Nik on 10.10.15.
 */
public class Initializer {

    public static void main(String [] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{
                     "config/spring-config.xml",
                     "config/quartz-config.xml",
                     "config/service-config.xml",
                     "config/database-config.xml",
                     "config/entity-config.xml"
                });
    }
}
