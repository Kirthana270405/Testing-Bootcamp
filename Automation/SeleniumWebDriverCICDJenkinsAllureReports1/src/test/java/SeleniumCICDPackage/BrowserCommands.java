package SeleniumCICDPackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserCommands {

    @Test(priority = 0)
    public void ChromeBrowser1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test(priority = 1)
    public void EdgeBrowser1() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test(priority = 2)
    public void FirefoxBrowser1() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test(priority = 3)
    public void FirefoxBrowser2() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test(priority = 4)
    public void EdgeBrowser2() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test(priority = 5)
    public void FirefoxBrowser3() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test(priority = 6)
    public void EdgeBrowser3() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.microsoft.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test(priority = 7)
    public void FirefoxBrowser4() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.github.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test(priority = 8)
    public void EdgeBrowser4() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.linkedin.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test(priority = 9)
    public void EdgeBrowser5() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.naukri.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test(priority = 10)
    public void EdgeBrowser6() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.indeed.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}