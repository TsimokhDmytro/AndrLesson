package SeleniumLessons.Lesson6.Pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(15);

    public BasePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, TIMEOUT);
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
        waitForCurrentUrl(url);
    }

    /**
     * This method returns WebElement. This method accepts parameter String "xpath"
     */
    public WebElement findElementBy(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * This method returns WebElement. This method accepts parameter WebElement "element"
     */
    public WebElement findElementBy(WebElement element) {
        return driver.findElement((By) element);
    }

    /**
     * This method returns List<WebElement>. This method accepts parameter String "xpath"
     */
    public List<WebElement> findElementsBy(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    /**
     * This method returns List<WebElement>. This method accepts parameter WebElement "element"
     */
    public List<WebElement> findElementsBy(WebElement element) {
        return driver.findElements((By)element);
    }

//    /**
//     * This method returns clickable WebElement by xpath. This method uses methods "waitForVisibleElement(xpath)"
//     * and "findElement(By.xpath(xpath))". This method accepts string parameter "xpath"
//     */
//    public WebElement findClickableElementBy(String xpath) {
//        waitForClickableElement(xpath);
//        return driver.findElement(By.xpath(xpath));
//    }

//    /**
//     * This method returns clickable WebElement by element. This method uses methods "waitForVisibleElement(element)"
//     * and "findElement((By)element)". This method accepts WebElement parameter "element"
//     */
//    public WebElement findClickableElementBy(WebElement element) {
//        waitForClickableElement(element);
//        return driver.findElement((By) element);
//    }

//    /**
//     * This method returns visible List<WebElement> by xpath. This method uses method "findElements(By.xpath(xpath))"
//     * and accepts string parameter "xpath"
//     */
//    public List<WebElement> findVisibleElementsBy(String xpath) {
//        waitForVisibilityOfAllElements(xpath);
//        return driver.findElements(By.xpath(xpath));
//    }

//    /**
//     * This method returns visible List<WebElement> by xpath. This method uses method "findElements(By.xpath(xpath))"
//     * and accepts string parameter "xpath"
//     */
//    public List<WebElement> findVisibleElementsBy(WebElement element) {
//        waitForVisibilityOfAllElements(element);
//        return driver.findElements((By) element);
//    }

//    /**
//     * This method returns WebElement by xpath. This method uses methods "waitForVisibleElement(xpath)",
//     * waitForClickableElement(xpath) and "findElementBy(xpath)". This method accepts string parameter "xpath"
//     */
//    public WebElement getElement(String xpath) {
//        waitForVisibleElement(xpath);
//        return findElementBy(xpath);
//    }
//    /**
//     * This method returns WebElement by WebElement. This method uses methods "waitForVisibleElement(element)",
//     * waitForClickableElement(element) and "findElementBy(element)". This method accepts WebElement parameter "element"
//     */
//    public WebElement getElement(WebElement element) {
//        waitForVisibleElement(element);
//        waitForClickableElement(element);
//        return findVisibleElementBy(element);
//    }
//    /**
//     * This method returns string text of the element by xpath. This method uses method "findClickableElementBy(xpath)"
//     * which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))" and accepts string parameter
//     * "xpath"
//     */
//    public String getTextElement(String xpath) {
//        return findVisibleElementBy(xpath).getText();
//    }
//    /**
//     * This method returns string attribute of the element. This method uses method "findClickableElementBy(xpath)"
//     * which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))". This method accepts
//     * string parameters "xpath" and "attributeName"
//     */
//    public String getTextElement(WebElement element) {
//        return findVisibleElementBy(element).getText();
//    }
//    /**
//     * This method returns string attribute of the element. This method uses method "findClickableElementBy(xpath)"
//     * which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))". This method accepts
//     * string parameters "xpath" and "attributeName"
//     */
//    public String getAttribute(String xpath, String attributeName) {
//        return waitForClickableElement(xpath).getAttribute(attributeName);
//    }

    /**
     * This method waits for a clickable WebElement and returns it. This method accepts parameter String "xpath"
     */
    public WebElement waitForClickableElement(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * This method waits for a clickable WebElement and returns it. This method accepts parameter WebElement "element"
     */
    public WebElement waitForClickableElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return driver.findElement((By) element);
    }

    /**
     * This method waits for a visible WebElement and returns it. This method accepts parameter String "xpath"
     */
    public WebElement waitForVisibleElement(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * This method waits for a visible WebElement and returns it. This method accepts parameter WebElement "element"
     */
    public WebElement waitForVisibleElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return driver.findElement((By) element);
    }

    /**
     * This method waits for a visibility all elements of WebElement and returns List<WebElement>. This method accepts
     * parameter String "xpath"
     */
    public List<WebElement> waitForVisibilityOfAllElements(String xpath) {
        Allure.step("Waiting for visibility of all elements By %s" + xpath,
                () -> wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))));
        return driver.findElements(By.xpath(xpath));
    }

    /**
     * This method waits for a visibility all elements of WebElement and returns List<WebElement>. This method accepts
     * parameter WebElement "element"
     */
    public List<WebElement> waitForVisibilityOfAllElements(WebElement element) {
        Allure.step("Waiting for visibility of all elements By %s" + element,
                () -> wait.until(ExpectedConditions.visibilityOfAllElements(element)));
        return driver.findElements((By)element);
    }

    /**
     * This method waits for a selected WebElement and returns it. This method accepts parameter String "xpath"
     */
    public WebElement waitForElementToBeSelected(String xpath) {
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * This method waits for a selected WebElement and returns it. This method accepts parameter WebElement "element"
     */
    public WebElement waitForElementToBeSelected(WebElement element) {
        wait.until(ExpectedConditions.elementToBeSelected(element));
        return driver.findElement((By) element);
    }

    /**
     * This method waits for invisibility WebElement and returns it. This method accepts parameter String "xpath"
     */
    public WebElement waitForInvisibilityElement(String xpath) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * This method waits for invisibility WebElement and returns it. This method accepts the WebElement parameter "element"
     */
    public WebElement waitForInvisibilityElement(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
        return driver.findElement((By)element);
    }

    /**
     * This method waits for invisibility all elements of WebElement and returns List<WebElement>. This method accepts
     * parameter WebElement "element"
     */
    public List<WebElement> waitForInvisibilityOfAllElements(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
        return driver.findElements((By)element);
    }
    /**
     * This method returns "true" if the current page will be expected url. This method accepts parameter String "url"
     */
    public boolean waitForCurrentUrl(String url) {
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    /**
     * This method switches on a new tab
     */
    public BasePage switchNewTab() {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
        return this;
    }

    /**
     * This method switches on the tab
     */
    public BasePage switchOnTab(int index) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(index));
        return this;
    }

    /**
     * This method imitates press the key "ENTER" of a keyboard
     */
    public void pressEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

        /**
     * This method returns "true" if the element will be displayed on the page. This method uses method
     * "waitForVisibleElement(element)" and accepts parameter WebElement "element"
     */
    public boolean assertIsDisplayedElement(WebElement element) {
        return waitForClickableElement(element).isDisplayed();
    }

    /**
     * This method returns "true" if the element will be displayed on the page. This method uses method
     * "waitForVisibleElement(element)" and accepts parameter WebElement "element"
     */
    public boolean assertIsDisplayedElement(String xpath) {
        return waitForClickableElement(xpath).isDisplayed();
    }

    //    @Step("Assert is selected element By xpath")
