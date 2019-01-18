package com.prestashop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;

    @BeforeClass
    public void setUpClass(){
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public void setUpMethod(){
        //driver = new ChromeDriver();
        //driver=new FirefoxDriver();
       driver= Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();
        actions = new Actions(driver);
        softAssert= new SoftAssert();



    }



    //@AfterMethod
    public void tearDownMethod() {
        driver.quit();

        softAssert.assertAll();
    }
}








