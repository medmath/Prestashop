package com.prestashop.tests.smoke_tests;

import com.prestashop.tests.functional_tests.cart.IFramed;
import com.prestashop.tests.functional_tests.login.AddressPage;
import com.prestashop.tests.functional_tests.cart.HomePage;
import com.prestashop.tests.functional_tests.login.LoginPage;
import com.prestashop.tests.functional_tests.login.MyAccountPage;
import com.prestashop.tests.functional_tests.login.YourPersonalInfoPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsSmoke extends TestBase {
    HomePage homePage=new HomePage();
    MyAccountPage myAccountPage =new MyAccountPage();
    AddressPage addressPage=new AddressPage();
    LoginPage loginPage=new LoginPage();
    YourPersonalInfoPage yourPersonalInfoPage=new YourPersonalInfoPage();
    ProductInfoPage productInfoPage=new ProductInfoPage();
    IFramed iFramed= new IFramed();

    @Test
    public void loginMyAccount(){
        driver.get(ConfigurationReader.getProperty("url"));
        //homePage.open();
        homePage.signIn();
        loginPage.registeredInfo("cakmak2014@gmail.com","abc123");
        Assert.assertTrue(myAccountPage.getTitle().contains("My account"));
        Assert.assertEquals(myAccountPage.getAccountOwnerName(),"Tom Hanks");
    }

    @Test
    public void myPersonalInfo(){
        loginMyAccount();
        myAccountPage.myPersonalInfoLink.click();
        Assert.assertTrue(myAccountPage.getTitle().contains("Identity"));
        Assert.assertEquals(yourPersonalInfoPage.accountOwnername.getText(),"Tom Hanks");
        yourPersonalInfoPage.saveButton.click();
        Assert.assertEquals(yourPersonalInfoPage.errorMessageAfterSaving.getText(),"The password you entered is incorrect.");
        yourPersonalInfoPage.backToYourAccountButton.click();
        Assert.assertTrue(myAccountPage.getTitle().contains("My account"));

    }

    @Test
    public void myAddresses(){
        loginMyAccount();
        myAccountPage.myAddressesLink.click();
        addressPage.addANewaddress.click();
        Assert.assertEquals(addressPage.firstName.getAttribute("value"),"Tom");
        Assert.assertEquals(addressPage.lastName.getAttribute("value"),"Hanks");
        addressPage.firstName.clear();
        addressPage.saveButton.click();
        Assert.assertEquals(addressPage.afterDeletedErrorMessage.getText(),"firstname is required.");

    }

    //without sign, click certain dress..//Product information - price:
    @Test
    public void productInfoAndPrice(){
        driver.get(ConfigurationReader.getProperty("url"));
        //homePage.open();
        String price1=homePage.price(3);
        homePage.clickA_DressByXpath(3).click();
        String price2=productInfoPage.productPrice();
        //System.out.println(price1+", "+price2);
        Assert.assertEquals(price1,price2);
    }


    @Test
    public void productInfoDetails(){
        driver.get(ConfigurationReader.getProperty("url"));
        //homePage.open();
        homePage.clickA_DressByXpath(3).click();
        int quantity=Integer.parseInt(productInfoPage.defaultQuantity.getAttribute("value"));
         Assert.assertEquals(quantity,1);
        Assert.assertEquals(productInfoPage.selectSize(),"S");
        Assert.assertEquals(productInfoPage.sizeOptions(),"SML");

    }



    //Product information – Add to cart:
//7. ClickonAddtocart
//8. Verifyconfirmationmessage“Productsuccessfullyaddedtoyourshopping
//cart” --> Verify edilemedi
//9. thatdefaultquantityis1---> Verify edilemedi

    //10. Verify that default size is S--> Verify edilemedi
//11. Verify that same name and price displayed as on the home page-->
    @Test//It si not finished yet

    public void addToCart(){
        driver.get(ConfigurationReader.getProperty("url"));
        //homePage.open();
        homePage.clickA_DressByXpath(2).click();
        //homePage.addDifferentProduct(2);
        //System.out.println(productInfoPage.addedToCardMessage.isEnabled());

//        String message = productInfoPage.addedToCardMessage.getText();
//        System.out.println(message);
        //iFramed.setiFrameChange();
        //productInfoPage.checkoutProceed.click();
    }

}
