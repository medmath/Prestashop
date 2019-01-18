package com.prestashop.tests.functional_tests.login;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
//THIS IS A DIFFRENT WEB SITE
public class WONegativeLoginTests extends TestBase {
@Test
    public void wrongUserName(){
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    softAssert.assertEquals(driver.getTitle(),"Web Orders Login");
    String firstUrl=driver.getCurrentUrl();

    WebElement userName=driver.findElement(By.id("ctl00_MainContent_username"));
    WebElement passWord=driver.findElement(By.id("ctl00_MainContent_password"));

    userName.sendKeys("Test");
    passWord.sendKeys("Test");

    driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    softAssert.assertEquals(driver.getTitle(),"Web Orders Login");
    System.out.println("done done");
    softAssert.assertAll();
    System.out.println("done");
}



@Test
    public void wrongPassword(){
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    softAssert.assertEquals(driver.getTitle(),"Web Orders Login");
    String firstUrl=driver.getCurrentUrl();

    WebElement userName=driver.findElement(By.id("ctl00_MainContent_username"));
    WebElement passWord=driver.findElement(By.id("ctl00_MainContent_password"));

    userName.sendKeys("Tester");
    passWord.sendKeys("Tester");

    driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    softAssert.assertEquals(driver.getTitle(),"Web Orders Login");
    System.out.println("done done");
    softAssert.assertAll();
    System.out.println("done");
}


@Test
    public void blankUserName(){
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    softAssert.assertEquals(driver.getTitle(),"Web Orders Login");
    String firstUrl=driver.getCurrentUrl();

    //WebElement userName=driver.findElement(By.id("ctl00_MainContent_username"));
    WebElement passWord=driver.findElement(By.id("ctl00_MainContent_password"));

    //userName.sendKeys("Tester");
    passWord.sendKeys("Tester");

    driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    softAssert.assertEquals(driver.getTitle(),"Web Orders Login");
    System.out.println("done done");
    softAssert.assertAll();
    System.out.println("done");
}


@Test
    public void blankPassWord(){
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    softAssert.assertEquals(driver.getTitle(),"Web Orders Login");
    String firstUrl=driver.getCurrentUrl();

    WebElement userName=driver.findElement(By.id("ctl00_MainContent_username"));
    //WebElement passWord=driver.findElement(By.id("ctl00_MainContent_password"));

    userName.sendKeys("Tester");
    //passWord.sendKeys("Tester");

    driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    softAssert.assertEquals(driver.getTitle(),"Web Orders Login");
    System.out.println("done done");
    softAssert.assertAll();
    System.out.println("done");
}


    public static class PositiveLoginTests extends TestBase {
    @Test
        public void positiveLoginTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");

        WebElement userName=driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passWord=driver.findElement(By.id("ctl00_MainContent_password"));

        userName.sendKeys("Tester");
        passWord.sendKeys("test");

        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertEquals(driver.getTitle(),"Web Orders");


        Assert.assertEquals(driver.getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
    }



    }
}



//Negative Login Test Wrong Username
//1. Openbrowser
//2. Gotowebsite
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/l ogin.aspx
//3. Verifytitleequals“WebOrdersLogin”
//4. Savethecurrenturl
//5. Enterusername“Test”
//6. Enterpassword“Test”
//7. ClickonLoginbutton
//8. Verifytitlestillequals“WebOrdersLogin”
//9. Verifythecurrenturlequalsthestringsavedinstep4


    //Negative Login Test Wrong Password
//1. Openbrowser
//2. Gotowebsite
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/l ogin.aspx
//3. Verifytitleequals“WebOrdersLogin”
//4. Savethecurrenturl
//5. Enterusername“Tester”
//6. Enterpassword“Tester”
//7. ClickonLoginbutton
//8. Verifytitlestillequals“WebOrdersLogin”
//9. Verifythecurrenturlequalsthestringsavedinstep4


//WO-4: Negative Login Test Blank Username
//        1. Openbrowser
//        2. Gotowebsite
//        http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/l ogin.aspx
//        3. Verifytitleequals“WebOrdersLogin”
//        4. Savethecurrenturl
//        5. Enterpassword“test”
//        6. ClickonLoginbutton
//        7. Verifytitlestillequals“WebOrdersLogin”
//        8. Verifythecurrenturlequalsthestringsavedinstep4


//Negative Login Test Blank Password
//1. Openbrowser
//2. Gotowebsite
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/l ogin.aspx
//3. Verifytitleequals“WebOrdersLogin”
//4. Savethecurrenturl
//5. Enterusername“Tester”
//6. ClickonLoginbutton
//7. Verifytitlestillequals“WebOrdersLogin”
//8. Verifythecurrenturlequalsthestringsavedinstep4