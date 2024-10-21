package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    public WebDriver driver;

    //Locators

        //Contact Button
        @FindBy (xpath = "//body[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/div[1]/li[5]/button[1]")
        WebElement contactButton;

        //Constructor
        public HomePage(WebDriver driver){
            this.driver=driver;
            //Page URL
            String PAGE_URL = "https://hellotonic.com/";
            driver.get(PAGE_URL);
            //Initialize Elements
            PageFactory.initElements(driver,this);
        }

        public TonicContactPage clickOnContactButton(){
            contactButton.click();
            return new TonicContactPage(driver);
        }

}
