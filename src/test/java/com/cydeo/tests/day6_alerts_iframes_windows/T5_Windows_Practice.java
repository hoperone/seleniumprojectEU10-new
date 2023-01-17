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

public class T5_Windows_Practice {
    //TC #5: Window Handle practice
    //
    //1. Create a new class called: T5_WindowsPractice
    //2. Create new test and make set-ups
    //3. Go to : https://practice.cydeo.com/windows


    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = WebDriverFactory.getDriver("chrome");  //1. Open browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/windows"); //2. Go to website: https://practice.cydeo.com/windows
    }

    @Test
    public void multiple_window_test(){


        String mainHandle = driver.getWindowHandle();   //Storing the main page's window handle as a string is a good practice for future reference and re-usability

        System.out.println("mainHandle = " + mainHandle);   //Printing out the main page's window handle

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";   //Excepted title
        String actualTitle = driver.getTitle(); //Actual title

        Assert.assertEquals(actualTitle, expectedTitle);   //Assertion

        System.out.println("Title before click = " + actualTitle);

        //5. Click to: “Click Here” link
        WebElement clickHere = driver.findElement(By.linkText("Click Here"));   //First locate the element
        clickHere.click();  //click on the element

        actualTitle = driver.getTitle();
        System.out.println("Title after click = " + actualTitle);   //The title remains same as last time printed, because we didn't switch the window or tab

        //6. Switch to new Window.
        //To switch into next window we need to use for each loop
        for (String each: driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }

/*        //Another way to switch to new Window. Example from openAI
        Set<String> handles = driver.getWindowHandles();    // Get the list of window handles
        //Keep in mind that driver.getWindowHandles() returns a set of window handles and to navigate through the set you need to convert it to a list.
        ArrayList<String> handlesList = new ArrayList<>(handles);   // Convert the set to a list
        driver.switchTo().window(handlesList.get(1));   // Switch to the next tab*/


        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitleAfterClick, actualTitle);


    }

    @AfterClass
    public void afterClass(){
        driver.close(); //Will close only the selected open tab
        driver.quit();  //Will close every open tab or window
    }
}
