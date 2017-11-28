package com.georgebotas.library;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    Logger logger = LogManager.getLogger();

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");

        IMenu imenu = (IMenu)context.getBean("imenu");;
        System.out.println(Print.mainMenu);
        imenu.select();
    }
}