//    public boolean assertIsSelectedElement(String xpath) {
//        return waitForElementToBeSelected(xpath).isSelected();
//    }

//    //    @Step("Assert is selected element By element")
//    public boolean assertIsSelectedElement(WebElement element) {
//        return waitForElementToBeSelected(element).isSelected();
//    }



//    /**
//     * This method returns true if the finding element by WebElement will not be display and returns false if finding
//     * element will be display on the page. This method uses "try" "catch" blocks with method
//     * "findClickableElementBy(element)" which used "wait.until(ExpectedConditions.elementToBeClickable(element))".
//     * This method accepts parameter WebDriver "driver" and string parameter "xpath"
//     */
//    public boolean isElementNotDisplayed(WebDriver driver, WebElement element) {
//        try {
//        waitForClickableElement(element).isDisplayed();
//        return false;
//        } catch (NoSuchElementException e) {
//            Allure.step(String.format("Actual result: element %s was found on the page, but expected result: " +
//                    "element %s was not found on the page"));
//            return true;
//        }
//    }

    /**
     * This method returns true if the finding element by xpath will not be displayed on the page and returns false if
     * finding element will be display. This method uses "try" "catch" blocks with method
     * "findClickableElementBy(xpath)" which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))".
     * This method accepts parameter WebDriver "driver" and string parameter "xpath"
     */
//    public boolean waitForInvisibilityElement(String xpath) {
//        try {
//            findElementBy(xpath).isDisplayed();
//            return false;
//        } catch (NoSuchElementException e) {
//            System.out.println("Actual result: element " + xpath + "was found on the page, but expected result: " +
//                    "element " + xpath + "was not found on the page");
//        }
//        return true;
//    }

    /**
     * This method returns ArrayList<String> attributes of any elements from list. This method uses method
     * "findListWithVisibilityOfAllElementsBy(xpath)" which used
     * "wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))))" and gets any
     * attributes by cycle "for". This method accepts string parameters "xpath" and "attributeName"
     */
    protected ArrayList<String> getAttributesAnyElementsOfTheList(String xpath, String attributeName) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> listElements = waitForVisibilityOfAllElements(xpath);
        for (int i = 0; i < listElements.size(); i++) {
            String getAttribute = listElements.get(i).getAttribute(attributeName);
            arrayList.add(getAttribute);
        }
        return arrayList;
    }
}
