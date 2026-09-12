package pageObjectModel.NopCommerce.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjectModel.NopCommerce.Pages.LoginNopCommerce;
import pageObjectModel.helper.BrowserFactory;

public class ExecuteNopCommerce {

    @Test
    public void TestValidLogin() {

        WebDriver driver = BrowserFactory.BrowserOptions(
                "Chrome",
                "https://admin-demo.nopcommerce.com/login");

        LoginNopCommerce loginPageNopCommerce =
                PageFactory.initElements(driver, LoginNopCommerce.class);

        loginPageNopCommerce.login_NopCommerce(
                "admin@yourstore.com",
                "admin");

        // driver.quit();

    }

}