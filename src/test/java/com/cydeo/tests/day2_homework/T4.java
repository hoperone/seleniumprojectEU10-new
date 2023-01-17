package com.cydeo.tests.day2_homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //1- Open a chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link
        //PS: Locate “Home” link using “className” locator
        // */
        driver.findElement(By.className("nav-link")).click();

        //4- Verify title is as expected:
        //Expected: Practice
        //get title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        //compare titles
        if (actualTitle.equals(expectedTitle)){
            System.out.println("match");
        }else {
            System.out.println("no match");
        }

    }
}
/*
TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice

PS: Locate “Home” link using “className” locator
 */