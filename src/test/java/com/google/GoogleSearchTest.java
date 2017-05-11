package com.google;

import com.codeborne.selenide.*;
import com.google.pages.HomePage;
import com.google.pages.ResultPage;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by inna on 5/11/17.
 */
public class GoogleSearchTest {

    @BeforeClass
    public static void setup(){
        Configuration.browser = System.getProperty("driver.browser");
    }

    HomePage home = new HomePage();

    @Test
    public void searchTest(){
        home.initialize();
        ResultPage result = home.search("Selenium automates browsers");
        result.assertResultsAmount(10);
        assertTrue(result.getFirstLink().contains("Selenium automates browsers"));
    }


}
