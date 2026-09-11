
package javaScriptAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.Helper;

public class KSRTCAlerts {

    @Test
    public void TestLogin() throws Exception {

        WebDriver driver = Helper.startBrowser("Edge");

        // Open KSRTC login page
        driver.get("https://www.ksrtc.in/login");

        // -------------------------------------------------
        // Case 1 - Empty Email
        // -------------------------------------------------

        driver.findElement(
                By.xpath("//div[contains(@class,'payee-info-inputs')]"
                        + "//div[contains(@class,'inp-container')][1]//input")
        ).clear();

        driver.findElement(
                By.xpath("(//div[contains(@class,'auth-page')]"
                        + "//*[normalize-space()='Login'])[last()]")
        ).click();

        Thread.sleep(1000);

        String result1 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result1);

        Assert.assertTrue(result1.contains("Please Enter Email"));

        driver.findElement(
                By.xpath("//div[contains(@class,'alert')]"
                        + "//*[normalize-space()='OK']")
        ).click();


        // -------------------------------------------------
        // Case 2 - Empty Phone
        // -------------------------------------------------

        driver.findElement(
                By.xpath("//div[contains(@class,'payee-info-inputs')]"
                        + "//div[contains(@class,'inp-container')][1]//input")
        ).sendKeys("kkirthi@gmail.com");

        driver.findElement(
                By.xpath("//div[contains(@class,'payee-info-inputs')]"
                        + "//div[contains(@class,'inp-container')][3]//input")
        ).clear();

        driver.findElement(
                By.xpath("(//div[contains(@class,'auth-page')]"
                        + "//*[normalize-space()='Login'])[last()]")
        ).click();

        Thread.sleep(1000);

        String result2 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result2);

        Assert.assertTrue(result2.contains("Please Enter Phone"));

        driver.findElement(
                By.xpath("//div[contains(@class,'alert')]"
                        + "//*[normalize-space()='OK']")
        ).click();


        // -------------------------------------------------
        // Case 3 - Empty Password
        // -------------------------------------------------

        driver.findElement(
                By.xpath("//div[contains(@class,'payee-info-inputs')]"
                        + "//div[contains(@class,'inp-container')][3]//input")
        ).sendKeys("8074316435");

        driver.findElement(
                By.xpath("//div[contains(@class,'payee-info-inputs')]"
                        + "//div[contains(@class,'inp-container')][4]//input")
        ).clear();

        driver.findElement(
                By.xpath("(//div[contains(@class,'auth-page')]"
                        + "//*[normalize-space()='Login'])[last()]")
        ).click();

        Thread.sleep(1000);

        String result3 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result3);

        Assert.assertTrue(result3.contains("Please Enter Password"));

        driver.findElement(
                By.xpath("//div[contains(@class,'alert')]"
                        + "//*[normalize-space()='OK']")
        ).click();


        // -------------------------------------------------
        // Case 4 - Terms and Conditions
        // -------------------------------------------------

        driver.findElement(
                By.xpath("//div[contains(@class,'payee-info-inputs')]"
                        + "//div[contains(@class,'inp-container')][4]//input")
        ).sendKeys("wrongpassword");

        driver.findElement(
                By.xpath("(//div[contains(@class,'auth-page')]"
                        + "//*[normalize-space()='Login'])[last()]")
        ).click();

        Thread.sleep(1000);

        String result4 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result4);

        Assert.assertTrue(
                result4.contains("You need to agree to KSRTC's")
        );

        driver.findElement(
                By.xpath("//div[contains(@class,'alert')]"
                        + "//*[normalize-space()='AGREE']")
        ).click();


        // -------------------------------------------------
        // Case 5 - Login after agreeing to Terms
        // -------------------------------------------------

        driver.findElement(
                By.xpath("(//div[contains(@class,'auth-page')]"
                        + "//*[normalize-space()='Login'])[last()]")
        ).click();

        Thread.sleep(3000);

        String result5 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result5);

        // The website may proceed to the home page
        // instead of showing the security verification message.


        // -------------------------------------------------
        // Case 6 - Home Page
        // -------------------------------------------------

        driver.get("https://www.ksrtc.in/");

        Thread.sleep(3000);

        String result6 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Result:");
        System.out.println(result6);

        Assert.assertTrue(result6.contains("Home"));

        driver.quit();
    }
}

