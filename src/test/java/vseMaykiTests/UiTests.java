package vseMaykiTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.vsemaykiPages.*;

public class UiTests extends BaseTest {

    @BeforeMethod
    public void preconditions(){
        get(HomePage.class)
                .open()
                .clickCookies()
                .clickSubmitCountry();
    }

    @Test(priority = 1, description = "Check max length of the search field")
    public void maxLengthSearchFieldTest() {
        get(HomePage.class)
                .clickSearch()
                .checkMaxLength();
    }

    @Test(priority = 2, description = "Check the dialog window is displayed")
    public void chooseLocationTest() {
        get(HomePage.class)
                .chooseLocation();
    }

    @Test(priority = 3, description = "Check the popup window is displayed")
    public void popUpTest() {
        get(HomePage.class)
                .clickProduct();
        get(ProductPage.class)
                .checkPopUp();
    }

    @Test(priority = 4, description = "Check full and empty basket")
    public void shoppingCartTest() {
        get(HomePage.class)
                .clickManWear();
        get(ManWearPage.class)
                .clickMenTshirts();
        get(CatalogPage.class)
                .clickProduct();
        get(ProductPage.class)
                .addToBasket()
                .moveToBasket();
        get(ShoppingCartPage.class)
                .checkProductInBasket()
                .deleteProductFromBasket()
                .checkEmptyBasket();
    }

    @Test(priority = 5, description = "Check quantity of products in the basket. Limit value")
    public void checkLimitValueTest() {
        get(HomePage.class)
                .clickManWear();
        get(ManWearPage.class)
                .clickMenTshirts();
        get(CatalogPage.class)
                .clickProduct();
        get(ProductPage.class)
                .addToBasket()
                .moveToBasket();
        get(ShoppingCartPage.class)
               // .checkNumberOfProducts("0","1")
                .checkNumberOfProducts("10","10");
              //  .checkNumberOfProducts("100","99");

    }

    @Test(priority = 6, description = "Check using uploading file")
    public void addOwnDesignTest() {
        get(HomePage.class)
                .clickOwnDesignProduct();
        get(OwnDesignPage.class)
                .clickCloseWindow()
                .uploadImg()
                .checkFileUploaded();
    }

    @Test(priority = 7, description = "Incorrect data")
    public void invalidDataTest() {
        get(HomePage.class)
                .inputRegistrationData()
                .checkInvalidData();
    }

}
