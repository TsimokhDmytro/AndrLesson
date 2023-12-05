package SeleniumLessons.Lessons13;

import org.testng.annotations.Test;

public class Lesson14 {

   static int a;

    public void change() {
        a++;
        System.out.println(a);
        System.out.println(10%3);
    }

    @Test
    public void test2() {
        Lesson14 les1 =new Lesson14();
        Lesson14 les2 =new Lesson14();
        Lesson14 les3 =new Lesson14();
        les1.change();
        les2.change();
        les3.change();
    }
}
