package com.google.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by inna on 5/11/17.
 */
public class ResultPage {

    public ElementsCollection results = $$(".rc>div");

    public String  getFirstLink() {
        return  $(".rc>div").getText();
    }

    public void assertResultsAmount(int i) {
        results.shouldHave(size(i));
    }

    public void enterFirstLink() {
        $(".r>a").pressEnter();
    }
}
