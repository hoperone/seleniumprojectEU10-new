package com.cydeo.tests.Extra_Tasks;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AutomationLeneNafisa {
    @Test
    public void to_do_method() {
        //Write a basic browser automation framework to validate a Polymer website. The focus should
        //be on The Web Application under test http://todomvc.com/
        //1. The first step should be to load the website, click within the JavaScript tab, and select
        //Polymer link.
        Driver.getDriver().get("http://todomvc.com/");
        WebElement javaScriptTab = Driver.getDriver().findElement(By.xpath("//div[.='JavaScript']"));
        WebElement polymerLink = Driver.getDriver().findElement(By.xpath("//a[.='Polymer']"));

        Actions actions = new Actions(Driver.getDriver());
        //BrowserUtils.sleep(2);
        actions.moveToElement(javaScriptTab).click().perform();
        actions.moveToElement(polymerLink).click().perform();

        //2. The second step should be: Add two Todo items
        WebElement todoInputBox = Driver.getDriver().findElement(By.cssSelector("input#new-todo"));

        actions.moveToElement(todoInputBox).click().perform();
        todoInputBox.sendKeys("study hard");
        todoInputBox.sendKeys(Keys.ENTER);

        WebElement whatNeedsToBeDoneInput = Driver.getDriver().findElement(By.xpath("//input[@placeholder='What needs to be done?']"));
        actions.moveToElement(whatNeedsToBeDoneInput).click().perform();
        whatNeedsToBeDoneInput.sendKeys("revision is a way to go");
        whatNeedsToBeDoneInput.sendKeys(Keys.ENTER);
    }
}
