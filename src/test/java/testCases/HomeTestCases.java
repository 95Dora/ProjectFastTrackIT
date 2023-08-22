package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class HomeTestCases extends BasePage {
    public HomePage homePage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        homePage.loggedInUser();
    }

    @Test
    public void check_Title(){
        homePage.check_Homepage_Title();

        Assert.assertEquals(homePage.check_Homepage_Title(),"Swag Labs");
    }

    @Test
    public void check_Sorting_Products_By_Name_From_Z_To_A() throws InterruptedException {
        homePage.click_On_Filter_Field();
        Thread.sleep(1000);
        homePage.click_On_Name_Z_to_A();
        Thread.sleep(1000);
        Assert.assertTrue(homePage.sort_Products_By_Name_From_Z_To_A());
    }

    @Test
    public void check_Sorting_Products_By_Price_From_Low_To_High() throws InterruptedException {
        homePage.click_On_Filter_Field();
        Thread.sleep(1000);
        homePage.click_On_Price_Low_To_High();
        Thread.sleep(1000);
        Assert.assertTrue(homePage.sort_Products_By_Price_From_Low_To_High());
    }

    @Test
    public void check_Sorting_Products_By_Price_From_High_To_Low() throws InterruptedException {
        homePage.click_On_Filter_Field();
        Thread.sleep(1000);
        homePage.click_On_Price_High_To_Low();
        Thread.sleep(1000);
        Assert.assertTrue(homePage.sort_Products_By_Price_From_High_To_Low());
    }

    @Test
    public void check_If_The_Number_Of_Products_From_CartBadge_Is_Equal_To_Products_Added_In_The_Cart() throws InterruptedException {
        String nrOfProducts = homePage.click_On_All_Add_To_Cart_Buttons();

        Assert.assertEquals(nrOfProducts, homePage.check_Number_Of_Products_From_CartBadge());
    }

    @Test
    public void check_If_The_Name_Of_First_Add_To_Cart_Button_Is_Changed_After_Click() {
        homePage.click_On_First_Add_To_Cart_Button();

        Assert.assertEquals(homePage.get_First_Add_To_Cart_Button_Name_After_Click(), "Remove");
    }

    @Test
    public void check_First_Remove_Button() throws InterruptedException {
        homePage.click_On_First_Add_To_Cart_Button();
        Assert.assertTrue(homePage.check_Shopping_Cart_Badge());
        Thread.sleep(500);

        homePage.click_On_First_Remove_Button();
        Assert.assertFalse(homePage.check_Shopping_Cart_Badge());
    }

    @Test
    public void check_The_LinkName_Of_First_Product() throws InterruptedException {
        homePage.click_On_First_Product_LinkName();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4");
    }

    @Test
    public void check_If_The_Back_to_products_Button_Turn_The_User_To_Home_Page() throws InterruptedException {
        homePage.click_On_First_Product_LinkName();
        Thread.sleep(1000);
        homePage.click_On_Back_To_Products_Button();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void check_The_Image_Of_Second_Product() throws InterruptedException {
        homePage.click_On_Image_Of_Second_Product();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=0");

    }


    }



