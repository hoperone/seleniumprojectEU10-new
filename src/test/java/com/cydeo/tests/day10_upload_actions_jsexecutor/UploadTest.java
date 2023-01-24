package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTest {

    @Test
    public void uploadTest() {
        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");
        //2. Find some small file from your computer, and get the path of it.
        String imageFile = "C:\\Users\\Admin\\Desktop\\ButtonOnMobile.png";

        //3. Upload the file.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        chooseFileButton.sendKeys(imageFile);

        //4. Click the upload button.
        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();

        //5. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadedText = Driver.getDriver().findElement(By.tagName("h3"));


        //6. Assert:
        //-File uploaded text is displayed on the page
        Assert.assertTrue(fileUploadedText.isDisplayed());

    }

}

