package com.cydeo.tests.Extra_Tasks;
import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LenaAutomationTask {
    //Write a basic browser automation framework to validate a Polymer website. The focus should
    //be on The Web Application under test http://todomvc.com/
    //1. The first step should be to load the website, click within the JavaScript tab, and select
    //Polymer link.
    //2. The second step should be: Add two Todo items
    //3. Bonus: (optional stretch goal): Edit the content of the second Todo item


    @Test
    public void polymer_test() {
        //open http://todomvc.com/
        Driver.getDriver().get("http://todomvc.com/");

        //Declaring Actions
        Actions actions = new Actions(Driver.getDriver());

        //ELEMENT LOCATORS
        //click within the JavaScript tab, using this locator template //a[.='t']
        //Driver.getDriver().findElement(By.xpath("//div[.='JavaScript']")).click(); //Locate the element and click on it -------- OR do it this way, just in one line
        WebElement javaScriptTabElement = Driver.getDriver().findElement(By.xpath("//div[.='JavaScript']"));
        actions.click(javaScriptTabElement).perform();

        // and select Polymer link.
        Driver.getDriver().findElement(By.xpath("//a[.='Polymer']")).click();   //Locate the element and click on it

        //Add two Todo items
        WebElement inputBox = Driver.getDriver().findElement(By.id("new-todo")); //Locate the "What needs to be done?" box
        inputBox.sendKeys(ConfigurationReader.getProperty("todo_item_1"), Keys.ENTER); // Enter Todo Item, retrieved from .properties file
        inputBox.sendKeys(ConfigurationReader.getProperty("todo_item_2"), Keys.ENTER); // Enter Todo Item, retrieved from .properties file

        //Edit the content of the second Todo item

        //We can also use this approach to locate any other entry by text value
        String secondTodoItemText = ConfigurationReader.getProperty("todo_item_2"); //Retrieve the text of the second Todo item
        String secondTodoItemTextEdited = ConfigurationReader.getProperty("todo_item_2_edited"); //Retrieve the text

        WebElement secondTodoItem = Driver.getDriver().findElement(By.xpath("//label[.='" + secondTodoItemText + "']"));  //Locate the second Todo item by text value, retrieved from .properties file

        actions.doubleClick(secondTodoItem).perform(); //Then double click to enter text editing mode

        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();  //Select all text, control + a
        actions.sendKeys(secondTodoItemTextEdited).sendKeys(Keys.ENTER).perform(); //Add new text
    }

}
