package com.cydeo.tests.day3_cssSelector_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    public static void main(String[] args) {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser using Utility we created
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //maximize window
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");


        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer

        //Locate “remember me” label text
        WebElement rememberMeLabelText = driver.findElement(By.className("login-item-checkbox-label"));

        //Store actual “remember me” label text into String variable
        String actualRememberMeLabelTextText = rememberMeLabelText.getText();

        //Store expected label text into String variable
        String expectedRememberMeLabelTextText = "Remember me on this computer";

        //Compare two Strings
        if (actualRememberMeLabelTextText.equals(expectedRememberMeLabelTextText)){
            System.out.println("remember me text matches, SUCCEED!");
        }else {
            System.out.println("remember me text matches, FAILED!");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?

        //Locate web element “forgot password” link
        WebElement forgetPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));

        //Assing actual link text to a variable
        String actualForgetPasswordLinkText = forgetPasswordLink.getText();

        //Expected link text
        String expectedForgetPasswordLinkText = "Forgot your password?";

        //Compare two Strings
        if (actualForgetPasswordLinkText.equals(expectedForgetPasswordLinkText)){
            System.out.println("Forget password link text match, SUCCEED!");
        }else {
            System.out.println("Forget password link text match, FAILED!");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        //Get attributes value
        String actualHrefAttribute = forgetPasswordLink.getAttribute("href");
        //expected attribues value
        String expectedHrefAttribute = "/?forgot_password=yes";

        //Compare attribute values
        if (actualHrefAttribute.contains(expectedHrefAttribute)){
            System.out.println("Actual href attribute match, SUCCEED!");
        }else {
            System.out.println("Actual href attribute match, FAILED!");
        }

    }
}
/*
TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes

PS: Inspect and decide which locator you should be using to locate web
elements.
 */