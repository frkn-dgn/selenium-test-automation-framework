package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartButton = By.className("shopping_cart_link");
    By productName = By.className("inventory_item_name");

    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void openCart() {
        driver.findElement(cartButton).click();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }
}