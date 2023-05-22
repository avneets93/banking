package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VerifyLogin extends BaseTest {

    @Test(dataProvider = "credentials")
    public static void Login(String username, String pass) {
        driver.findElement(By.name(loc.getProperty("username"))).sendKeys(username);
        driver.findElement(By.name(loc.getProperty("password"))).sendKeys(pass);
        driver.findElement(By.name(loc.getProperty("login"))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String headerMessage = driver.findElement(By.xpath(loc.getProperty("header"))).getText();
        String expectedMessage = "Manger Id : " + username;
        Assert.assertEquals(headerMessage, expectedMessage);

    }
    @DataProvider(name="credentials")
    public Object[][] testData(){
        return new Object[][]{
                {"mngr504391","qazUmad"}
        };
    }

}
