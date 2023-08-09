package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    public WebDriver driver;

    //Locators

        //Contact Button
        @FindBy (xpath = "//*[@id=\"__next\"]/header/div/div/div/div[2]/ul[1]/div/li[4]/button")
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
