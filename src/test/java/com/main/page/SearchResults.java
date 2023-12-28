package com.main.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.Common;

public class SearchResults {


    Common eleUtil;

    public void SearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);

        eleUtil = new Common(driver);

    }
}

