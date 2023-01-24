package com.cydeo.tests.Extra_Tasks;

import com.cydeo.tests.utilities.SmartBearUtils;
import com.cydeo.tests.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class T1_Smartbear_Software_Link_Verification {

    public WebDriver driver;

    Faker faker = new Faker();


    @BeforeClass(enabled = true)
    public void setupBrowserClass(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtils.loginToSmartBear(driver);
    }
    @BeforeMethod(enabled = false)
    public void setupMethod() {



/*        //Locate Username box
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        usernameBox.sendKeys("Tester"); //Enter username: “Tester”

        //Locate Password box and Enter password: “test”
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");

        //Locate Login Button and click on it
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']")).click();*/
    }

    @Test
    public void software_link_verification() {


/*        //Locate Username box
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        usernameBox.sendKeys("Tester"); //Enter username: “Tester”

        //Locate Password box and Enter password: “test”
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");

        //Locate Login Button and click on it
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']")).click();*/

        //6. Print out count of all the links on landing page 
        List<WebElement> links = driver.findElements(By.tagName("a"));  // find all the links on the page
        System.out.println("Count of all the links on landing page = " + links.size());   // print out the count of links

        //7. Print out each link text on this page

        for (WebElement link : links) {
            System.out.println("link text = " + link.getText());
        }
//------------------------------------------------- TC#2
        //6. Click on Order
        WebElement orderLinkBtn = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderLinkBtn.click();

        //7. Select familyAlbum from product, set quantity to 2
        WebElement productDropBox = driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")); //Locate product drop box
        Select productDropDown = new Select(productDropBox); //// Create a Select object for the dropdown
        productDropDown.selectByValue("FamilyAlbum"); //Select familyAlbum

        WebElement quantityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")); //Locate Quantity box
        quantityBox.sendKeys(Keys.BACK_SPACE); //Deletes the problematic Zero number, before entering our number
        quantityBox.sendKeys("2"); //set quantity to 2

        //8. Click to “Calculate” button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).sendKeys(faker.name().fullName()); //Find and fill in Customer name
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']")).sendKeys(faker.address().zipCode().substring(0, 4));

        //10. Click on “visa” radio button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();
        //11. Generate card number using JavaFaker
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")).sendKeys(faker.business().creditCardNumber().replaceAll("-", ""));

        /*
        Another method to generate a future date in the format of "03/26" using Java is to use the LocalDate.now() method to get the current date,
        and then use the plusDays(), plusMonths(), or plusYears() method to add a certain number of days, months or years to the current date.
        You can then use the format() method to format the date in the desired format.
        Here is an example of how you can use the plusDays() method to generate a future date in the format of "03/26" using java:
         */
        LocalDate now = LocalDate.now();
        LocalDate future = now.plusDays(365);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        String expDate = future.format(formatter);
        /*
        In the example above, a LocalDate object now is set to the current date and a LocalDate object future is set to the current date plus 365 days,
        the DateTimeFormatter.ofPattern("MM/dd") method is used to set the format of the date to "03/26" and format() is used to format the date.
         */
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys(expDate);

        //12. Click on “Process”
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

        //13. Verify success message “New order has been successfully added.”
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']//strong"));
        Assert.assertTrue(successMessage.isDisplayed());


    }

/*    @Test
    public void smartBear_software_order_placing(){

        SmartBearUtils.loginToSmartBear(driver);

        //6. Click on Order
        WebElement orderLinkBtn = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderLinkBtn.click();

        //7. Select familyAlbum from product, set quantity to 2
        //8. Click to “Calculate” button
        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        //10. Click on “visa” radio button
        //11. Generate card number using JavaFaker
        //12. Click on “Process”
        //13. Verify success message “New order has been successfully added.”
    }*/

    @Test
    public void test3_order_verification(){
        //TC#3: Smartbear software order verification
        //1. Open browser and login to Smartbear software
        //SmartBearUtils.loginToSmartBear(driver);

        //2. Click on View all orders
        WebElement viewAllOrdersBtn = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        viewAllOrdersBtn.click();

        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement susanMclarenDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Susan McLaren']/following-sibling::td[3]"));
        String actualSusanMclarenDate = susanMclarenDate.getText();
        String expectedSusanMclarenDate = "01/05/2010";

        Assert.assertEquals(actualSusanMclarenDate, expectedSusanMclarenDate);
    }
}
