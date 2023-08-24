package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {super(driver);}

    By UsernameField = By.id("user-name");
    public void click_On_Username_Field() {driver.findElement(UsernameField).click();}
    public void enter_Standard_User_In_The_Field() {driver.findElement(UsernameField).sendKeys("standard_user");}
    public void enter_Locked_Out_User_In_The_Field() {driver.findElement(UsernameField).sendKeys("locked_out_user");}
    public void enter_Problem_User_In_The_Field() {driver.findElement(UsernameField).sendKeys("problem_user");}
    public void enter_Performance_Glitch_User_In_The_Field() {driver.findElement(UsernameField).sendKeys("performance_glitch_user");}
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
    public String check_Error_Message_Text() {
        return driver.findElement(ErrorMessageContainer).getText();
    }

    By ErrorMessageXButton = By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3 > button > svg");
    public void click_On_Error_Message_X_Button() {
        driver.findElement(ErrorMessageXButton).click();
    }

    public boolean check_Error_Message() {
        try {
            boolean errorMessageIsDisplayed = driver.findElement(ErrorMessageContainer).isDisplayed();
            return errorMessageIsDisplayed;
        } catch (Exception e) {
            return false;
        }
    }
}
