package radioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButtonsCountSpiceJet {
	@Test
	public void TestRadioBtn() throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[contains(text(),'round trip')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'one way')]")).click();
		Thread.sleep(5000);

		int radiobtn = driver.findElements(By.xpath("//div[contains(text(),'round trip') or contains(text(),'one way')]")).size();
		System.out.println("Number of Radio Buttons..... :" + radiobtn);
		driver.quit();

	}

}
