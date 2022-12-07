package vseMaykiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.vsemaykiPages.CatalogPage;
import pageObjects.vsemaykiPages.HomePage;
import pageObjects.vsemaykiPages.ManWearPage;
import pageObjects.baseObjects.BaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;


public class ApiTests extends BaseTest {

    @BeforeTest
    public void precondition() {
        baseURI = properties.getProperty("api");
    }

    @Test(description = "Check name of the t-shirt")
    public void checkNameOfProductGetTest() {
        get(HomePage.class)
                .open()
                .clickCookies()
                .clickSubmitCountry()
                .clickManWear();
        get(ManWearPage.class)
                .clickMenTshirts();

        int index = 0;
        String nameOfItem = get(CatalogPage.class).getNameOfItem(index);

        Response response = given().get("/catalog/items?filter[category]=man_tshirts&sort=sell&limit=36");
        Assert.assertEquals(response.then().extract().response().statusCode(), 200);

        String nameOfItemApi = response.then().extract().response().jsonPath()
                .getList("items.title").get(index).toString();

        Assert.assertTrue(nameOfItem.contains(nameOfItemApi));

    }

    @Test(description = "Check limit of products in the list")
    public void checkLimitOfProductsGetTest() {
        get(HomePage.class)
                .open()
                .clickManWear();
        get(ManWearPage.class)
                .clickMenTshirts();

        Response response = given().get("/catalog/items?filter[category]=man_tshirts&sort=sell&limit=36");
        int countApi = response.then().extract().response().jsonPath().getInt("limit");
        int count = get(CatalogPage.class).getNumberOfItemsOnPage();
        Assert.assertEquals(count, countApi);
    }

    @Test(description = "Check offset<0")
    public void checkOffsetGetTest() {
        Response response = given().get("/catalog/items?filter[category]=man_tshirts&sort=sell&limit=36&offset=-1");
        response.then().assertThat().statusCode(400);
        response.then().assertThat().body(matchesJsonSchema(getJsonData("errorMessage")));
    }

    @Test(description = "POST request for favourite items")
    public void checkSettingFavouriteItemPostTest() {
        Response response = given().header("Content-Type", "application/json")
                .body(getJsonData("FavouriteItems")).post(baseURI + "/rest/favorite/6a6c83d119eeb099eb1f51351b1d2482040e1b94/item");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("data.design"), "1930763");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("message"),"Item saved successfully");
    }

    public String getJsonData(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get("files/" + filename + ".json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
