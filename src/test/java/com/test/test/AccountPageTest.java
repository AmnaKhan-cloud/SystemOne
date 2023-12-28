package com.test.test;


import base.TestBase;
import base.TestUtil;
import com.main.page.AccountsPage;
import com.main.page.LoginPage;
import com.main.page.SearchResults;
import io.qameta.allure.*;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import util.AppConstants;

import javax.naming.directory.SearchResult;
import java.io.IOException;

@Epic("Epic - 02: Open cart application login page design")
@Story("US - 2: Design account page features")
public class AccountPageTest extends TestBase{

    public AccountsPage accPage;

  public SearchResults searchResult;


    @BeforeClass
    public void accSetup() throws IOException {

        initialization();
        accPage= LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

    }

    @AfterClass
    public void tearDown() {
        TestBase.driver.quit();
    }

    @Description("Verify the accPageTitleTest -- ")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1)
    public void accPageTitleTest() throws IOException {
        try {
            String actAccPageTitle = accPage.getAccPageTitle();
            AssertJUnit.assertEquals(actAccPageTitle, AppConstants.ACC_PAGE_TITLE);
            System.out.println("TestCase -001 has been passed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Description("Verify the accPageUrlTest ")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void accPageUrlTest() throws IOException {
        try {
            AssertJUnit.assertTrue(accPage.getAccPageUrl());
            System.out.println("TestCase -002 has been passed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Description("Verify Acc page search test -- ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void searchExistTest() throws InterruptedException, IOException {
        AssertJUnit.assertTrue(accPage.isSearchExist());
        System.out.println("TestCase -003 has been passed");
    }

    @DataProvider
    public Object[][] getProductKey() {
        return new Object[][]{
                {"Macbook"}
               // {"iMac"},
                //{"Samsung"}
        };
    }

    @Description("Verify Acc page search check test --Input Macbook and get attributes of item")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "getProductKey", priority = 6)
    public void searchCheckTest(String productKey) throws IOException {
        try {
            AccountsPage.performSearch(productKey);
            boolean items = AccountsPage.isSearchSuccessful();
            Assert.assertTrue(items);
            System.out.println("TestCase -004 has been passed");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



}

