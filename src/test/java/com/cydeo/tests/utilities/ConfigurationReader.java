package com.cydeo.tests.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //In order to read configuration file we need 3 steps
    //Step 1, Create an object of Properties class from Java.util
    private static Properties properties = new Properties();
    //put inside static block because we need to run this code first
    static {

        try {
            //Step 2, Open the file in java memory, using FileInputSteam, from Java.io
            FileInputStream file = new FileInputStream("configuration.properties");

            //Step 3, Load the properties object using FileInputStream object
            properties.load(file);

            //close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in ConfigurationReader class");
            e.printStackTrace();
        }

    }
    //Step 4, - Use properties object and getProperty method to pass "key" and read "value"
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

}
