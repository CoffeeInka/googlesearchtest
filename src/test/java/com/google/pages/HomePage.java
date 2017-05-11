package com.google.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by inna on 5/11/17.
 */
public class HomePage {

    public void initialize() {
        open("http://google.com/");
    }

    public ResultPage search(String s) {
        $("#lst-ib").setValue(s).pressEnter();
        return new ResultPage();
    }


}
