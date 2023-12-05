package SeleniumLessons.Lesson6.Tests;

import SeleniumLessons.Lesson6.helpers.RozetkaHomePageElements;
import SeleniumLessons.Lesson6.helpers.RozetkaProductPageElements;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaTestBtnTiles extends TestInit {

    @Test
    @Description("Checking changes after clicked to buttons big tiles and small tiles of displaying list" +
            "found products")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Tsimokh D. seniorQA")
    public void checkBtnTiles() {

        RozetkaHomePageElements homePage = PageFactory.initElements(driver, RozetkaHomePageElements.class);

        homePage.openRozetka()
                .inputInSearchField("cars");

        RozetkaProductPageElements productPage = PageFactory.initElements(driver,RozetkaProductPageElements.class);

//        Assert.assertTrue(productPage.isDisplayedBigTiles());
//        Assert.assertTrue(productPage.isDisplayedSmallTiles());
//        Assert.assertTrue(productPage.getAttributeBtnSmallTiles("class").contains("state_active"));
//        Assert.assertFalse(productPage.getAttributeBtnBigTiles("class").contains("state_active"));
        Assert.assertTrue(productPage.getAttributesAnyFoundProducts("data-tile").contains("small"));

        productPage.clickBtnBigTiles();

        Assert.assertTrue(productPage.getAttributeBtnBigTiles("class").contains("state_active"));
        Assert.assertFalse(productPage.getAttributeBtnSmallTiles("class").contains("state_active"));
        Assert.assertTrue(productPage.getAttributesAnyFoundProducts("data-tile").contains("big"));

        productPage.clickBtnSmallTiles();

        Assert.assertTrue(productPage.getAttributeBtnSmallTiles("class").contains("state_active"));
        Assert.assertFalse(productPage.getAttributeBtnBigTiles("class").contains("state_active"));
        Assert.assertTrue(productPage.getAttributesAnyFoundProducts("data-tile").contains("small"));
    }
}
