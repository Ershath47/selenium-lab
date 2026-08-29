import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class SeleniumTests {

    WebDriver webDriver = new ChromeDriver();

    @Test
    public void checkWebpageTitle() {
        webDriver.navigate().to("https://selenium-testing-nu.vercel.app/");
        Assert.assertEquals("Selenium", webDriver.getTitle());
    }

    @Test
    public void checkButtonText() {
        webDriver.navigate().to("https://selenium-testing-nu.vercel.app/");
        WebElement button = webDriver.findElement(By.id("myButton"));
        Assert.assertEquals("Click Me", button.getText());
    }

    @Test
    public void checkLoginContainerClassExist() {
        webDriver.navigate().to("https://selenium-testing-nu.vercel.app/");
        WebElement loginContainer = webDriver.findElement(By.className("login-container"));
        Assert.assertNotNull(loginContainer);
    }

    @Test
    public void checkButtonNavigate() {
        webDriver.navigate().to("https://selenium-testing-nu.vercel.app/");
        WebElement button = webDriver.findElement(By.id("myButton"));
        button.click();
        Assert.assertEquals("https://selenium-testing-nu.vercel.app/new-page.html", webDriver.getCurrentUrl());
    }

    @Test
    public void checkTwoFormFieldsExist() {
        webDriver.navigate().to("https://selenium-testing-nu.vercel.app/");
        List<WebElement> formFields = webDriver.findElements(By.tagName("input"));
        Assert.assertEquals(2, formFields.size());
    }

    @Test
    public void testInvalidLogin() {
        webDriver.navigate().to("https://selenium-testing-nu.vercel.app/");
        WebElement usernameField = webDriver.findElement(By.id("username"));
        WebElement passwordField = webDriver.findElement(By.id("password"));
        usernameField.sendKeys("Test user");
        passwordField.sendKeys("password");
        WebElement loginButton = webDriver.findElement(By.id("loginBtn"));
        loginButton.click();
        WebElement alertContainer = webDriver.findElement(By.id("alert"));
        Assert.assertTrue(alertContainer.getText().contains("Invalid"));
    }

    @Test
    public void testValidLogin() {
        webDriver.navigate().to("https://selenium-testing-nu.vercel.app/");
        WebElement usernameField = webDriver.findElement(By.id("username"));
        WebElement passwordField = webDriver.findElement(By.id("password"));
        usernameField.sendKeys("admin");
        passwordField.sendKeys("test@123");
        WebElement loginButton = webDriver.findElement(By.id("loginBtn"));
        loginButton.click();
        WebElement alertContainer = webDriver.findElement(By.id("alert"));
        Assert.assertTrue(alertContainer.getText().contains("Correct"));
    }

    @Test
public void addLoginTest() {
    webDriver.navigate().to("https://selenium-testing-nu.vercel.app/");
    WebElement usernameField = webDriver.findElement(By.id("username"));
    WebElement passwordField = webDriver.findElement(By.id("password"));
    usernameField.sendKeys("admin");
    passwordField.sendKeys("test@123");
    WebElement loginButton = webDriver.findElement(By.id("loginBtn"));
    loginButton.click();
    WebElement alertContainer = webDriver.findElement(By.id("alert"));
    Assert.assertTrue(alertContainer.getText().contains("Correct"));
}

}
