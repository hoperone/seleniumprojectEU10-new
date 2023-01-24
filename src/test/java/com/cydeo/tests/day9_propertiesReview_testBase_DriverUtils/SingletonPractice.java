package com.cydeo.tests.day9_propertiesReview_testBase_DriverUtils;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test(priority = 2)
    public void singleton_understand_test1() {

        String str = Singleton.getWord();
        System.out.println("str = " + str);

        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);
    }

    @Test(priority = 1)
    public void singleton_understand_test2() {
        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);
    }
}
