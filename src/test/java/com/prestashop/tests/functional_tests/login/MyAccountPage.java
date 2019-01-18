package com.prestashop.tests.functional_tests.login;

import com.prestashop.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountPage {

    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath ="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
public WebElement accountOwnerName;

    @FindBy(xpath = "//*[@id='center_column']/div/div[1]/ul/li[4]/a/span")
    public WebElement myPersonalInfoLink;

    @FindBy(xpath = "//*[@id='center_column']/div/div[1]/ul/li[3]/a/span")
    public WebElement myAddressesLink;

public String getTitle(){
        return Driver.getDriver().getTitle();
}

public String getAccountOwnerName(){
        return accountOwnerName.getText();
}





    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    //@AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


    @Test
    public void loginAccount() {

        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("cakm@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("12345");
        driver.findElement(By.id("SubmitLogin")).click();
        String title= driver.getTitle();
        Assert.assertTrue(title.contains("My account"));

        String name= driver.findElement(By.xpath("//span[.='mm cx']")).getText();
        System.out.println(name);
        Assert.assertEquals(name,"mm cx");

    }


    @Test
    public void myAddresses(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("cakm@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("12345");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("//span[.='My addresses']")).click();
        driver.findElement(By.xpath("//*[@id=\'center_column\']/div[2]/a/span")).click();

        String firstName= driver.findElement(By.id("firstname")).getAttribute("value");
        String lastName= driver.findElement(By.id("lastname")).getAttribute("value");
        String fullName=firstName+" "+lastName;
        System.out.println(fullName);

        String displayedName=driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/div/div/nav/div[1]/a/span")).getText();
        System.out.println(displayedName);
    Assert.assertEquals(fullName,displayedName);

        driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.xpath("//*[@id=\'submitAddress\']/span")).click();

    String alert= driver.findElement(By.xpath("//*[@id=\'center_column\']/div/div/ol/li[1]")).getText();
        //System.out.println(alert);
        Assert.assertEquals(alert,"firstname is required.");
    }





}


//Tests below transported to TestSmoke.java
//Login: my accountFINISHED
//1. Gotohttp://automationpractice.com/index.php 2. ClickSigninlink
//3. Login using valid username and password
//4. Verify that title contains My account
//5. VerifythataccountholderfullnameisdisplayednexttotheSignoutlink



//Login: My personal information
//6. ClickonMypersonalinformationbutton
//7. VerifytitlecontainsIdentity
//8. Verifythatfirstnameandlastnamematchesthefullnameontop 9. ClickonSavebutton
//10. Verify error message “The password you entered is incorrect.”
//11. Click on Back to your account
//12. Verify that title contains My account


//Login: My addresses
//13. Click on My addresses
//14. Click on Add a new address
//15. Verify that first name and last name matches the full name on top
//16. Delete the first name
//17. Click save
//18. Verify error message “firstname is required.”