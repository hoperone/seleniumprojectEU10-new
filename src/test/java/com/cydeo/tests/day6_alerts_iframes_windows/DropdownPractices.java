package com.cydeo.tests.day6_alerts_iframes_windows;


import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropdown_task5() throws InterruptedException {
        //Use all Select options. (visible text, value, index)

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        Thread.sleep(1000);

        stateDropdown.selectByVisibleText("Illinois");  //3. Select Illinois



        Thread.sleep(1000);//using this to slow down the browser, in order to see what's happening
        stateDropdown.selectByValue("VA");  //4. Select Virginia



        Thread.sleep(1000);
        stateDropdown.selectByIndex(5); //5. Select California

        //6. Verify final selected option is California.
        String actualText = stateDropdown.getFirstSelectedOption().getText();
        String expectedText = "California";

        Assert.assertEquals(actualText, expectedText);


    }
    @Test
    public void dropdown_task6(){
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        //3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));


        yearDropdown.selectByVisibleText("1924");   //Select year using  : visible text
        monthDropdown.selectByValue("11");  //Select month using   : value attribute
        dayDropdown.selectByIndex(0);   //Select day using : index number

        //creating expected values
        String expectedYear = "19248";
        String expectedMonth = "Decemberr";
        String expectedDay = "12";

        //Getting actual values from browser
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //Assertion
        Assert.assertTrue(actualYear.equals(expectedYear), "Year don't match");
        Assert.assertEquals(actualMonth, expectedMonth, "Month don't match");
        Assert.assertEquals(actualDay, expectedDay, "Day don't match");
    }

    @AfterMethod(enabled = false) //This method will not run
    public void tearDownMethod(){
        driver.close();
    }


}
