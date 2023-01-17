package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.yahoo.com");

        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        String expectedTitle = "Yahooist Teil der Yahoo Markenfamilie";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title mached");
        }else {
            System.out.println("title does not match");
        }

        driver.close();

        }

    }

