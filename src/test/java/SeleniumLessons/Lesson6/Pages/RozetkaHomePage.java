package SeleniumLessons.Lesson6.Pages;

import SeleniumLessons.Lesson6.helpers.RozetkaHomePageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static io.qameta.allure.Allure.step;

public class RozetkaHomePage extends RozetkaHomePageElements {

    private static final String ROZETKA = "https://rozetka.com.ua/ua/";

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

}
