//package stepDefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import java.time.Duration;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//
//import java.util.concurrent.TimeUnit;
//
//public class CapstoneSteps {
//    WebDriver driver;
//
//
//
//    @Before
//    public void setup() {
//        // Set the correct path to ChromeDriver
//        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver-win64\\chromedriver.exe");
//
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//
//
//    @Given("I launch the application")
//    public void i_launch_the_application() {
//        driver.get("http://the-internet.herokuapp.com/");
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//
//
//    @Then("I verify the title of the page")
//    public void i_verify_the_title_of_the_page() {
//        String title = driver.getTitle();
//        Assert.assertEquals(title, "The Internet", "Title did not match!");
//    }
//
//    @Given("I click on {string}")
//    public void i_click_on(String linkText) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased wait time
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
//        element.click();
//    }
//
//    @Then("I verify the text on the page as {string}")
//    public void i_verify_the_text_on_the_page_as(String expectedText) {
//        WebElement textElement = driver.findElement(By.tagName("h3"));
//        Assert.assertEquals(textElement.getText(), expectedText, "Text did not match!");
//    }
//
////    @When("I select {string} from the dropdown")
////    public void i_select_from_the_dropdown(String option) {
////        WebElement dropdown = driver.findElement(By.id("dropdown"));
////        dropdown.findElement(By.xpath("//option[text()='" + option + "']")).click();
////    }
//
//
//    @When("I select {string} from the dropdown")
//    public void i_select_from_the_dropdown(String option) {
//        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
//        dropdown.selectByVisibleText(option);
//    }
//
//
//    @Then("I confirm {string} is selected")
//    public void i_confirm_is_selected(String expectedOption) {
//        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
//        WebElement selectedOption = dropdown.getFirstSelectedOption();
//        Assert.assertEquals(selectedOption.getText(), expectedOption, "Dropdown selection mismatch!");
//    }
//
//    @Then("I verify {string} hyperlink is present")
//    public void i_verify_hyperlink_is_present(String linkText) {
//        WebElement link = driver.findElement(By.linkText(linkText));
//        Assert.assertTrue(link.isDisplayed(), "Link " + linkText + " is not present!");
//    }
//
//    @Given("I navigate back to Home Page")
//    public void i_navigate_back_to_home_page() {
//        driver.navigate().to("http://the-internet.herokuapp.com/");
//    }
//
//}

//
//
//package stepDefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//
//public class CapstoneSteps {
//    WebDriver driver;
//
//    @Before
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver-win64\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//    }
//
//    @Given("I launch the application")
//    public void i_launch_the_application() {
//        driver.get("http://the-internet.herokuapp.com/");
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    @Then("I verify the title of the page")
//    public void i_verify_the_title_of_the_page() {
//        String title = driver.getTitle();
//        Assert.assertEquals(title, "The Internet", "Title did not match!");
//    }
//
//    @Given("I click on {string}")
//    public void i_click_on(String linkText) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased timeout
//
//        try {
//            List<WebElement> links = driver.findElements(By.tagName("a"));
//            System.out.println("Available links on page:");
//            for (WebElement link : links) {
//                System.out.println(" - " + link.getText());
//            }
//
//            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//            System.out.println("Number of iframes found: " + iframes.size());
//
//            if (!iframes.isEmpty()) {
//                driver.switchTo().frame(0);
//                System.out.println("Switched to iframe");
//            }
//
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//
//            WebElement element;
//            try {
//                element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
//            } catch (Exception e) {
//                System.out.println("Full link text not found. Trying partial link text.");
//                element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(linkText)));
//            }
//
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//
//            try {
//                element.click();
//            } catch (Exception e) {
//                System.out.println("Normal click failed. Trying JavaScript click.");
//                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error clicking on link: " + linkText);
//            e.printStackTrace();
//            Assert.fail("Failed to click on link: " + linkText);
//        }
//    }
//
//
//
//    @Then("I verify the text on the page as {string}")
//    public void i_verify_the_text_on_the_page_as(String expectedText) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
//        Assert.assertEquals(textElement.getText(), expectedText, "Text did not match!");
//    }
//
//    @When("I select {string} from the dropdown")
//    public void i_select_from_the_dropdown(String option) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dropdown")));
//        Select dropdown = new Select(dropdownElement);
//        dropdown.selectByVisibleText(option);
//    }
//
//    @Then("I confirm {string} is selected")
//    public void i_confirm_is_selected(String expectedOption) {
//        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
//        WebElement selectedOption = dropdown.getFirstSelectedOption();
//        Assert.assertEquals(selectedOption.getText(), expectedOption, "Dropdown selection mismatch!");
//    }
//
//    @Then("I verify {string} hyperlink is present")
//    public void i_verify_hyperlink_is_present(String linkText) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
//        Assert.assertTrue(link.isDisplayed(), "Link " + linkText + " is not present!");
//    }
//
//    @Given("I navigate back to Home Page")
//    public void i_navigate_back_to_home_page() {
//        driver.navigate().to("http://the-internet.herokuapp.com/");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.titleIs("The Internet"));
//    }




