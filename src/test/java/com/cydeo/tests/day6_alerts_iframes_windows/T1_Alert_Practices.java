package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");  //1. Open browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts"); //2. Go to website: http://practice.cydeo.com/javascript_alerts
    }

    @Test
    public void alert_test_1(){ //TC #1: Information alert practice

        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']")); //Locate the element
        jsAlertBtn.click(); //3. Click to “Click for JS Alert” button

        //Because it's Js, we have to switch driver to alert
        //driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert(); //we switch driver to alert first
        alert.accept();    //4. Click to OK button from the alert

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']")); //Locate the actual text

        String actualText = resultText.getText(); //Getting the actual text
        String expectedText = "You successfully clicked an alert";  //Expected text

        Assert.assertEquals(expectedText, actualText); //Assertion
    }

    @Test
    public void alert_test_2(){ //TC #2: Confirmation alert practice

        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")); //Locate the element

        jsConfirmBtn.click();   //3. Click to “Click for JS Confirm” button

        Alert alert = driver.switchTo().alert();    //we switch driver to alert first
        alert.accept();     //4. Click to OK button from the alert

        //driver.switchTo().alert().accept(); //Or we can do all the above in one line

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']")); //Locate the actual text


        String actualText = resultText.getText(); //Getting the actual text
        String expectedText = "You clicked: Ok";    //Expected text

        Assert.assertEquals(expectedText, actualText); //Assertion
    }

    @Test
    public void alert_test_3() throws InterruptedException {

        WebElement clickForJsBtn = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")); //Locate the element
        clickForJsBtn.click();  //3. Click to “Click for JS Prompt” button

        Alert alert = driver.switchTo().alert();    //we switch driver to alert first

        alert.sendKeys("hello");    //4. Send “hello” text to alert

        alert.accept();     //5. Click to OK button from the alert


        //6. Verify “You entered: hello” text is displayed.

        String actualText = driver.findElement(By.id("result")).getText();  //Getting the actual text
        String expectedText = "You entered: hello";     //Expected text

        Assert.assertEquals(actualText, expectedText, "Text does not match"); //Assertion with text
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
