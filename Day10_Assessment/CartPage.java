package POMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By productName =
            By.className("inventory_item_name");

    By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    public String getProductName() {

        return driver.findElement(productName)
                     .getText();
    }

    public void clickCheckout() {

        driver.findElement(checkoutButton)
              .click();
    }
}
