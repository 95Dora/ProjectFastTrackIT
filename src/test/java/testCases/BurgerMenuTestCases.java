package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BurgerMenuPage;

public class BurgerMenuTestCases extends BasePage {
    public BurgerMenuPage burgerMenuPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        burgerMenuPage = new BurgerMenuPage(driver);
        burgerMenuPage.loggedInUser();
    }

    @Test
    public void check_Burger_Menu() {
        burgerMenuPage.click_On_Burger_Menu_Icon();
        burgerMenuPage.Burger_Menu_Is_Displayed();

        Assert.assertTrue(burgerMenuPage.Burger_Menu_Is_Displayed());
    }

    @Test
    public void close_Burger_Menu() throws InterruptedException {
        burgerMenuPage.click_On_Burger_Menu_Icon();
        Thread.sleep(1000);
        burgerMenuPage.click_On_Burger_Menu_X_Button();
        Thread.sleep(1000);

        Assert.assertFalse(burgerMenuPage.Burger_Menu_Is_Displayed());
    }

    @Test
    public void check_All_Items_sidebar_link() throws InterruptedException {
        burgerMenuPage.click_On_Item_1();
        burgerMenuPage.click_On_Burger_Menu_Icon();
        Thread.sleep(1000);
        burgerMenuPage.click_On_All_Items();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void check_About_sidebar_link() throws InterruptedException {
        burgerMenuPage.click_On_Burger_Menu_Icon();
        Thread.sleep(1000);
        burgerMenuPage.click_On_About();

        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
    }

    @Test
    public void check_Logout_sidebar_link() throws InterruptedException {
        burgerMenuPage.click_On_Burger_Menu_Icon();
        Thread.sleep(1000);
        burgerMenuPage.click_On_Logout();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test
    public void check_Reset_App_State_sidebar_link() throws InterruptedException {
      burgerMenuPage.click_On_Add_To_Cart_1();

      Assert.assertTrue(burgerMenuPage.shopping_Cart_Badge_is_Displayed());

      burgerMenuPage.click_On_Burger_Menu_Icon();
      Thread.sleep(1000);
      burgerMenuPage.click_On_Reset_App_State();

      Assert.assertFalse(burgerMenuPage.shopping_Cart_Badge_is_Displayed());
    }

}
