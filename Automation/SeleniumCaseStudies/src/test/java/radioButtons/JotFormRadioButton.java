package radioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JotFormRadioButton {

    @Test

    public void TestRadioBtn() throws Exception {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.jotform.com/build/262511769568469?s=templates");

        Thread.sleep(5000);

        driver.findElement(By.xpath("//label[@for='input_25_0']")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//label[@for='input_25_1']")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//label[@for='input_25_2']")).click();

        Thread.sleep(5000);

        int radiobtn = driver.findElements(
                By.xpath("//input[@type='radio']")
        ).size();

        System.out.println("Number of Radio Buttons..... :" + radiobtn);

        driver.quit();

    }

}