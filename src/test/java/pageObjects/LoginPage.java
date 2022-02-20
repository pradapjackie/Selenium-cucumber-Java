package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

 WebDriver driver;

public LoginPage(WebDriver webDriver)
{
     driver = webDriver;
    PageFactory.initElements(webDriver, this);
}

    @FindBy(id="email")
    @CacheLookup
    WebElement textboxEmailaddress;

    @FindBy(id="passwd")
    @CacheLookup
    WebElement textboxPasword;

    @FindBy(id="SubmitLogin")
    @CacheLookup
    WebElement buttonLogin;


    public void setTextboxEmailaddress(String username)
    {
        textboxEmailaddress.sendKeys(username);
    }

    public void setTextboxPassword(String password)
    {
        textboxPasword.sendKeys(password);
    }

    public void clickButtonLogin()
    {
        buttonLogin.click();
    }

}
