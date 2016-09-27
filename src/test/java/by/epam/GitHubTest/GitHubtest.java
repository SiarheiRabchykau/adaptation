package by.epam.GitHubTest;

import by.epam.testLection.webDriver.HomePage;
import by.epam.testLection.webDriver.LoginPage;
import by.epam.testLection.webDriver.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GitHubtest {
    public static final String USERNAME = "SiarheiRabchykau";
    public static final String PASSWORD = "843710136Se";

    @Test
    public void loginToGit(){
        WebDriver driver = new FirefoxDriver();
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        LoginPage loginPage = startPage.signIn();
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        System.out.println(loginPage.getPageTitle());
    }
}
