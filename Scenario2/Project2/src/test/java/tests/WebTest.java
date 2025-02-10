package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebTest { 
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        driver.get("http://the-internet.herokuapp.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "The Internet", "Title does not match!");
    }

    @Test(priority = 2)
    public void verifyCheckboxPage() {
        driver.findElement(By.linkText("Checkboxes")).click();
        WebElement heading = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(heading.getText(), "Checkboxes", "Heading does not match!");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        Assert.assertFalse(checkbox1.isSelected(), "Checkbox 1 should be unchecked!");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 should be checked!");
    }

    @Test(priority = 3)
    public void testFileUpload() {
        driver.navigate().back();
        driver.findElement(By.linkText("File Upload")).click();
        
        WebElement heading = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(heading.getText(), "File Uploader", "Heading does not match!");

        WebElement uploadButton = driver.findElement(By.id("file-upload"));
        uploadButton.sendKeys("C:\\Users\\91747\\OneDrive\\Desktop\\results.txt"); // Provide a valid file path

        driver.findElement(By.id("file-submit")).click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}