package Test;

import java.io.IOException;

public class LoginTest extends BaseClass {
    public static void main(String[] args) throws InterruptedException, IOException {
        setup();
        pageFactory.loginPage().login();
        pageFactory.discount().discount();
    }
}

