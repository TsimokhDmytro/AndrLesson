package SeleniumLessons.Lesson6.Pages;

import SeleniumLessons.Lesson6.helpers.RozetkaHomePageElements;
import org.openqa.selenium.WebDriver;


public class RozetkaHomePage extends RozetkaHomePageElements {

    private static final String ROZETKA = "https://rozetka.com.ua/ua/";

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

}
