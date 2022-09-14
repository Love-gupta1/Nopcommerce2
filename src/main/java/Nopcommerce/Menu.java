package Nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu {
    WebDriver driver;
    By Promotions = new By.ByLinkText("Promotions");

    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    public void menu() {
        driver.findElement(Promotions).click();
    }

}

