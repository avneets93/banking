package base;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();
    public static FileReader fr;
    public static FileReader frloc;

    @BeforeMethod
    public void setup() throws IOException {
        if(driver == null){
            fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
            prop.load(fr);
            frloc = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locator.properties");
            loc.load(frloc);
        }
        if(prop.getProperty("browser").equals("chrome")){
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testurl"));

        }
        else if(prop.getProperty("browser").equals("firefox")){
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
