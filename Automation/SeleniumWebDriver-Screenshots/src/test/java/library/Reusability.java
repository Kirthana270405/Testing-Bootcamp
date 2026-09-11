package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Reusability {
	public static void capturedScreenShot(WebDriver driver, String screenShotName) {
		try {
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,  new File("./ScreenShots/" +screenShotName +".png"));
			System.out.println("Captured ScreenShot-By Selenium WebDriver");
		} catch (Exception e) {
			System.out.println("Exception While Taking Screen Shot" +e.getMessage());
			
		}
	}
}


