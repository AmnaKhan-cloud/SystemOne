package com.main.page;

import java.io.IOException;
import java.util.List;


import base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.AppConstants;
import util.Common;

import javax.naming.directory.SearchResult;

import static org.apache.commons.collections4.IteratorUtils.forEach;


public class AccountsPage {


    static Common eleUtil;

    private static By logoutLink = By.linkText("Logout");
    private static By search = By.name("search");
    private static By searchIcon = By.cssSelector("div#search button");
    private By accSecHeaders = By.cssSelector("div#content h2");
    private By acc = By.cssSelector("div#content h1");
    private static By productSearchLayout = By.cssSelector("div.product-layout");

    public AccountsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        eleUtil = new Common(driver);
    }


    @Step("isLogoutLinkExist.....")
    public static boolean isLogoutLinkExist() {
        return LoginPage.eleUtil.doEleIsDisplayed(logoutLink);
    }

    @Step("getAccPageTitle......")
    public String getAccPageTitle() throws IOException {
        String title = eleUtil.waitForTitleIs(AppConstants.ACC_PAGE_TITLE, AppConstants.DEFAULT_TIME_OUT);
        System.out.println("Acc page title : " + title);
        return title;
    }

    @Step("getAccPageUrl.....")
    public boolean getAccPageUrl() throws IOException {
        String url = eleUtil.waitForUrlContains(AppConstants.ACC_PAGE_URL_PARAM, AppConstants.DEFAULT_TIME_OUT);
        System.out.println("Acc page url : " + url);
        if (url.contains(AppConstants.ACC_PAGE_URL_PARAM)) {
            return true;
        }
        return false;
    }

    @Step("Verify isSearchExist.....")
    public static boolean isSearchExist() throws IOException {
        return eleUtil.doEleIsDisplayed(search);
    }

    @Step("performSearch.....{0}")
    public static void performSearch(String productKey) throws IOException {
        System.out.println("Product Key is : " + productKey);
        if (isSearchExist()) {
            eleUtil.doSendKeys(search, productKey);
            eleUtil.doClick(searchIcon);

        } else {
            System.out.println("search field is not present on the page.....");
        }
    }

    public static boolean isSearchSuccessful() {
        List<WebElement> searchList = eleUtil.waitForElementsVisible(productSearchLayout,
                AppConstants.DEFAULT_LARGE_TIME_OUT);
        for(int i=0;i<searchList.size();i++){
        if (searchList.size() > 0) {
            System.out.println("Search is successfully done.....");
           String item= searchList.get(i).getText();
           System.out.println(item);

            return true;
        }}

        return false;
    }
}
