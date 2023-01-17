package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.tests.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) {


        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password

        //Locate the login button by cssSelector
        WebElement logInButtonElement = driver.findElement(By.cssSelector("button[value='Reset password']"));
        //Get actual button text
        String actualLogInButtonElementText = logInButtonElement.getText();
        String exceptedLogInButtonElementText = "Reset password";

        //Verify “Reset password” button text is as expected
        if (actualLogInButtonElementText.equals(exceptedLogInButtonElementText)){
            System.out.println("Verify “Reset password” button text is as expected: PASSED");
        }else {
            System.out.println("Verify “Reset password” button text is as expected: FAILED");
        }
        //
        //
        //
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from

    }
}
