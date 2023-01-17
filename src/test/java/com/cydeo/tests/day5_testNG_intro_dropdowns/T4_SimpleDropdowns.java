package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//org.openqa.selenium.support.ui.Select is a class in the Selenium WebDriver Java library that provides a way to select an option from a dropdown menu on a webpage.
//deselectAll(): Deselects all options in a multiple select element.
//deselectByIndex(int index): Deselects an option in a multiple select element based on its index (0-based).
//deselectByValue(String value): Deselects an option in a multiple select element based on the value of the "value" attribute.
//deselectByVisibleText(String text): Deselects an option in a multiple select element based on its visible text.
//getAllSelectedOptions(): Returns a list of all selected options in the select element.
//getFirstSelectedOption(): Returns the first selected option in the select element.
//getOptions(): Returns a list of all options in the select element.
//getValue(): Returns the value of the "value" attribute of the first selected option in the select element.
//isMultiple(): Returns true if the select element supports multiple selections.
//selectByIndex(int index): Selects an option in the select element based on its index (0-based).
//selectByValue(String value): Selects an option in the select element based on the value of the "value" attribute.
//selectByVisibleText(String text): Selects an option in the select element based on its visible text.
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropdowns {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropdownTest(){
        //TC#4: Verifying “Simple dropdown” and “State selection” dropdown
        //default values
        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”

        //Two lines of code in one, creating a Select object, finding the element and passing it to Select object at the same time
        //Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        // Find the dropdown element
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));

        // Create a Select object for the dropdown
        Select simpleDropdown = new Select(dropdownElement);

        //Returns the first selected option in the select element.
        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();
        //Returns the text from the selected option
        String actualSimpleDropdownText = currentlySelectedOption.getText();

        String expectedSimpleDropdownText = "Please select an option";

        //compares
        Assert.assertEquals(actualSimpleDropdownText,expectedSimpleDropdownText, "We got a match");


        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        //creating a Select object, finding the element and passing it to Select object at the same time
        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //Returns the first selected option in the select element.
        WebElement stateSelectionFirstSelectedOption = stateSelection.getFirstSelectedOption();

        //Returns the text from the selected option
        //More compact code
        //String actualStateSelectionText = stateSelection.getFirstSelectedOption().getText();
        String actualStateSelectionText = stateSelectionFirstSelectedOption.getText();
        String expectedStateSelectionText = "Select a State";



        //compares
        Assert.assertEquals(actualStateSelectionText, expectedStateSelectionText);


    }


}
