package SeleniumLessons.Lesson6.helpers;

import SeleniumLessons.Lesson6.Pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class RozetkaProductPageElements extends BasePage {

    @FindBy(xpath = "//rz-view-switch/div/button[1]")
    private String btnBigTiles;
    @FindBy(xpath = "//rz-view-switch/div/button[2]")
    private WebElement btnSmallTiles;
    @FindBy(xpath = "//rz-grid/ul/li/rz-catalog-tile/app-goods-tile-default/div")
    private String listFoundProducts;
    @FindBy(xpath = "//span[@_ngcontent-rz-client-c105]")
    private String productNotFound;

//    private String btnBigTiles = "//rz-view-switch/div/button[1]";
//    private String btnSmallTiles = "//rz-view-switch/div/button[2]";
//    private String listFoundProducts = "//rz-grid/ul/li/rz-catalog-tile/app-goods-tile-default/div";
//    private String productNotFound = "//span[@_ngcontent-rz-client-c105]";
    public RozetkaProductPageElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Get btn big tiles")
    public WebElement getBtnBigTiles() {
        return findElementBy(btnBigTiles);
    }
    @Step("Get btn small tiles")
    public WebElement getBtnSmallTiles() {
        return findElementBy(btnSmallTiles);
    }
    @Step("Click btn big tiles")
    public void clickBtnBigTiles() {
        getBtnBigTiles().click();
    }
    @Step("Click btn small tiles")
    public void clickBtnSmallTiles() {
        getBtnSmallTiles().click();
    }

    public String getAttributeBtnBigTiles(String attribute) {
        return getBtnBigTiles().getAttribute(attribute);
    }

    public String getAttributeBtnSmallTiles(String attribute) {
        return getBtnSmallTiles().getAttribute(attribute);
    }

    public ArrayList<String> getAttributesAnyFoundProducts(String attribute) {
        return getAttributesAnyElementsOfTheList(listFoundProducts, attribute);
    }
    @Step("Get text that product no found")
    public String getTextProductNotFound() {
        return waitForVisibleElement(productNotFound).getText();
    }
    @Step("Is displayed btn big tiles")
    public boolean isDisplayedBigTiles() {
        waitForVisibleElement(btnBigTiles);
        return findElementBy(btnBigTiles).isDisplayed();
//        return assertIsDisplayedElement(btnBigTiles);
    }
    @Step("Is displayed btn big tiles")
    public boolean isDisplayedSmallTiles() {
        waitForVisibleElement(btnSmallTiles);
        return findElementBy(btnSmallTiles).isDisplayed();
//        return assertIsDisplayedElement(btnSmallTiles);
    }









//    /**
//     * This method returns "true" if the element will be selected. This method uses method
//     * "waitForClickableElement(xpath)" and accepts parameter String "xpath"
//     */
//    public boolean assertIsSelected(String xpath) {
//        return findElementBy(xpath).isSelected();
//    }
//    /**
//     * This method returns "true" if the element will be selected. This method uses method
//     * "waitForClickableElement(element)" and accepts parameter WebElement "element"
//     */
//    public boolean assertIsSelected(WebElement element) {
//        return findElementBy(element).isSelected();
//    }
//
//

//
//
//
//    /**
//     * This method returns "true" if the element will be enabled. This method uses method "findElementBy(xpath)"
//     * and accepts string parameter "xpath"
//     */
//    public boolean assertIsEnabled(String xpath) {
//        return findElementBy(xpath).isEnabled();
//    }
//
//    /**
//     * This method returns "true" if the element will be enabled. This method uses method "findElementBy(element)"
//     * and accepts string parameter "element"
//     */
//    public boolean assertIsEnabled(WebElement element) {
//        return findElementBy(element).isEnabled();
//    }


}
