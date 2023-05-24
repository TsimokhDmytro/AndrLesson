package SeleniumLessons.Lessons13;

import org.testng.annotations.Test;

public class Lesson14 {

    static String string = "1254+6";


    @Test
    public void changeString1() {
        System.out.println(string);
        string = "97878787";
    }

    @Test
    public void changeString2() {
        System.out.println(string);
      string = "8289";
    }
    @Test
    public void changeString3() {
        System.out.println(string);
    }
}
