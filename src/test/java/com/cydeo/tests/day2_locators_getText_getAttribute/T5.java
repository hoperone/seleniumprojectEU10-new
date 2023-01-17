package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        //1- Open a chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        //  Expected: Registration form
        String actualHeaderText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/h2")).getText();
        String expectedHeaderText = "Registration form";

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text matches");
        }else {
            System.out.println("Header text does not match");
        }

        //4- Locate “First name” input box
        //5- Verify placeholder attribute’s value is as expected:
        //  Expected: first name
        String actualPlaceholder = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/input")).getAttribute("placeholder");
        String expectedPlaceholder = "first name";

        if (actualPlaceholder.equals(expectedPlaceholder)){
            System.out.println("Placeholder Matches");
        }else {
            System.out.println("Placeholder does not matches");
        }




    }
}

/*
TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
  Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
  Expected: first name
 */