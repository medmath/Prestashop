package com.prestashop.tests.functional_tests.cart;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {


    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
    public void open(){
        Driver.getDriver().get("http://automationpractice.com/index.php");
    }

    public void signIn(){
            Driver.getDriver().findElement(By.linkText("Sign in")).click();
    }

    @FindBy(xpath = "//a[@title='Blouse']")
    public WebElement blouseDeneme;

    @FindBy(xpath = "//a[@title='Printed Dress']")
    public WebElement printedDressDeneme;


    @FindBy(xpath = "//*[@id='homefeatured']/li[2]/div/div[1]/div/a[1]/img")
    public WebElement blouse;

    @FindBy(xpath = "//*[@id='homefeatured']/li[4]/div/div[1]/div/a[1]/img")
    public WebElement printedDress;

    @FindBy(linkText="Add to cart")
    public WebElement addToCart;

    @FindBy(linkText = "Proceed to checkout")
    public WebElement checkOut;

    //@FindBy(linkText = "Cart")//finding cardIcon
    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a/b")
    public WebElement cardIcon;

    //@FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a/b")
    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt/span/a")
    //@FindBy(xpath = "//*[@id=\"4_16_0_0\"]/i")
    public WebElement cardIconPrintedDress;


    @FindBy(linkText = "Blouse")
    public WebElement addedToCard;

    @FindBy(linkText = "Proceed to checkout")
    public WebElement checkOutSecond;

    @FindBy(linkText = "Sign out")
    public WebElement logOut;

    //product amount= empty
    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a/span[5]")
    public WebElement emptyText;

    //continue Shopping Button
    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
    public WebElement continueButton;

    //removing product
    @FindBy(xpath = "//a[@class='ajax_cart_block_remove_link']")
    public WebElement removePRoduct;

    //
    //@FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a/span[5]")
    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a/span[5]")
    public WebElement emptyTextAfterRemoving;

////*[@id='summary_products_quantity']
    @FindBy(xpath = "//*[@id='summary_products_quantity']")
    public WebElement quantity;

    //@FindBy(xpath = "//*[@id='summary_products_quantity']")
    @FindBy(xpath = "//*[@id='cart_title']")
    public WebElement newQuantity;

    @FindBy(xpath = "//*[@id='order_step']/li[1]/a")
    public WebElement backtoSummaryFromSignIn;

    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/div/div[2]/span[1]")
    public WebElement productsTotalPrice;

    public void addProductBlouse() {
        Actions action= new Actions(Driver.getDriver());
        action.moveToElement(blouse).perform();
        addToCart.click();
        checkOut.click();
        action.moveToElement(cardIcon).perform();
        Assert.assertEquals(addedToCard.getText(),"Blouse");
        //setAddedToCard();
        checkOut.click();

    }




    public WebElement clickA_DressByName(String dressName){
        String xpath="//a[@title='"+dressName+"']";

           return Driver.getDriver().findElement(By.xpath(xpath));
    }


    //    //homepagedeki dreslerin webElementlerini return eder.
    public WebElement clickA_DressByXpath(int x){  //1 to7
    String xpath=" //*[@id=\"homefeatured\"]/li["+x+"]/div/div[2]/h5/a";

    return Driver.getDriver().findElement(By.xpath(xpath));
    }

///secilen kiyafet eklenir
    public void addDifferentProduct(int x){
        Actions action= new Actions(Driver.getDriver());
        action.moveToElement(clickA_DressByXpath(x)).perform();
        addToCart.click();
    }

    public String dressName(int x){
        String xpath=" //*[@id=\"homefeatured\"]/li["+x+"]/div/div[2]/h5/a";
        return Driver.getDriver().findElement(By.xpath(xpath)).getText();
    }

    public String price(int x){
        Actions action= new Actions(Driver.getDriver());
        action.moveToElement(clickA_DressByXpath(x)).perform();
        String path="//*[@id='homefeatured']/li["+x+"]/div/div[1]/div/div[2]/span";
        return Driver.getDriver().findElement(By.xpath(path)).getText();
    }

    public void addProductBlouseContinue() {
        Actions action= new Actions(Driver.getDriver());
        action.moveToElement(blouse).perform();
        addToCart.click();
        continueButton.click();

    }

public void setBacktoSummaryFromSignIn(){
        backtoSummaryFromSignIn.click();
}

//   message after checkout
    public String messageAfterCheckOut(){
        return "Your shopping cart contains: "+quantity.getText();   //"Your shopping cart contains: "+
    }

    public String messageAfterCheckOutNewQuantity(){
        return "Your shopping cart contains: "+newQuantity.getText();   //"Your shopping cart contains: "+
    }

    public void deletingProducts(){
        Actions action= new Actions(Driver.getDriver());
        action.moveToElement(cardIcon).perform();
        removePRoduct.click();
        //return emptyTextAfterRemoving.getText();

    }

    public void displayCartTotalPrice(){
        Actions action= new Actions(Driver.getDriver());
        action.moveToElement(cardIcon).perform();
       //Assert.assertEquals(productsTotalPrice.getText(),"$262.97");
        productsTotalPrice.getText();
    }

    public void deletingSecondProducts(){
//        Actions action= new Actions(Driver.getDriver());
//        action.moveToElement(cardIconPrintedDress).perform();
        removePRoduct.click();
        //return emptyTextAfterRemoving.getText();

    }



    public void proceedCheckout(){
            checkOutSecond.click();
    }


    public String setAddedToCard(){
        return addedToCard.getText();
    }

    public void signOut(){
    logOut.click();
    }

    public String emptyProduct(){
        return emptyText.getText();
    }

    public String emptyProductAfterRemove(){
        return emptyTextAfterRemoving.getText();
    }
}
////*[@id="homefeatured"]/li[2]/div/div[2]/div[2]/a[1]/span
////*[@id='header']/div[3]/div/div/div[3]/div/a/span[5]

// xpaths of the dressses are starting from 1 to 7   //*[@id="homefeatured"]/li[1]/div/div[2]/h5/a
// *[@id="homefeatured"]/li[7]/div/div[2]/h5/a