package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.MyAccount;

import java.util.concurrent.TimeUnit;

public class Steps {

    public WebDriver driver;
    public LoginPage loginPage;
    public MyAccount myAccountPage;
    public WebDriverWait webDriverWait;


    @Given("^User launch chrome browser$")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver= new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccount(driver);
    }

    @When("^User opens URL \"([^\"]*)\"$")
    public void user_opens_URL(String url)  {
         driver.navigate().to(url);
    }

    @When("^User enters email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enters_email_as_and_password_as(String email, String password) throws Throwable {
         loginPage.setTextboxEmailaddress(email);
         loginPage.setTextboxPassword(password);
    }

    @When("^Click on login$")
    public void click_on_login()  {
        loginPage.clickButtonLogin();
    }

    @Then("^Page title should be \"([^\"]*)\"$")
    public void page_title_should_be(String pageTitle)  {
        webDriverWait = new WebDriverWait(driver,10);
         Assert.assertEquals(driver.getTitle(), pageTitle) ;
         }

    @When("^User click on logout button$")
    public void user_click_on_logout_button()  {
        myAccountPage.clickSignoutLink();
    }

    @Then("^Close the browser$")
    public void close_the_browser() {
    driver.close();
    }

}
