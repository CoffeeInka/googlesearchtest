package com.google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;


/**
 * Created by inna on 5/11/17.
 */
public class GoogleSearchTest {

    @Before
    public void setUp(){
    open("http://google.com");
    }

    @After
    public void tearDown() {
        close();
    }


    @Test
    public void searchTest(){
        HomePage home = new HomePage();
        ResultPage result = home.search("Selenium automates browsers");
        assertTrue(result.getFirstLink() .contains("Selenium automates browsers");
    }
}
