package by.epam.testLection.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    private static final String Url = "https://github.com/";
    private WebDriver driver;

    @FindBy(xpath = "a//[text() = 'Sign in']")
    private WebElement buttonSignIn;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {

        this.driver.get(Url);
    }

    public LoginPage signIn() {
        buttonSignIn.click();
        return new LoginPage(driver);
    }

}
