package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.WebDriverFactory;
import com.cydeo.tests.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_name_verify_test() {
        //TC #1: Web table practice
        // 1. Go to: https://practice.cydeo.com/web-tables
        //2. Verify Bob’s name is listed as expected.
        WebElement bobMartinCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String actualBobMartinCellText = bobMartinCell.getText();
        String exceptedBobMartinCellText = "Bob Martin";
        //Expected: “Bob Martin”

        Assert.assertEquals(actualBobMartinCellText, exceptedBobMartinCellText);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        WebElement bobMartinDateCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
        String actualBobMartinDateCellText = bobMartinDateCell.getText();
        String expectedBobMartinDateCellText = "12/31/2021";

        Assert.assertEquals(actualBobMartinDateCellText, expectedBobMartinDateCellText);
    }

    @Test
    public void test2(){
        //We use the utility method we created
        String customerOrderDate = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("customerOrderDate = " + customerOrderDate);

    }

    //Using WebTablesUtils.orderVerify() method
    @Test
    public void test3(){
        WebTableUtils.orderVerify(driver, "Bart Fisher", "01/16/2021");
    }
}
