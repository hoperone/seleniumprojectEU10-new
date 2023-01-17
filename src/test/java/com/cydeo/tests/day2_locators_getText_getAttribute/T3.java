package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //1- Open a chrome browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        //2- Go to: https://google.com
        driver.get("https://google.com");

        //Thread.sleep(2000);
        //accepts cookies
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();

        //3- Write “apple” in search box
        //locate the search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        //click inside search box
        googleSearchBox.click();

        //type text in search box and press ENTER
        googleSearchBox.sendKeys("Apple" + Keys.ENTER);
        //press seach button
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();

        //press another link to change results to english
        driver.findElement(By.xpath("//*[@id=\"Rzn5id\"]/div/a[2]")).click();


        //5- Verify title:
        //Expected: Title should start with “apple” word
        String exceptedTitle = "Apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(exceptedTitle)){
            System.out.println("Title matches");
        }else {
            System.out.println("No match");
        }
    }
}
/*TC#3: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Click google search button
5- Verify title:
Expected: Title should start with “apple” word

 */