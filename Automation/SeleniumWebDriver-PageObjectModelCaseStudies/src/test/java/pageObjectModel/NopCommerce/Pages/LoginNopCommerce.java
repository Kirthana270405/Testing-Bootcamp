package pageObjectModel.NopCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginNopCommerce {

    WebDriver driver;

    public LoginNopCommerce(WebDriver driver) {

        this.driver = driver;

    }

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginbtn;

    public void login_NopCommerce(String uname, String pass) {

        email.clear();
        email.sendKeys(uname);

        password.clear();
        password.sendKeys(pass);

        loginbtn.click();

    }

}