package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CapstoneSteps {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Given("I launch the application")
    public void i_launch_the_application() {
        driver.get("http://the-internet.herokuapp.com/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Then("I verify the title of the page")
    public void i_verify_the_title_of_the_page() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "The Internet", "Title did not match!");
    }

//    @Given("I click on {string}")
//    public void i_click_on(String linkText) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased timeout
//
//        try {
//            List<WebElement> links = driver.findElements(By.tagName("a"));
//            System.out.println("Available links on page:");
//            for (WebElement link : links) {
//                System.out.println(" - " + link.getText());
//            }
//
//            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//            System.out.println("Number of iframes found: " + iframes.size());
//
//            if (!iframes.isEmpty()) {
//                driver.switchTo().frame(0);
//                System.out.println("Switched to iframe");
//            } else {
//                System.out.println("No iframes found, proceeding with normal click.");
//            }
//
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//
//            WebElement element;
//            try {
//                element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
//            } catch (Exception e) {
//                System.out.println("Full link text not found. Trying partial link text.");
//                element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(linkText)));
//            }
//
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//            wait.until(ExpectedConditions.elementToBeClickable(element)); // Ensure element is clickable
//
//            try {
//                element.click();
//            } catch (Exception e) {
//                System.out.println("Normal click failed. Trying JavaScript click.");
//                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//            }
//
//            // After clicking, switch back to the main content if needed
//            driver.switchTo().defaultContent();
//
//        } catch (Exception e) {
//            System.out.println("Error clicking on link: " + linkText);
//            e.printStackTrace();
//            Assert.fail("Failed to click on link: " + linkText + " | Exception: " + e.getMessage());
//        }
//    }



    @Given("I click on {string}")
    public void i_click_on(String linkText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

            List<WebElement> links = driver.findElements(By.tagName("a"));
            for (WebElement link : links) {
                System.out.println(" - " + link.getText());
            }

            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            if (!iframes.isEmpty()) {
                driver.switchTo().frame(0);
            }

            WebElement element;
            try {
                element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
            } catch (Exception e) {
                element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(linkText)));
            }

            if (element == null) {
                element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + linkText + "')]")));
            }

            js.executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.visibilityOf(element));

            try {
                element.click();
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", element);
            }

            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(element).click().perform();
            } catch (Exception e) {}

            driver.switchTo().defaultContent();

        } catch (Exception e) {
            Assert.fail("Failed to click on link: " + linkText + " | Exception: " + e.getMessage());
        }
    }


    @Then("I verify the text on the page as {string}")
    public void i_verify_the_text_on_the_page_as(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        Assert.assertEquals(textElement.getText(), expectedText, "Text did not match!");
    }

    @When("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dropdown")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(option);
    }

    @Then("I confirm {string} is selected")
    public void i_confirm_is_selected(String expectedOption) {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), expectedOption, "Dropdown selection mismatch!");
    }

    @Then("I verify {string} hyperlink is present")
    public void i_verify_hyperlink_is_present(String linkText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
        Assert.assertTrue(link.isDisplayed(), "Link " + linkText + " is not present!");
    }

    @Given("I navigate back to Home Page")
    public void i_navigate_back_to_home_page() {
        driver.navigate().to("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs("The Internet"));
    }
}
