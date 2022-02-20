package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

public MyAccount(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText="Sign out")
    @CacheLookup
    WebElement signout;


    public void clickSignoutLink()
    {
        signout.click();
    }

}
