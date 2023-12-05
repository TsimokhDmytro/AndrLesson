package SeleniumLessons.Lesson6.Tests;import SeleniumLessons.Lesson6.helpers.RozetkaHomePageElements;import SeleniumLessons.Lesson6.helpers.RozetkaProductPageElements;import io.qameta.allure.Owner;import io.qameta.allure.Severity;import io.qameta.allure.SeverityLevel;import org.testng.Assert;import org.testng.annotations.DataProvider;import org.testng.annotations.Test;public class TestSearchFieldNegative extends TestInit {    String expectedResultText = "По заданным параметрам не найдена ни одна модель";    @DataProvider(parallel = true)    public Object[][] setUp() {        return new Object[][]{                { "zdgsfgdfhjr"}, {"dvscv562cvv"}, {"2565465656566"},                {"@@@@"}, {"........"}, {"%%%%%%"}, {"******"}, {"}}}}}}"}, {")))))"}, {"((((("}, {"!!!!!"},                {"+++++"}, {"-----"}, {"____"},                {"$$$$"}, {"#####"}, {"&&&&&"}, {"^^^^^"}, {">>>>>"}, {"<<<<"}, {";;;;;"}, {":::::"}, {"  "},                {"====="},{",,,,,,,"},{""}        };    }    @Test(dataProvider = "setUp", description = "Check search field with invalid data")    @Severity(SeverityLevel.CRITICAL)    @Owner("Tsimokh D. seniorQA")    public void checkSearchFieldNegative(String invalidText, String invalidPassword) {        RozetkaHomePageElements homePageElements = new RozetkaHomePageElements(driver);        homePageElements.openRozetka()                .inputInSearchField(invalidText)                .inputInSearchField(invalidPassword);        RozetkaProductPageElements productPage = new RozetkaProductPageElements(driver);        Assert.assertEquals(productPage.getTextProductNotFound(), expectedResultText);    }}