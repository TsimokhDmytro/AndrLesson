package SeleniumLessons.Lesson3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lesson3HomeWork3 {

    public int factorial(int n) {
        int result = 1;
        if (n == 1 || n == 0) {
            return result;
        }
        int [] array = new int [n];
        for (int i = n; i > 0; i--){
            array [i-1] = i;
        }
        for (int elementInArr : array){
            result = result*elementInArr;
        }
        return result;
    }

    public int factorial2(int n){
        int f = 1;
        if (n==0){
            return 1;
        }else if(n<0){
            System.out.println("error");
        }else {
            for (int i = 1; i <=n; i++) {
                f *=i;
            }
        }
        return f;
    }

    public int factorial3(int n) {
        if (n == 0) {
            return 1; // Базовий випадок
        } else {
            return n * factorial(n - 1); // Крок рекурсії
        }
    }

    public int factorial4(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        int result = 1;

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }

        return result;
    }

    public int factorial5(int n){
        int f = 1;
        if(n<0){
            System.out.println("error");
        }else {
            for (int i = 1; i <=n; i++) {
                f *=i;
            }
        }
        return f;
    }









    @Test
    public void checkFactorial() {
//        Assert.assertTrue(factorial2(3) == 6);
//        Assert.assertTrue(factorial(3) == 6);
//        Assert.assertTrue(factorial(4) == 24);
//        Assert.assertTrue(factorial(1) == 1);
//        Assert.assertTrue(factorial(0) == 1);
        System.out.println(factorial(13));
        System.out.println(factorial2(13));
        System.out.println(factorial3(13));
        System.out.println(factorial4(13));
        System.out.println(factorial5(13));

    }
}


