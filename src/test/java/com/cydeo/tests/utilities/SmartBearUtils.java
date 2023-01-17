package com.cydeo.tests.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {


    public static void loginToSmartBear(WebDriver driver) {

/*        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");*/

        //Locate Username box
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        usernameBox.sendKeys("Tester"); //Enter username: “Tester”

        //Locate Password box and Enter password: “test”
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");

        //Locate Login Button and click on it
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']")).click();
    }
}


