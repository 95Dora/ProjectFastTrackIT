package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerMenuPage extends BasePage{
    private LoginPage loginPage;

    public BurgerMenuPage(WebDriver driver) {
         super(driver);
        loginPage = new LoginPage(driver);
    }

    public void loggedInUser() {
        loginPage.click_On_Username_Field();
        loginPage.enter_Standard_User_In_The_Field();
        loginPage.click_On_Password_Field();
        loginPage.enter_Correct_Password_In_The_Field();
        loginPage.click_On_Login_Button();
    }

    By BurgerMenuIcon = By.id("react-burger-menu-btn");
    public void click_On_Burger_Menu_Icon() {
        driver.findElement(BurgerMenuIcon).click();
    }

    By BurgerMenu = By.cssSelector("#menu_button_container > div > div.bm-menu-wrap > div.bm-menu");
    public boolean Burger_Menu_Is_Displayed(){
        return driver.findElement(BurgerMenu).isDisplayed();
    }

    By BurgerMenuXButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[2]/div/button");
    public void click_On_Burger_Menu_X_Button() {
        driver.findElement(BurgerMenuXButton).click();
    }
    By AllItems = By.id("inventory_sidebar_link");
    public void click_On_All_Items() {
        driver.findElement(AllItems).click();
    }

    By About = By.id("about_sidebar_link");
    public void click_On_About() {
        driver.findElement(About).click();
    }

    By Logout = By.id("logout_sidebar_link");
    public void click_On_Logout() {
        driver.findElement(Logout).click();
    }

    By ResetAppState = By.id("reset_sidebar_link");
    public void click_On_Reset_App_State() {
        driver.findElement(ResetAppState).click();
    }

    By AddToCart1 = By.id("add-to-cart-sauce-labs-backpack");
    public void click_On_Add_To_Cart_1() {
        driver.findElement(AddToCart1).click();
    }

    By ShoppingCartBadge = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span");
    public boolean shopping_Cart_Badge_is_Displayed() {
        try {
            boolean cartBadgeIsDisplayed = driver.findElement(ShoppingCartBadge).isDisplayed();
            return cartBadgeIsDisplayed;
        } catch (Exception e) {
            return false;
        }
    }

    By Item1 = By.linkText("Sauce Labs Backpack");
    public void click_On_Item_1() {
        driver.findElement(Item1).click();
    }
}