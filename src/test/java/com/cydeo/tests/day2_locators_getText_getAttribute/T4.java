package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4 {
    public static void main(String[] args) throws InterruptedException {



        WebDriverManager.chromedriver().setup();
        //1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://library2.cybertekschool.com/login.html
        driver.get("http://library2.cybertekschool.com/login.html");

        //3. Enter username: “incorrect@email.com” PS: Locate username input box using “className” locator
        WebElement userNameBox = driver.findElement(By.className("form-control"));
        //userNameBox.click();
        userNameBox.sendKeys("incorrect@email.com");

        //4. Enter password: “incorrect password” -- Locate password input box using “id” locator
        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("incorrect password");

        //Locate Sign in button using “tagName” locator
        WebElement signIn = driver.findElement(By.tagName("button"));
        signIn.click();

        //5. Verify: visually “Sorry, Wrong Email or Password”
        //displayed

        String expectedResult = "Sorry, Wrong Email or Password";

        Thread.sleep(2000);

        String actualResult = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div")).getText();



        System.out.println(actualResult);

    }
}

/*
TC #4: Library verifications
1. Open Chrome browser
2. Go to http://library2.cybertekschool.com/login.html
3. Enter username: “incorrect@email.com”
4. Enter password: “incorrect password”
5. Verify: visually “Sorry, Wrong Email or Password”
displayed
PS: Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
 */