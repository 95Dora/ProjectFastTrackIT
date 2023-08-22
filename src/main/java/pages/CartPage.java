package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends BasePage{

    private LoginPage loginPage;
    public HomePage homePage;
    public CartPage(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public void loggedInUser() {
        loginPage.click_On_Username_Field();
        loginPage.enter_Correct_Username_In_The_Field();
        loginPage.click_On_Password_Field();
        loginPage.enter_Correct_Password_In_The_Field();
        loginPage.click_On_Login_Button();
    }

    By CartButton = By.id("shopping_cart_container");

    public void click_On_Cart_Button() {
        driver.findElement(CartButton).click();
    }

    By secondaryHeader = By.cssSelector("#header_container > div.header_secondary_container > span");
    public String check_Second_Header_Title() {
        String secondHeaderTitle = driver.findElement(secondaryHeader).getText();
        return secondHeaderTitle;
    }

    By ContinueShoppingButton = By.id("continue-shopping");

    public void click_On_Continue_Shopping_Button() {
        driver.findElement(ContinueShoppingButton).click();
    }

    public boolean check_If_Product1_Name_Is_Displayed() {
        return driver.findElement(homePage.linkNameProduct1).isDisplayed();
    }

    public boolean check_If_Product2_Name_Is_Displayed() {
        return driver.findElement(homePage.linkNameProduct2).isDisplayed();
    }

    public void click_On_Last_X_Add_To_Cart_Buttons(int lastXelements) throws InterruptedException {
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("[class='btn btn_primary btn_small btn_inventory']"));

        for(int i=addToCartButtons.size()-1; i>=0; i--) {
            if(i>=addToCartButtons.size()-lastXelements) {
                addToCartButtons.get(i).click();
               /* WebElement addToCart = addToCartButtons.get(i);
                addToCart.click();*/
            }
        }
    }

    public int get_Number_Of_Products_From_The_Cart() {
        return driver.findElements(By.cssSelector("[class='cart_item']")).size();
    }

    public void click_On_First_X_Add_To_Cart_Buttons(int firstXelements) {
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("[class='btn btn_primary btn_small btn_inventory']"));
        for(int i=0; i<=addToCartButtons.size()-1; i++) {
            if(i<firstXelements) {
                addToCartButtons.get(i).click();
            }
        }
    }

    By CheckOutButton = By.id("checkout");
    public void click_On_Checkout_Button() {driver.findElement(CheckOutButton).click();}

    By firstNameField = By.id("first-name");
    public void enter_First_Name() {driver.findElement(firstNameField).sendKeys("Iles");}

    By lastNameField = By.id("last-name");
    public void enter_Last_Name() {driver.findElement(lastNameField).sendKeys("Dora");}

    By postalCodeField = By.id("postal-code");
    public void enter_Postal_Code() {driver.findElement(postalCodeField).sendKeys("400400");}

    By continueButton = By.id("continue");
    public void click_On_Continue_Button() {driver.findElement(continueButton).click();}

    By errorMessage = By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error");
    public boolean check_If_Error_Message_Is_Displayed() {
        try {
            boolean errorMessageIsDisplayed = driver.findElement(errorMessage).isDisplayed();
              return errorMessageIsDisplayed;
        }
        catch (Exception e) {
            return false;
        }
    }
    public String check_Error_Message() {
        String errorMess = driver.findElement(errorMessage).getText();
        return errorMess;
    }

    By errorMessageXbutton = By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3 > button");
    public void click_On_Error_Message_X_Button() {driver.findElement(errorMessageXbutton).click();}

    By cancelButton = By.id("cancel");
    public void click_On_Cancel_Button() {driver.findElement(cancelButton).click();}

    By finishButton = By.id("finish");
    public void click_On_Finish_Button() {driver.findElement(finishButton).click();}

    By afterFinishMessage1 = By.cssSelector("#checkout_complete_container > h2");
    public String check_After_Finish_Message1() {
        String finishMess1 = driver.findElement(afterFinishMessage1).getText();
        return finishMess1;
    }

    By afterFinishMessage2 = By.cssSelector("#checkout_complete_container > div");
    public String check_After_Finish_Message2() {
        String finishMess2 = driver.findElement(afterFinishMessage2).getText();
        return finishMess2;
    }

    By backHomeButton = By.id("back-to-products");
    public void click_On_Back_To_Home_Button() {driver.findElement(backHomeButton).click();}


}
