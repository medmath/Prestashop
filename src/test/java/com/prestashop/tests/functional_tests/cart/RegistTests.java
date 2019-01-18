package com.prestashop.tests.functional_tests.cart;

import com.prestashop.tests.functional_tests.login.AddressPage;
import com.prestashop.tests.functional_tests.login.LoginPage;
import com.prestashop.tests.functional_tests.login.MyAccountPage;
import com.prestashop.tests.smoke_tests.ProductInfoPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistTests extends TestBase {
    HomePage homePage=new HomePage();
    MyAccountPage MyAccountPage =new MyAccountPage();
    AddressPage addressPage=new AddressPage();
    LoginPage loginPage=new LoginPage();
    ProductInfoPage productInfoPage=new ProductInfoPage();

    @Test
    public void cartLoginTest() {
        driver.get(ConfigurationReader.getProperty("url"));

        //homePage.open();
        homePage.addProductBlouse();
        //Assert.assertEquals(homePage.setAddedToCard(),"Blouse");
        String email=ConfigurationReader.getProperty("email");
        String password=ConfigurationReader.getProperty("password");

        loginPage.registeredInfo(email,password);
        addressPage.setCartHoverOver();
        Assert.assertEquals(addressPage.setCartHoverOver(),"Blouse");
    }


    @Test
    public void logOutTest(){
        driver.get(ConfigurationReader.getProperty("url"));
        //homePage.open();
        homePage.signIn();
        String email=ConfigurationReader.getProperty("email");
        String password=ConfigurationReader.getProperty("password");

        loginPage.registeredInfo(email,password);
        loginPage.goHomePage();
        homePage.addProductBlouse();
        homePage.signOut();
        Assert.assertEquals(homePage.emptyProduct(),"(empty)");
    }


    @Test
    public void cardIconDeleteTest(){
        driver.get(ConfigurationReader.getProperty("url"));
        //homePage.open();
        homePage.addProductBlouseContinue();
        homePage.deletingProducts();
        //Assert.assertEquals(homePage.emptyProduct(),"(empty)");
        //Assert.assertEquals(homePage.deletingProducts(),"(empty)");
        Assert.assertEquals(homePage.emptyProductAfterRemove(),"(empty)");// Expected :(empty) but     Actual   :

    }


    @Test
    public void cardCheckoutDeleteTest(){
        driver.get(ConfigurationReader.getProperty("url"));
        //homePage.open();
        homePage.addProductBlouseContinue();

        homePage.addDifferentProduct(2);
        homePage.proceedCheckout();
        Assert.assertEquals(homePage.messageAfterCheckOut(), "Your shopping cart contains: 2 Products");
        homePage.deletingProducts();
        //homePage.messageAfterCheckOut();
        softAssert.assertEquals(homePage.messageAfterCheckOutNewQuantity(),
                "Your shopping cart contains: 1 Product");//bu ariza verdi
        System.out.println(homePage.messageAfterCheckOutNewQuantity());
        homePage.deletingSecondProducts();

    }


    @Test
    public void cartDetails(){
        driver.get(ConfigurationReader.getProperty("url"));
        //homePage.open();
        homePage.clickA_DressByXpath(4).click();
        productInfoPage.incrementQuantity.click();
        productInfoPage.incrementQuantity.click();
        productInfoPage.chooseSize("L");
        productInfoPage.addToCart.click();
        productInfoPage.windowFull();
        String message=productInfoPage.addedToCardMessage.getText();
        System.out.println(message);
        productInfoPage.checkoutProceed.click();
        productInfoPage.logo.click();
        homePage.clickA_DressByXpath(2).click();
        productInfoPage.incrementQuantity.click();
        productInfoPage.incrementQuantity.click();
        productInfoPage.incrementQuantity.click();
        productInfoPage.chooseSize("S");
        productInfoPage.addToCart.click();
        productInfoPage.xButton.click();
        homePage.displayCartTotalPrice();

    }





}

//REGISTRATION TEST VE ERROR MESSAGE VALIDATION YAPILMADI
//Cart Details
//1. Openbrowser
//2. Gotohttp://automationpractice.com/index.php
// 3. Clickonanyproductthatisnotonsale
//4. Enterarandomquantitybetween2and5
//5. Selectadifferentsize
//6. Clickonaddtocart
//7. VerifyconfirmationmessageProductsuccessfullyaddedtoyourshoppingcart
// 8. Dismisstheconfirmationwindowbyclickingonthexicon

//9. Clickonthecompanylogo
//10. Click on any product that is on sale
//11. Enter a random quantity between 2 and 5
//12. Select a different size
//13. Click on add to cart
//14. Verify confirmation message Product successfully added to your
//shopping cart
//15. Dismiss the confirmation window by clicking on the x icon
//16. Hover over the Cart icon
//17. Verify that correct total is displayed
//18. Verify that total is correct based on the price and item count of the
//products you added to cart. (Shipping is always $2)


//@Test
//    public void deneme(){
//    homePage.open();
//    //homePage.blouseDeneme.click();
//    //homePage.printedDressDeneme.click();
//    homePage.clickA_Dress("Printed Summer Dress").click();
//
//}




//EKSIK KALAN HUSUSLAR
//1. public void cardIconDeleteTest()da : // Expected :(empty) but     Actual   :
// public void cardCheckoutDeleteTest() da// 2 product u 1 e dusurdugumuzde message halen 2 yaziyor.  ve 2. product delete olmadi. dolayisyla empty mesaji yazilamadi





//Registration Test
//1. Openbrowser
//2. Gotohttp://automationpractice.com/index.php
//3. ClickSigninlink
//4. Enter new valid email to the email field
//5. ClickonCreateAccount
//6. Verifythatthatemaillinkdisplayscurrentemail
//7. Filloutalltherequiredsteps
//8. ClickonRegister
//9. Verifythatcorrectfirstandlastnameisdisplayedcorrectlyontopright
// 10. Click on My personal information
//11. Verify that personal information is displayed correctly
//12. Click on Back to your account
//13. Click on My addresses verify that address information is displayed
//correctly
//14. Click on sign out link
//15. Login using the email and password if the current user
//16. Verify that correct first and last name is displayed correctly on top right
//NOTE: for the test case above you must to generate random information for email, first name, last name, phone etc.
//  //a[@title='Information']/i/span


//Error Message Validation: First name
//1. Openbrowser
//2. Gotohttp://automationpractice.com/index.php
//3. ClickSigninlink
//4. Enter new valid email to the email field
//5. ClickonCreateAccount
//6. Fillalltherequiredstepsexceptforfirstname
//7. ClickonRegister
//8. Verifythaterrormessagefirstnameisrequired.isdisplayed