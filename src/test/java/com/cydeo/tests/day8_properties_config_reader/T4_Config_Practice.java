package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Config_Practice {

/*    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #4: Google search
        //1- Open a chrome browser
        //2- Go to: https://google.com
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }*/

    @Test
    public void google_search_test(){
        //Driver.getDriver() -> driver
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement googleAcceptButton = Driver.getDriver().findElement(By.xpath("//div[@class='QS5gu sy4vM']"));
        googleAcceptButton.click();

        //3- Write “apple” in search box
        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys(ConfigurationReader.getProperty("keyword") + Keys.ENTER);
        //4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle = ConfigurationReader.getProperty("keyword")+" - Google Suche"; //title verification dynamic. If search value changes, title changes too
        String actualTitle = Driver.getDriver().getTitle(); //get actual title

        Assert.assertEquals(expectedTitle, actualTitle); //Assertion
        //
        //
        //Use `configuration.properties` for the following:
        //1. The browser type
        //2. The URL
        //3. The search keyword
        //4. Make title verification dynamic. If search value changes, title
        //assertion should not fail.
    }
}
