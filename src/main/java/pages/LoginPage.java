package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {super(driver);}

   By UsernameField = By.id("user-name");
    public void click_On_Username_Field() {
        driver.findElement(UsernameField).click();
    }
    public void enter_Correct_Username_In_The_Field() {
        driver.findElement(UsernameField).sendKeys("standard_user");
    }
    public void enter_Wrong_Username_In_The_Field() {
        driver.findElement(UsernameField).sendKeys("just_an_user");
    }

    By PasswordField = By.id("password");
    public void click_On_Password_Field() {
        driver.findElement(PasswordField).click();
    }
    public void enter_Correct_Password_In_The_Field() {
        driver.findElement(PasswordField).sendKeys("secret_sauce");
    }
    public void enter_Wrong_Password_In_The_Field() {
        driver.findElement(PasswordField).sendKeys("wrong_password");
    }

    By LoginButton = By.id("login-button");
    public void click_On_Login_Button() {
        driver.findElement(LoginButton).click();
    }

    By ErrorMessageContainer = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3");
    public String checkErrorMessage() {
        String errorMessage = driver.findElement(ErrorMessageContainer).getText();
        return errorMessage;
    }
}
