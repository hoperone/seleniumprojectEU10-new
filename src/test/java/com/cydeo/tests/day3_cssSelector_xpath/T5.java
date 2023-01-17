package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.tests.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5 {
    public static void main(String[] args) {

        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        //3- Enter incorrect username into login box:
        WebElement loginBox =  driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        //loginBox.click();
        loginBox.sendKeys("wrongUser");

        //4- Click to `Reset password` button
        WebElement resetPasswordBtn = driver.findElement(By.xpath("//button[@value='Reset password']"));
        resetPasswordBtn.click();

        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        String expectedErrorLabel = "Login or E-mail not found";
        WebElement errorLabelText = driver.findElement(By.xpath("//div[@class='errortext']"));
        String actualErrorLabel =  errorLabelText.getText();

        if (actualErrorLabel.equals(expectedErrorLabel)){
            System.out.println("Match");
        }else {
            System.out.println("No Match");
        }
        //
        //
        //
        //
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from

    }
}
