package multipleFrames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.Helper;

public class MultipleFramesDemo {

    @Test
    public void Frames() throws Exception {

        // 1. Launch Chrome browser
        WebDriver driver = Helper.startBrowser("GC");

        // 2. Navigate to Selenium iFrame practice page
        driver.get("https://demoqa.com/frames");

        Thread.sleep(5000);


        // 3. Identify the available frames
        List<WebElement> totalFrames =
                driver.findElements(By.tagName("iframe"));

        System.out.println("Number of Frames: " + totalFrames.size());


        // 4. Switch to the first frame using WebElement
        WebElement firstFrame =
                driver.findElement(By.id("frame1"));

        driver.switchTo().frame(firstFrame);

        System.out.println("Switched to First Frame");


        // 5. Perform an action inside the frame
        String frameText =
                driver.findElement(By.id("sampleHeading")).getText();

        System.out.println("Text inside First Frame: " + frameText);


        // 6. Return to the main page using defaultContent()
        driver.switchTo().defaultContent();

        System.out.println("Returned to Main Page");


        // 7. Switch to another frame using INDEX
        driver.switchTo().frame(1);

        System.out.println("Switched to Second Frame");


        // 8. Return to the main page
        driver.switchTo().defaultContent();

        System.out.println("Returned to Main Page");


        // 9. Navigate to the DemoQA Nested Frames page
        driver.navigate().to(
                "https://demoqa.com/nestedframes"
        );

        Thread.sleep(5000);


        // 10. Switch to the Parent Frame
        driver.switchTo().frame("frame1");

        System.out.println("Switched to Parent Frame");


        // 11. Switch to the Child Frame
        WebElement childFrame =
                driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(childFrame);

        System.out.println("Switched to Child Frame");


        // 12. Validate the text inside the Child Frame
        String childText =
                driver.findElement(By.tagName("p")).getText();

        System.out.println("Child Frame Text: " + childText);

        Assert.assertTrue(
                childText.contains("Child Iframe")
        );


        // 13. Use parentFrame() to return to the Parent Frame
        driver.switchTo().parentFrame();

        System.out.println("Returned to Parent Frame");


        // 14. Validate the Parent Frame text
        String parentText =
                driver.findElement(By.tagName("body")).getText();

        System.out.println("Parent Frame Text: " + parentText);

        Assert.assertTrue(
                parentText.contains("Parent frame")
        );


        // 15. Use defaultContent()
        driver.switchTo().defaultContent();

        System.out.println("Returned to Main Page");


        // 16. Verify that you are back on the Main Page
        String mainPageTitle = driver.getTitle();

        System.out.println("Main Page Title: " + mainPageTitle);

        Assert.assertEquals(
                mainPageTitle,
                "demosite"
        );


        // Close the browser
        driver.quit();
    }
}

