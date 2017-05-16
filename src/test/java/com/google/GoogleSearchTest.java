package com.google;

import com.codeborne.selenide.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.*;


import static org.junit.Assert.*;


/**
 * Created by inna on 5/11/17.
 */
public class GoogleSearchTest {

    @BeforeClass
    public static void setup() {
        Configuration.browser = System.getProperty("driver.browser");
    }


    @Test
    public void googleSearchAcceptanceTest() {
        open("http://www.google.com");
        search("Selenium automates browsers");
        assertResultsAmount(10);
        results.first().shouldHave(text("Selenium automates browsers"));
        results.first().find(By.linkText("Selenium - Web Browser Automation")).click();
        selenidePageHeader.shouldBe(visible);
        assertEquals(url(), "http://www.seleniumhq.org/");
    }

    private void search(String query) {
        $("#lst-ib").setValue(query).pressEnter();
    }

    public ElementsCollection results = $$(".g");

    public SelenideElement selenidePageHeader = $("#mainContent>h2");

    public void assertResultsAmount(int resultsAmount) {
        results.shouldHave(size(resultsAmount));
    }
}
