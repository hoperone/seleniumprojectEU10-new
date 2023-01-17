package com.cydeo.tests.day2_homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        //Locate header Web elemenet
        WebElement headerWebElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/h3"));
        String actualHeaderText = headerWebElement.getText();
        String expectedHeaderText = "Log in to ZeroBank";

        //check if header text matches
        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("match");
        }else {
            System.out.println("no match");
        }

    }
}
/*
TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
 */