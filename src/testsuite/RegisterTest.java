package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldnavigateToRegisterPageSuccessfully(){
        WebElement Register = driver.findElement(By.linkText("Register"));
        Register.click();
        String expectedErrorMessage = "Register";
        // Find errormessage and get the message
        String actualErrorMessage = driver.findElement(By.xpath("//a[text()='Register ']")).getText();
        Assert.assertEquals("Register", expectedErrorMessage,actualErrorMessage);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        WebElement Register = driver.findElement(By.linkText("Register"));
        Register.click();
        WebElement Gender = driver.findElement(By.id("gender-female"));
        Gender.click();
        // Find first name field
        WebElement fristnameField = driver.findElement(By.id("FirstName"));
        fristnameField.sendKeys("Prime");
        // find the last name field
        WebElement lastnameField = driver.findElement(By.id("LastName"));
        lastnameField.sendKeys("Testing");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("1");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("Jan");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("2000");

        // Find the email field and enter the email address
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Prime999@gmail.come");
        //Find the password field and enter the password
        driver.findElement(By.name("Password")).sendKeys("Prime123");
        // Find confirm password and type the password to confirm it
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Prime123");
        WebElement Register_button = driver.findElement(By.linkText("Register"));
        Register_button.click();
        String expectedText = "Your registration completed";
        // find the actual text and get the text from it
        WebElement actualtTextElement = driver.findElement(By.xpath("//div[@class='result']"));
        String actualText = actualtTextElement.getText();
        // verify expected and actual text
        Assert.assertEquals("Your registration completed", expectedText,actualText);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
