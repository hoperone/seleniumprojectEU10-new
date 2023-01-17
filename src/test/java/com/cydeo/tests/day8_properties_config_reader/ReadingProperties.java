package com.cydeo.tests.day8_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_test() throws IOException {
        //In order to read configuration file we need 3 steps
        //Step 1, Create an object of Properties class from Java.util
        Properties properties = new Properties();

        //Step 2, Open the file in java memory, using FileInputSteam, from Java.io
        FileInputStream file = new FileInputStream("configuration.properties");

        //Step 3, Load the properties object using FileInputStream object
        properties.load(file);

        //Use "properties" object to read value
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
    }
}
