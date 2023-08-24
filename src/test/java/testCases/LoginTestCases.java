package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

public class LoginTestCases extends BasePage {
    public LoginPage loginPage;

     @BeforeMethod
     public void setUp() {
         super.setUp();
         loginPage = new LoginPage(driver);
     }

    @Test
    public void login_As_A_Standard_User() throws InterruptedException {
         loginPage.click_On_Username_Field();
         loginPage.enter_Standard_User_In_The_Field();
         loginPage.click_On_Password_Field();
         loginPage.enter_Correct_Password_In_The_Field();
         loginPage.click_On_Login_Button();
         Thread.sleep(1000);

         Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void login_As_A_Locked_Out_User() {
        loginPage.click_On_Username_Field();
        loginPage.enter_Locked_Out_User_In_The_Field();
        loginPage.click_On_Password_Field();
        loginPage.enter_Correct_Password_In_The_Field();
        loginPage.click_On_Login_Button();
        String message = loginPage.check_Error_Message_Text();

        Assert.assertEquals(message, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void login_As_A_Problem_User() throws InterruptedException {
        loginPage.click_On_Username_Field();
        loginPage.enter_Problem_User_In_The_Field();
        loginPage.click_On_Password_Field();
        loginPage.enter_Correct_Password_In_The_Field();
        loginPage.click_On_Login_Button();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void login_As_A_Performance_Glitch_User() throws InterruptedException {
        loginPage.click_On_Username_Field();
        loginPage.enter_Performance_Glitch_User_In_The_Field();
        loginPage.click_On_Password_Field();
        loginPage.enter_Correct_Password_In_The_Field();
        loginPage.click_On_Login_Button();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void leave_The_Fields_Empty_Then_Click_Login_Button() {
        loginPage.click_On_Login_Button();
        String message = loginPage.check_Error_Message_Text();

        Assert.assertEquals(message, "Epic sadface: Username is required");
    }

    @Test
    public void enter_Only_The_Username_Then_Click_Login_Button() {
        loginPage.enter_Standard_User_In_The_Field();
        loginPage.click_On_Login_Button();
        String message = loginPage.check_Error_Message_Text();

        Assert.assertEquals(message, "Epic sadface: Password is required");
    }

    @Test
    public void enter_Only_The_Password_Then_Click_Login_Button() {
        loginPage.enter_Correct_Password_In_The_Field();
        loginPage.click_On_Login_Button();
        String message = loginPage.check_Error_Message_Text();

        Assert.assertEquals(message, "Epic sadface: Username is required");
    }

    @Test
    public void enter_Wrong_Username_And_Password_Then_Click_Login_Button() {
        loginPage.click_On_Username_Field();
        loginPage.enter_Wrong_Username_In_The_Field();
        loginPage.click_On_Password_Field();
        loginPage.enter_Wrong_Password_In_The_Field();
        loginPage.click_On_Login_Button();
        String message = loginPage.check_Error_Message_Text();

        Assert.assertEquals(message, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void check_Error_Message_X_Button() {
         loginPage.click_On_Login_Button();
         loginPage.click_On_Error_Message_X_Button();

         Assert.assertFalse(loginPage.check_Error_Message());
    }
}