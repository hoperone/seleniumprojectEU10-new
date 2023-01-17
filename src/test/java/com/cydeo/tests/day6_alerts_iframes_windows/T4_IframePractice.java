package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_IframePractice {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = WebDriverFactory.getDriver("chrome");  //1. Open browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe"); //2. Go to website: https://practice.cydeo.com/iframe
    }

    @Test
    public void iframe_test(){//4. Assert: “Your content goes here.” Text is displayed.

        //We need to switch driver's focus to iframe
        //option #1- switching to iframe using id attribute value
        //driver.switchTo().frame("mce_0_ifr");

        //option #2- passing index number of iframe
        //driver.switchTo().frame(0);

        //option #3- locate as web element and pass in frame() method
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        //4. Assert: “Your content goes here.” Text is displayed.

        WebElement paragraphText = driver.findElement(By.xpath("//p")); //Locate the p tag

        Assert.assertTrue(paragraphText.isDisplayed());

        //Verify "An iFrame containing the TinyMCE WYSIWYG Editor"

        driver.switchTo().defaultContent();   //To be able to verify the header, we must switch back to "main HTML", by using .defaultContent() or .parentFrame()

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor” Text is displayed.

        WebElement h3Text = driver.findElement(By.xpath("//h3")); //Getting the actual

        Assert.assertTrue(h3Text.isDisplayed()); //Assertion

    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }
}
