package screenShotsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import library.Reusability;

public class TestScreenShots1 {

    @Test
    public void Browser() throws Exception {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://auth.hollandandbarrett.com/u/login");

        Reusability.capturedScreenShot(driver, "A. Launch Application - TakeScreenShot");

        driver.findElement(By.id("username")).sendKeys("kkirthi@gmail.com");

        driver.findElement(By.name("password")).sendKeys("SaiK@2005");

        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@name='action']")).click();

        Reusability.capturedScreenShot(driver, "B. Click Sign In Button - TakeScreenShot");

        driver.quit();
    }
}