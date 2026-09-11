package SeleniumPackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserCommands {

    @Test(priority = 0)
    public void ChromeBrowserTest() {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }


    @Test(priority = 1)
    public void EdgeBrowserTest() {

        EdgeDriver driver = new EdgeDriver();

        driver.get("https://mvnrepository.com");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }


    @Test(priority = 2)
    public void FirefoxBrowserTest1() {

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }


    @Test(priority = 3)
    public void FirefoxBrowserTest2() {

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }


    @Test(priority = 4)
    public void FirefoxBrowserTest3() {

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.wikipedia.org");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }


    @Test(priority = 5)
    public void FirefoxBrowserTest4() {

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }


    @Test(priority = 6)
    public void FirefoxBrowserTest5() {

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }


    @Test(priority = 7)
    public void FirefoxBrowserTest6() {

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.github.com");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }


    @Test(priority = 8)
    public void FirefoxBrowserTest7() {

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.linkedin.com");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }


    @Test(priority = 9)
    public void FirefoxBrowserTest8() {

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.selenium.dev");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }


    @Test(priority = 10)
    public void FirefoxBrowserTest() {

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.microsoft.com");
        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println("Title: " + BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println("URL: " + BrowserURL);

        driver.quit();
    }
}

