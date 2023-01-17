package com.cydeo.tests.day2_homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //1- Open a chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //accpet cookies
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();

        //3- Click to Gmail from top right.
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[1]/a")).click();

        //4- Verify title contains:
        //  Expected: Gmail
        //get title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Gmail";
        //compare title
        if (actualTitle.equals(expectedTitle)){
            System.out.println("match");
        }else {
            System.out.println("no match");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //  Expected: Google
        actualTitle = driver.getTitle();
        expectedTitle = "Google";
        //compare title
        if (actualTitle.equals(expectedTitle)){
            System.out.println("match");
        }else {
            System.out.println("no match");
        }

    }
}
/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
  Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
  Expected: Google
 */