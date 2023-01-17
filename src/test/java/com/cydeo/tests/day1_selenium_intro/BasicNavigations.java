package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //1- Setup "browser driver"
        WebDriverManager.chromedriver().setup();

        //2- Create driver instance of Selenium WebDriver
        //Also opens an empty browser
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();


        //3- Go to "tesla.com"
        driver.get("https://www.tesla.com");

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().back();


        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate forward
        driver.navigate().forward();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        driver.navigate().refresh();

        //Stop code execution for 3 seconds
        //Thread.sleep(3000);

        //use navigate().to():
        //driver.navigate().to("https://www.google.com");

        //get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //get the current URL using Selenium
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //close the currently opened window
        driver.close();

        //will close all open windwos
        driver.quit();



    }
}
