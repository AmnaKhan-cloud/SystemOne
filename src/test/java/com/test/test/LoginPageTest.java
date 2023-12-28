package com.test.test;


import base.TestBase;

import base.TestUtil;

import com.main.page.AccountsPage;
import com.main.page.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;



@Epic("Epic - 01: Open cart application login page design")
@Story("US - 1: Design login page features")
public class LoginPageTest extends TestBase {
    private WebDriver driver;
    private LoginPage mainPage;
    public AccountsPage accPage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {

		initialization();
		 TestUtil testUtil = new TestUtil();
		mainPage = new LoginPage(TestBase.driver);

	}


    @AfterMethod
    public void tearDown() {
        TestBase.driver.quit();
    }


    @Description("Verify the login page title test.....")
    @Severity(SeverityLevel.MINOR)
    @Test(priority=1)
    public void loginPageTitleTest() throws IOException {
        try {
            String title = LoginPage.validateLoginPageTitle();
            Assert.assertEquals(title, "Account Login");
            System.out.println("Test case-001 has been passed");
        }catch(IOException e){
           e.printStackTrace();
        }
    }

    @Description("Verify the login page url test.....")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void loginPageUrlTest() throws IOException {
        try {
            String url = LoginPage.getLoginPageUrl();
            Assert.assertEquals(url, "https://naveenautomationlabs.com/opencart/index.php?route=account/login");
            System.out.println("Test case-002 has been passed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Description("Verify the login page is displaying forgot pwd link test.....")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void isForgotPwdLinkExistTest() throws IOException {
            try {
                Assert.assertEquals(LoginPage.isForgotPwdLinkExist(), true);
                System.out.println("Test case-003 has been passed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @Description("Verify the login page- Login Test with correct username and password.....")
        @Severity(SeverityLevel.BLOCKER)
        @Test(priority = 4)
        @Step("login with username : {0} and password: {1}")
        public void loginTest () {
            try{
            accPage = LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
            Assert.assertTrue(AccountsPage.isLogoutLinkExist());
            System.out.println("Test case-004 has been passed");
        }catch(IOException e){
           e.printStackTrace();
            }
        }

}

