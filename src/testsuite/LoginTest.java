package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // code to navigate to the login page
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // Verify the text Welcome, Please Sign In!
        String expectedText = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = actualTextElement.getText();
        // verify expected and actual text
        Assert.assertEquals("Bot redirected to login page", expectedText, actualText);
    }


    @Test
    public void userShouldLoginPageSuccessfullyWithValidCredentials() {
        // Find the login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // Enter valid username in login field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime999@gmail.com");
        // Enter valid password in password field
        driver.findElement(By.name("Password")).sendKeys("Prime123");
        // Click on login button
       driver.findElement(By.xpath("//button[@class='button-1 login-button']\"")).click();

       String expectedErrorMessage = "log out";
       // find the errormessage and get the text in element
        String actualErrorMessage = driver.findElement(By.xpath("//a[text()='log out']")).getText();
        Assert.assertEquals("log out", expectedErrorMessage,actualErrorMessage);
    }

    @Test
    public void verifyTheErrorMessage(){
        // Find login link and click it
        WebElement loginlink = driver.findElement(By.linkText("log in"));
        loginlink.click();
        // Find the email field and type email addres in it
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime111@gmail.com");
        // Find the password field and type the password in it
        driver.findElement(By.name("Password")).sendKeys("prime123");
        // find the login button and click it
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found";
        // find the errormessage and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//div[Aclass='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Error message not display", expectedErrorMessage,actualErrorMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}