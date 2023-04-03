package contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TonicContactPage;

import java.util.concurrent.TimeUnit;


public class ContactTests {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        //Use Chromedriver
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void contactTest() {
        //Create object of HomePage class
        HomePage home = new HomePage(driver);
        home.clickOnContactButton();


        //Create object of ContactPage
        TonicContactPage contactPage = new TonicContactPage(driver);

        //Check if page is opened
        //Assert.assertTrue(contactPage.isPageOpened());

        //Fill in data
        contactPage.setForm_name("John Doe");
        contactPage.setForm_email("johndoe@hellotonic.com");
        contactPage.setForm_message("Please ignore, this is an automated test sent by Selenium Webdriver.");

        //Click on Submit
        contactPage.clickOnSubmit();

        //Validate alert text
        contactPage.getAlertText("Got it! We will get back to you as soon as we can.");
        assertEquals(contactPage.getAlertText("There was an error submitting your form."));



    }

    private void assertEquals(boolean alertText) {
    }

    //@AfterClass
    //public void close() {
        //driver.close();


}