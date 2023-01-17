package com.cydeo.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    //The @BeforeClass annotation in TestNG is used to specify a method that should be run once before all of the test methods in a test class.
    //This can be useful for setting up resources or performing other tasks that need to be done before any of the tests are run.
    //Here is an example of how to use the @BeforeClass annotation:
    //import org.testng.annotations.BeforeClass;
    //
    //public class TestClass {
    //
    //    @BeforeClass
    //    public void setUp() {
    //        // code to be executed before all test methods
    //    }
    //
    //    @Test
    //    public void testMethod1() {
    //        // code to perform the test
    //    }
    //
    //    @Test
    //    public void testMethod2() {
    //        // code to perform the test
    //    }
    //
    //}
    //In this example, the setUp method will be run once before both testMethod1 and testMethod2.
    @BeforeClass
    public void setupMethod(){
        System.out.println("--> BeforeClass is running!");
    }

    //The @BeforeClass annotation can be used in conjunction with the @AfterClass annotation, which specifies a method that should be run once after all of the test methods in a test class.
    //This can be useful for cleaning up resources or performing other tasks that need to be done after all of the tests are run.
    //import org.testng.annotations.AfterClass;
    //import org.testng.annotations.BeforeClass;
    //
    //public class TestClass {
    //
    //    @BeforeClass
    //    public void setUp() {
    //        // code to be executed before all test methods
    //    }
    //
    //    @Test
    //    public void testMethod1() {
    //        // code to perform the test
    //    }
    //
    //    @Test
    //    public void testMethod2() {
    //        // code to perform the test
    //    }
    //
    //    @AfterClass
    //    public void tearDown() {
    //        // code to be executed after all test methods
    //    }
    //
    //}
    //In this example, the setUp method will be run before both testMethod1 and testMethod2, and the tearDown method will be run after both testMethod1 and testMethod2.
    @AfterClass
    public void tearDownClass(){
        System.out.println("--> AfterClass is running!");
    }

    //@BeforeMethod annotation, which specifies a method that should be run before each test method.
    // This can be useful for setting up resources or performing other tasks that need to be done before each test.
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("--> BeforeMethod is running!");
    }

    //The @AfterMethod annotation in TestNG is used to specify a method that should be run after each test method.
    // This can be useful for cleaning up resources or performing other tasks that need to be done after each test.
    //Keep in mind that the @AfterMethod method will be run after each test method, regardless of whether the test passed or failed.
    // If you need to perform different actions based on the test result, you can use the @AfterTest annotation instead.
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("--> AfterMethod is running!");
    }

    //In TestNG, the @Test annotation is used to mark a method as a test method.
    //Test methods are methods that contain the code that actually performs the test.
    //Test methods should be designed to test a specific aspect of the code being tested, and they should be independent of one another.
    //This means that the test methods should not depend on the execution order or the state of other test methods.
    //By default, TestNG will run all test methods in a test class in alphabetical order.
    //However, you can specify the execution order of your test methods using the priority attribute of the @Test annotation.
    //Test methods with a higher priority will be run before test methods with a lower priority.
    /*
    import org.testng.annotations.Test;

    public class TestClass {

    @Test(priority = 1)
    public void testMethod1() {
        // code to perform the test
    }

    @Test(priority = 2)
    public void testMethod2() {
        // code to perform the test
        }
    }
    //In this example, testMethod1 will be run before testMethod2, because it has a higher priority

     */
    @Test(priority = 1)
    public void test1() {
        System.out.println("Test 1 is running...");

        String actual = "apple";
        String expected = "apple4";

        //assertEquals: Verifies that two values are equal.
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test 2 is running...");

        String actual = "apple";
        String expected = "apple";

        //assertTrue: Verifies that a boolean value is true.
        Assert.assertTrue(actual.equals(expected));

    }
}
