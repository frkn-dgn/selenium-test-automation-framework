package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        waitForSeconds(4);

        ProductPage productPage = new ProductPage(driver);

        productPage.addProductToCart();
        waitForSeconds(4);
        productPage.openCart();

        String productName = productPage.getProductName();

        Assert.assertEquals(productName, "Sauce Labs Backpack");
    }
}