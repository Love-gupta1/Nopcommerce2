package Page;
import org.openqa.selenium.WebDriver;
public class PageFactory {
    WebDriver driver;
    private LoginPage loginPage;
    private Discount discount;

    public PageFactory(WebDriver driver)
    {
        this.driver = driver;
    }
    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public Discount discount() {
        if (discount == null) {
            discount = new Discount(driver);
        }
        return discount;
    }
}


