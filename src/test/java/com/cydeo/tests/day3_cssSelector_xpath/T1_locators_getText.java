package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.tests.utilities.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //1- Open a chrome browser
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”

        //Locate login box
        WebElement loginBox =  driver.findElement(By.className("login-inp"));
        //click in login box
        //loginBox.click();
        //enter username
        loginBox.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”

        //Locate password box
        WebElement passBox = driver.findElement(By.name("USER_PASSWORD"));
        //Click in password box
        //passBox.click();
        //Enter incorrect password: “incorrect”
        passBox.sendKeys("incorrect");

        //5- Click to login button.
        driver.findElement(By.className("login-btn")).click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        //Get actual text
        String actualText = driver.findElement(By.className("errortext")).getText();
        //Declare expected text
        String expectedText = "Incorrect login or password";

        //Verify error message text is as expected
        if (actualText.equals(expectedText)){
            System.out.println("Match");
        }else {
            System.out.println("No match");
        }


    }
}
/*
TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password

PS: Inspect and decide which locator you should be using to locate web
elements.
 */