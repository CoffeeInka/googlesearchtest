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
        Configuration.browser = "firefox";
    }


    @Test
    public void testSearchThenFollowLink() {
        open("http://www.google.com");
        search("Selenium automates browsers");
        assertResultsAmount(10);
        results.first().shouldHave(text("Selenium automates browsers"));
        results.first().$("a").click();
        $$("#mainContent>h2").first().shouldBe(visible);
        assertEquals(url(), "http://www.seleniumhq.org/");
    }

    private void search(String query) {
        $("#lst-ib").setValue(query).pressEnter();
    }

    public ElementsCollection results = $$(".srg > .g");

    public void assertResultsAmount(int resultsAmount) {
        results.shouldHave(size(resultsAmount));
    }
}
