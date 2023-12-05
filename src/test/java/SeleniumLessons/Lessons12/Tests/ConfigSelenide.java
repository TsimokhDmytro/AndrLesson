//package SeleniumLessons.Lessons12.Tests;
//
//import com.codeborne.selenide.Browser;
//
//import java.lang.module.Configuration;
//import java.util.Optional;
//
//public class ConfigSelenide {
//    public BrowserType configBrowser() {
//        Optional<String> browser = Optional.ofNullable(System.getProperty("browser"));
//
//        if (browser.isEmpty() || browser.get().equals("chrome")) {
//            Configuration.browser = BrowserType.CHROME;
//        } else if (browser.get().equals("firefox")) {
//            return BrowserType.FIREFOX; {
//            }  else if (browser.get().equals("safari")) {
//                return BrowserType.SAFARI;
//            }
//        }
//    }
//}
//
//
