package DropDowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ListItemsDemo {
    ChromeDriver driver;
    String url="https://testautomationpractice.blogspot.com/";
  
    @BeforeTest
    public void setup() {       
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void ChromeBrowserTest() throws Exception {
        WebElement Country_Dropdown=driver.findElement(By.id("country"));
        Select Country_list=new Select(Country_Dropdown);
        
        Country_list.selectByIndex(3);
        Thread.sleep(10000);
        Country_list.selectByVisibleText("India");
        
        WebElement option=Country_list.getFirstSelectedOption();
        String countryindex=option.getText();
        System.out.println(countryindex);
        
        List<WebElement> c_list=Country_list.getOptions();
        int total_country=c_list.size();
        System.out.println("Total country count in List:" + total_country);    
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}