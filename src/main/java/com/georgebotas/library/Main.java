package com.georgebotas.library;

import com.georgebotas.library.UI.IMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        IMenu imenu = (IMenu)context.getBean("imenu");;
        imenu.select();
    }
}
