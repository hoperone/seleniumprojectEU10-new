package com.cydeo.tests.Extra_Tasks;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Find_elements {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com");
    }
    @Test
    public void test1_number_of_links(){
        //TC #1: Checking the number of links on the page
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        //3. Count the number of the links on the page and verify
        //Expected: 332

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int actualAllLinksSize = allLinks.size();
        int expectedAllLinksSize = 355;

        Assert.assertEquals(actualAllLinksSize, expectedAllLinksSize);
    }

    @Test
    public void test2_print_Text_of_links(){
        //TC #2: Printing out the texts of the links on the page
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        //3. Print out all of the texts of the links on the page
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (WebElement each : allLinks) {
            try {
                System.out.println("each.getText() = " + each.getText());
            }catch (StaleElementReferenceException e){
                continue;
            }

        }
    }

    @Test
    public void test3_links_without_text(){
        //TC #3: Counting the number of links that does not have text
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        //3. Count the number of links that does not have text and verify
        //Expected: 109
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int emptyCount=0;

        for (WebElement each : allLinks) {
            try {
                if (each.getText().isEmpty()){
                    emptyCount++;
                }else {
                    System.out.println("each.getText() = " + each.getText());

                }            }catch (StaleElementReferenceException e){
                continue;
            }


        }
        System.out.println("emptyCount = " + emptyCount);
    }
}
