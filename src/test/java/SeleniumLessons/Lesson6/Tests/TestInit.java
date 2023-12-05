package SeleniumLessons.Lesson6.Tests;

import SeleniumLessons.Lesson6.Pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.*;

public class TestInit {

    protected WebDriver driver;
//    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeClass
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TSIMOKH\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

//        chromeOptions.addArguments("--headless");


//        driver.set(new ChromeDriver(chromeOptions));
        driver.manage().window().maximize();
    }

//    public WebDriver getDriver() {
//        return driver.get();
//    }

    @AfterMethod
    public void closeBrowse() {
//        getDriver().quit();
    this.driver.quit();
    }
}
