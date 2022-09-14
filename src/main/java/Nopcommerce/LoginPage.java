package Nopcommerce;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   static   WebDriver driver;
    By Email = By.xpath("//input[@href='email valid']");
    By password = By.name("password");
    By submit = By.xpath("//button[@class='button-1 login-button']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void login() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("admin");
        driver.findElement(By.xpath("//div[@class='buttons']/button")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='content-header']/h1")).getText(), "Dashboard");

    }

}


