package SeleniumLessons.Lesson6.Tests;

import SeleniumLessons.Lesson6.helpers.RozetkaHomePageElements;
import SeleniumLessons.Lesson6.helpers.RozetkaProductPageElements;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSearchFieldNegative extends TestInit {

    @DataProvider(parallel = true)
    public Object[][] setUp() {
        return new Object[][]{
                {"zdgsfgdfhjr"}, {"ыавркоyвапр"}, {"2565465656566"},
                {"@@@@"}, {"........"},
                {"%%%%%%"},
                {"******"}, {"}}}}}}"}, {")))))"}, {"((((("}, {"!!!!!"},
                {"+++++"}, {"-----"}, {"____"},
                {"$$$$"}, {"#####"}, {"&&&&&"}, {"^^^^^"}, {">>>>>"}, {"<<<<"}, {";;;;;"}, {":::::"}, {"  "}
////                {"====="},{",,,,,,,"},{""}
        };
    }

    String expectedResultText = "За заданими параметрами не знайдено жодної моделі";

    @Test(dataProvider = "setUp")
    @Description("Check search field with invalid data")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Tsimokh D. seniorQA")
    public void checkSearchFieldNegative(String invalidText) {

        RozetkaHomePageElements homePage = new RozetkaHomePageElements(getDriver());

        homePage.openRozetka()
                .inputInSearchField(invalidText);

        RozetkaProductPageElements productPage = new RozetkaProductPageElements(getDriver());

        Assert.assertEquals(productPage.getTextProductNotFound(), expectedResultText);
    }
}

