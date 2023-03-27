package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    private WebDriver driver;

    @FindBy(className = "v2")
    WebElement heading;

    @FindBy(id = "form_name")
    WebElement form_name;

    @FindBy(id = "form_email")
    WebElement form_email;

    @FindBy(id = "form_message")
    WebElement form_message;

    @FindBy(xpath = "//*[@id=\"contact\"]/div[2]/div[3]/form/div[4]/div/button")
    WebElement submitButton;

    //Constructor
    public ContactPage(WebDriver driver){
        this.driver = driver;

        //Initialize Elements
        PageFactory.initElements(driver,this);
    }

    public void setForm_name(String name){
        form_name.clear();
        form_name.sendKeys(name);
    }

    public void setForm_email(String email){
        form_email.clear();
        form_email.sendKeys(email);
    }

    public void setForm_message(String message){
        form_message.clear();
        form_message.sendKeys(message);
    }

    public void clickOnSubmit(){
        submitButton.click();
    }

    public boolean isPageOpened(){
        //Assertion
        return heading.getText().toString().contains("Get in Touch");
    }

}
