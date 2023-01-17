package com.cydeo.tests.day2_homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com ");

        //accept cookies
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[1]")).click();

        //3. Enter incorrect username
        //locate username form
        WebElement userNameInputBox = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        //click inside
        userNameInputBox.click();
        //enter username
        userNameInputBox.sendKeys("sdkfjsdfksdf");

        //4. Enter incorrect password
        //locate password box
        WebElement passwordInputBox = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        //click inside
        passwordInputBox.click();
        //enter password and hit enter
        passwordInputBox.sendKeys("9348hf");
    }
}
/*
TC #2: Facebook incorrect login title verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Enter incorrect username
4. Enter incorrect password
5. Verify title changed to:
Expected: “Log into Facebook”
 */