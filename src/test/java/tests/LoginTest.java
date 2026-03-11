package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
        waitForSeconds(4);
    }
    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();

        Assert.assertTrue(errorMessage.contains("Username and password do not match"));

        waitForSeconds(4);

    }

}