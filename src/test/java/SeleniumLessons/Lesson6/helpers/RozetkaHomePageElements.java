package SeleniumLessons.Lesson6.helpers;

import SeleniumLessons.Lesson6.Pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.qameta.allure.Allure.step;

public class RozetkaHomePageElements extends BasePage {

    private static final String ROZETKA = "https://rozetka.com.ua/ua/";
    private static final String SEARCH_FIELD = "//input[@name='search']";

//    @FindBy(xpath = "//input[@name='search']")
//    public String SEARCH_FIELD;

    public RozetkaHomePageElements(WebDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
    }
    @Step("Go to rozetka.com.ua")
    public RozetkaHomePageElements openRozetka() {
        openUrl(ROZETKA);
        waitForCurrentUrl(ROZETKA);
        return this;
    }
    public void inputInSearchField(String productName) {
        step(String.format("Input in search field %s", productName), () -> {
            waitForClickableElement(SEARCH_FIELD).sendKeys(productName);
            pressEnter();
        });
    }
}
