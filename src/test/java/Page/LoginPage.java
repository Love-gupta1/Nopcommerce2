package Page;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage
{
   static   WebDriver driver;
   public static  String path;
    By Email = By.xpath("//input[@name='Email']");
    By password = By.xpath("//input[@name='Password']");
    By submit = By.xpath("//button[contains(@class,'login-button')]");
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void login() throws IOException
    {

        path = System.getProperty("user.dir") + "//src//test//java//TestData//nopcommerce.xlsx";
        FileInputStream prop1 = null;
        try{
            prop1 = new FileInputStream(path);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String username = sheet.getRow(1).getCell(0).getStringCellValue();
        String  pwd = sheet.getRow(1).getCell(1).getStringCellValue();

        driver.manage().window().maximize();
        driver.findElement(Email).clear();
        driver.findElement(Email).sendKeys(username);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(submit).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='content-header']/h1")).getText(), "Dashboard");
    }
}


