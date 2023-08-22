package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;

public class CartTestCases extends BasePage {

    public CartPage cartPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        cartPage = new CartPage(driver);
        cartPage.loggedInUser();
    }

    @Test
    public void check_The_Cart_Button() throws InterruptedException {
        cartPage.click_On_Cart_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.check_Second_Header_Title(), "Your Cart");
    }

    @Test
    public void check_The_Continue_Shopping_Button() throws InterruptedException {
        cartPage.click_On_Cart_Button();
        Thread.sleep(500);
        cartPage.click_On_Continue_Shopping_Button();
        Thread.sleep(500);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void check_If_The_Cart_Will_Contain_Same_Products_As_The_User_Added() {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Continue_Shopping_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();

        Assert.assertTrue(cartPage.check_If_Product1_Name_Is_Displayed());
        Assert.assertTrue(cartPage.check_If_Product2_Name_Is_Displayed());
    }

    @Test
    public void check_If_The_Cart_Will_Contain_Same_Number_Of_Products_As_The_User_Added() throws InterruptedException {
        cartPage.click_On_Last_X_Add_To_Cart_Buttons(4);
        Thread.sleep(500);
        cartPage.click_On_Cart_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.get_Number_Of_Products_From_The_Cart(), 4);
    }

    @Test
    public void check_If_User_Can_Remove_Products_From_The_Cart() throws InterruptedException {
        cartPage.click_On_First_X_Add_To_Cart_Buttons(3);
        Thread.sleep(500);
        cartPage.click_On_Cart_Button();
        Thread.sleep(500);
        cartPage.homePage.click_On_First_Remove_Button();
        Thread.sleep(500);
        cartPage.homePage.click_On_Second_Remove_Button();
        Thread.sleep(500);

       Assert.assertEquals(cartPage.get_Number_Of_Products_From_The_Cart(), 1);
    }

    @Test
    public void check_The_Checkout_Button() throws InterruptedException {
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.check_Second_Header_Title(), "Checkout: Your Information");
    }

    @Test
    public void check_The_Continue_Button_After_User_Has_Added_Two_Products_In_The_Cart_And_Left_The_Input_Fields_Empty() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        cartPage.click_On_Continue_Button();
        Thread.sleep(500);

        Assert.assertTrue(cartPage.check_If_Error_Message_Is_Displayed());
    }

    @Test
    public void check_The_Error_Message_After_User_Has_Completed_Only_The_First_Name_Field() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        cartPage.enter_First_Name();
        cartPage.click_On_Continue_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.check_Error_Message(), "Error: Last Name is required");
    }

    @Test
    public void check_The_Error_Message_After_User_Has_Completed_Only_The_Last_Name_Field() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        cartPage.enter_Last_Name();
        cartPage.click_On_Continue_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.check_Error_Message(), "Error: First Name is required");
    }

    @Test
    public void check_The_Error_Message_After_User_Has_Completed_The_First_Name_And_Last_Name_Fields() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        cartPage.enter_First_Name();
        cartPage.enter_Last_Name();
        cartPage.click_On_Continue_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.check_Error_Message(), "Error: Postal Code is required");
    }

    @Test
    public void check_The_Error_Message_X_Button() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        cartPage.enter_Postal_Code();
        cartPage.click_On_Continue_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.check_Error_Message(), "Error: First Name is required");

        cartPage.click_On_Error_Message_X_Button();
        Thread.sleep(500);

        Assert.assertFalse(cartPage.check_If_Error_Message_Is_Displayed());
    }

    @Test
    public void check_The_Cancel_Button_From_Checkout_Your_Information_Page() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        Thread.sleep(500);
        cartPage.click_On_Cancel_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.check_Second_Header_Title(), "Your Cart");
    }

    @Test
    public void check_The_Continue_Button_After_User_Has_Added_Two_Products_In_The_Cart_And_Has_Completed_The_Input_Fields() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        cartPage.enter_First_Name();
        cartPage.enter_Last_Name();
        cartPage.enter_Postal_Code();
        cartPage.click_On_Continue_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.check_Second_Header_Title(), "Checkout: Overview");
    }

    @Test
    public void check_The_Cancel_Button_From_Checkout_Overview_Page() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        cartPage.enter_First_Name();
        cartPage.enter_Last_Name();
        cartPage.enter_Postal_Code();
        cartPage.click_On_Continue_Button();
        cartPage.click_On_Cancel_Button();
        Thread.sleep(500);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void check_The_Sum_Of_The_Items_From_The_Cart() {

    }

    @Test
    public void check_The_Finish_Button_From_Checkout_Overview_Page() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        cartPage.enter_First_Name();
        cartPage.enter_Last_Name();
        cartPage.enter_Postal_Code();
        cartPage.click_On_Continue_Button();
        cartPage.click_On_Finish_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.check_Second_Header_Title(), "Checkout: Complete!");
    }

    @Test
    public void verify_The_Message_Shown_After_Finishing_The_Purchase() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        cartPage.enter_First_Name();
        cartPage.enter_Last_Name();
        cartPage.enter_Postal_Code();
        cartPage.click_On_Continue_Button();
        cartPage.click_On_Finish_Button();
        Thread.sleep(500);

        Assert.assertEquals(cartPage.check_After_Finish_Message1(), "Thank you for your order!");
        Assert.assertEquals(cartPage.check_After_Finish_Message2(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @Test
    public void check_The_Back_Home_Button() throws InterruptedException {
            cartPage.homePage.click_On_First_Add_To_Cart_Button();
            cartPage.homePage.click_On_Second_Add_To_Cart_Button();
            cartPage.click_On_Cart_Button();
            cartPage.click_On_Checkout_Button();
            cartPage.enter_First_Name();
            cartPage.enter_Last_Name();
            cartPage.enter_Postal_Code();
            cartPage.click_On_Continue_Button();
            cartPage.click_On_Finish_Button();
            cartPage.click_On_Back_To_Home_Button();
            Thread.sleep(500);

            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void check_If_After_Finishing_The_Purchase_The_Cart_Is_Empty() throws InterruptedException {
        cartPage.homePage.click_On_First_Add_To_Cart_Button();
        cartPage.homePage.click_On_Second_Add_To_Cart_Button();
        cartPage.click_On_Cart_Button();
        cartPage.click_On_Checkout_Button();
        cartPage.enter_First_Name();
        cartPage.enter_Last_Name();
        cartPage.enter_Postal_Code();
        cartPage.click_On_Continue_Button();
        cartPage.click_On_Finish_Button();
        Thread.sleep(500);

        Assert.assertFalse(cartPage.homePage.check_Shopping_Cart_Badge());
    }


    }
