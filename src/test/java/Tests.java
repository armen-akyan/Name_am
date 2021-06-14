import api.ApiHelper;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.DriverSetUp;

public class Tests {
    @BeforeMethod
    public void drive() {
        DriverSetUp.getDriver();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.quit();
    }

    @Test
    public void loginTest() {
        JsonObject jsonObject = ApiHelper.login();
        DriverSetUp.getDriver().navigate().refresh();
        Assert.assertEquals(jsonObject.get("fullName").toString(), "\"Armen Armenakyan\"", "Login failed");
    }

    @Test
    public void checkDomainAvailable(){
        JsonObject jsonObject = ApiHelper.checkDomainAvailability();
        Assert.assertTrue(jsonObject.get("available").getAsBoolean(), "check domain availability failed");

    }

    @Test
    public void sendDomainToCart(){
        JsonObject jsonObject = ApiHelper.sendDomainToCart();
        Assert.assertNotEquals(jsonObject.get("items").getAsJsonArray().size(), 0, "send domain to cart failed");
    }
}
