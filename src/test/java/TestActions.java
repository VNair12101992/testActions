import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestActions {
    WebDriver driver;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver=WebDriverManager.chromedriver().create();
    }

    @Test
    public void checkTest(){


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://webdriveruniversity.com/index.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("automation-test-store")));
        System.out.println(driver.getTitle());
           }

    @After
    public void afterTest(){
        if (driver!=null)
            driver.quit();
    }

}
