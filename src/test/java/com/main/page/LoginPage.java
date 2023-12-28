package com.main.page;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v117.io.IO;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Common;

import java.io.IOException;
import java.time.Duration;

import static base.TestBase.driver;

// page_url = https://www.jetbrains.com/
public class LoginPage {


  static Common eleUtil;

    private static By emailId = By.id("input-email");
    private static By password = By.id("input-password");
    private static By loginBtn = By.xpath("//input[@value='Login']");
    private By logoImage = By.cssSelector("img[title='naveenopencart']");
    private static By forgotPwdLink = By.linkText("Forgotten Password");

    private static By logout = By.xpath("//i[@class='fa fa-user']");

    private static By dp=By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']");

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        eleUtil = new Common(driver);
    }


    @Step("Waiting for login page title and fetching the title")
    public static String validateLoginPageTitle() throws IOException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if (wait.until(ExpectedConditions.titleContains("Account"))) {
            return driver.getTitle();
        } else {
            return null;
        }
    }

    @Step("Waiting for login page url and fetching the url")
    public static String getLoginPageUrl() throws IOException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if (wait.until(ExpectedConditions.urlContains("naveenautomationlabs"))) {
            return driver.getCurrentUrl();
        }
        return null;
    }


    @Step("checking forgot pwd link is displayed on login page")
    public static boolean isForgotPwdLinkExist() throws IOException{
        return eleUtil.doEleIsDisplayed(forgotPwdLink);
    }

    @Step("login with username : {0} and password: {1}")
    public static AccountsPage doLogin(String username, String pwd) throws IOException{
        System.out.println("user creds are : " + username + " : " + pwd);

        if( driver.findElement(emailId).isDisplayed()&&driver.findElement(emailId).isEnabled()) {
            driver.findElement(emailId).clear();
            driver.findElement(emailId).sendKeys(username);
            System.out.println("Email added succesfully in login");
        }


        if( driver.findElement(password).isDisplayed()&&driver.findElement(password).isEnabled()) {
            driver.findElement(password).clear();
            driver.findElement(password).sendKeys(pwd);
            System.out.println("Email added succesfully in login");
        }

       driver.findElement(loginBtn).click();
        return new AccountsPage(driver);
    }


}











