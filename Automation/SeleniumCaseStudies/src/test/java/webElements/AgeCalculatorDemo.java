package webElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgeCalculatorDemo {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        String baseURL = "https://www.easycalculation.com/date-day/age-calculator.php";

        driver.navigate().to(baseURL);
        driver.manage().window().maximize();

        Thread.sleep(2000);

        // Retrieve all links
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println("No. of links: " + allLinks.size());

        for (WebElement ele : allLinks) {
            System.out.println("Displayed: " + ele.isDisplayed());
            System.out.println("Enabled: " + ele.isEnabled());
            System.out.println("Href: " + ele.getAttribute("href"));
            System.out.println("-----------------------------");
        }

        // Enter Date of Birth
        driver.findElement(By.id("i21")).sendKeys("27");
        driver.findElement(By.id("i22")).sendKeys("04");
        driver.findElement(By.id("i23")).sendKeys("2005");

        // Find Calculate button
        WebElement calculateButton =
                driver.findElement(By.xpath("//input[@name='but']"));

        // Scroll button into the center of the screen
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                calculateButton
        );

        Thread.sleep(500);

        // Click Calculate
        calculateButton.click();

        Thread.sleep(1000);

        // Retrieve calculated values
        String age = driver.findElement(By.id("r1"))
                .getAttribute("value");

        System.out.println("\nYour age is: " + age);

        String ageInDays = driver.findElement(By.id("r4"))
                .getAttribute("value");

        System.out.println("Your age in days: " + ageInDays);

        String ageInHours = driver.findElement(By.name("val2"))
                .getAttribute("value");

        System.out.println("Your age in hours: " + ageInHours);

        String ageInMinutes = driver.findElement(By.id("r2"))
                .getAttribute("value");

        System.out.println("Your age in minutes: " + ageInMinutes);

        driver.quit();
    }
}