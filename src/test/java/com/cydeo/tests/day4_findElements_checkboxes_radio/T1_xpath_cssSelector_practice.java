package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.tests.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) {
        //XPATH and CSS Selector PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.

        //TC #1: XPATH and cssSelector Practices

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)

        //a. “Home” link // find element using cssSelector
        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //System.out.println("homeLink.getText() = " + homeLink.getText());
        // find the same element using cssSelector
        WebElement homeLink2 = driver.findElement(By.cssSelector("li[class='nav-item'] > a"));
        //System.out.println("homeLink2.getText() = " + homeLink2.getText());
        // find the same element using cssSelector
        WebElement homeLink3 = driver.findElement(By.cssSelector("a.nav-link"));
        //System.out.println("homeLink3.getText() = " + homeLink3.getText());
        // find the same element using XPATH
        WebElement homeLink4 = driver.findElement(By.xpath("//a[@class='nav-link']"));
        //System.out.println("homeLink4.getText() = " + homeLink4.getText());
        // find the same element using XPATH
        WebElement homeLink5 = driver.findElement(By.xpath("//a[.='Home']"));
        //System.out.println("homeLink5.getText() = " + homeLink5.getText());
        // find the same element using XPATH
        WebElement homeLink6 = driver.findElement(By.xpath("//a[text()='Home']"));
        //System.out.println("homeLink6.getText() = " + homeLink6.getText());

        //b. “Forgot password” header
        WebElement forgetPass1 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        //System.out.println("forgetPass1.getText() = " + forgetPass1.getText());

        //b. “Forgot password” header
        //Locate header using cssSelector: locate parent element and move down to h2
        WebElement forgetPass2 = driver.findElement(By.cssSelector("div.example > h2"));


        //c. “E-mail” text
        WebElement emailText1 = driver.findElement(By.xpath("//label[.='E-mail']"));
        //System.out.println("emailText1.getText() = " + emailText1.getText());
        //d. E-mail input box
        WebElement inputBox1 = driver.findElement(By.xpath("//input[@type='text']"));
        //e. “Retrieve password” button
        WebElement retrieveBtn = driver.findElement(By.xpath("//button[@id='form_submit']"));
        //f. “Powered by Cydeo
        WebElement powerdByCydeo = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        //4. Verify all web elements are displayed.
        System.out.println("homeLink2.isDisplayed() = " + homeLink2.isDisplayed());
        System.out.println("forgetPass1.isDisplayed() = " + forgetPass1.isDisplayed());
        System.out.println("emailText1.isDisplayed() = " + emailText1.isDisplayed());
        System.out.println("inputBox1.isDisplayed() = " + inputBox1.isDisplayed());
        System.out.println("retrieveBtn.isDisplayed() = " + retrieveBtn.isDisplayed());
        System.out.println("powerdByCydeo.isDisplayed() = " + powerdByCydeo.isDisplayed());


        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible
        //
        //Then solve the task using XPATH only. Try to create 2 different
        //XPATH locator if possible

        driver.close();

    }
}
