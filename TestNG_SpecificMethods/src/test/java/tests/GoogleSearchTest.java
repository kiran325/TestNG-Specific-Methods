package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test
    public void testGoogleTitle() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
    }

    @Test
    public void testSearchFunctionality() {
        driver.findElement(By.name("q")).sendKeys("TestNG in Selenium");
        driver.findElement(By.name("q")).submit();
        System.out.println("Performed search");
    }

    @Test(dependsOnMethods = "testSearchFunctionality")
    public void testResultsPage() {
        boolean isDisplayed = driver.findElement(By.id("search")).isDisplayed();
        System.out.println("Search results displayed: " + isDisplayed);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
