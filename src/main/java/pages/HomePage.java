package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage{
    private LoginPage loginPage;

    public HomePage(WebDriver driver) {
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

    By HomepageTitle = By.cssSelector("#header_container > div.primary_header > div.header_label > div");
    public String check_Homepage_Title(){return driver.findElement(HomepageTitle).getText();}

    By FilterField = By.cssSelector("#header_container > div.header_secondary_container > div > span");
    public void click_On_Filter_Field() {driver.findElement(FilterField).click();}

    By SortAtoZ = By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(1)");
    public void click_On_Name_A_to_Z() {driver.findElement(SortAtoZ).click();}

    By SortZtoA = By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(2)");
    public void click_On_Name_Z_to_A() {driver.findElement(SortZtoA).click();}

    By SortLowToHigh = By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(3)");
    public void click_On_Price_Low_To_High() {driver.findElement(SortLowToHigh).click();}

    By SortHighToLow = By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(4)");
    public void click_On_Price_High_To_Low() {driver.findElement(SortHighToLow).click();}

    By linkNameProduct1 = By.id("item_4_title_link");
    By linkNameProduct2 = By.id("item_0_title_link");

    public boolean sort_Products_By_Name_From_Z_To_A() {
        ArrayList<String> obtainedList = new ArrayList<>();

        List<WebElement> itemsNames = driver.findElements(By.cssSelector("[class='inventory_item_name']"));

        for(WebElement item:itemsNames) {
            obtainedList.add(item.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();

        for(String itemName:obtainedList) {
            sortedList.add(itemName);
        }

        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        return sortedList.equals(obtainedList);
    }

    public boolean sort_Products_By_Name_From_A_To_Z() {
        ArrayList<String> obtainedList = new ArrayList<>();

        List<WebElement> itemsNames = driver.findElements(By.cssSelector("[class='inventory_item_name']"));

        for(WebElement item:itemsNames) {
            obtainedList.add(item.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();

        for(String itemName:obtainedList) {
            sortedList.add(itemName);
        }

        Collections.sort(sortedList);

        return sortedList.equals(obtainedList);
    }

    public boolean sort_Products_By_Price_From_Low_To_High() {
        ArrayList<Float> obtainedList = new ArrayList<>();

        List<WebElement> itemsPrices = driver.findElements(By.cssSelector("[class='inventory_item_price']"));

        for(WebElement item:itemsPrices) {
            String name = item.getText();
            String without$ = name.substring(1);
            Float convertedValue = Float.valueOf(without$);
            obtainedList.add(convertedValue);
        }

        ArrayList<Float> sortedList = new ArrayList<>();

        for(Float itemPrice:obtainedList) {
            sortedList.add(itemPrice);
        }

        Collections.sort(sortedList);

        return sortedList.equals(obtainedList);
    }

    public boolean sort_Products_By_Price_From_High_To_Low() {
        ArrayList<Float> obtainedList = new ArrayList<>();

        List<WebElement> itemsPrices = driver.findElements(By.cssSelector("[class='inventory_item_price']"));

        for(WebElement item:itemsPrices) {
            String name = item.getText();
            String without$ = name.substring(1);
            Float convertedValue = Float.valueOf(without$);
            obtainedList.add(convertedValue);
        }

        ArrayList<Float> sortedList = new ArrayList<>();

        for(Float itemPrice:obtainedList) {
            sortedList.add(itemPrice);
        }

        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        return sortedList.equals(obtainedList);
    }

  public String click_On_All_Add_To_Cart_Buttons() throws InterruptedException {
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("[class='btn btn_primary btn_small btn_inventory']"));

        for (WebElement addToCart:addToCartButtons) {
            addToCart.click();
            Thread.sleep(500);
        }
      return "" + addToCartButtons.size();
  }

    By ShoppingCartBadge = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span");

    public String check_Number_Of_Products_From_CartBadge(){
        return driver.findElement(ShoppingCartBadge).getText();
    }

    By AddToCartButton1 = By.id("add-to-cart-sauce-labs-backpack");
    By AddToCartButton2 = By.id("add-to-cart-sauce-labs-bike-light");

    public void click_On_First_Add_To_Cart_Button() {driver.findElement(AddToCartButton1).click();}
    public void click_On_Second_Add_To_Cart_Button() {driver.findElement(AddToCartButton2).click();}

    By RemoveButton1 = By.id("remove-sauce-labs-backpack");
    By RemoveButton2 = By.id("remove-sauce-labs-bike-light");

    public void click_On_First_Remove_Button() {driver.findElement(RemoveButton1).click();}
    public void click_On_Second_Remove_Button() {driver.findElement(RemoveButton2).click();}

    public String get_First_Add_To_Cart_Button_Name_After_Click() {
        return driver.findElement(RemoveButton1).getText();
    }

    public boolean check_Shopping_Cart_Badge() {
        try {
            boolean isDisplayed = driver.findElement(ShoppingCartBadge).isDisplayed();
            return isDisplayed;
        } catch (Exception e) {
            return false;
        }
    }

    public void click_On_First_Product_LinkName() {driver.findElement(linkNameProduct1).click();}

    By backToProductsButton = By.id("back-to-products");

    public void click_On_Back_To_Products_Button() {driver.findElement(backToProductsButton).click();}

    By imageProduct2 = By.id("item_0_img_link");

    public void click_On_Image_Of_Second_Product() {driver.findElement(imageProduct2).click();}
}