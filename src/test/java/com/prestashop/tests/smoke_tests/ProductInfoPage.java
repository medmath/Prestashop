package com.prestashop.tests.smoke_tests;

import com.prestashop.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ProductInfoPage {
    public ProductInfoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    //@BeforeMethod
//    public void changeFrame() {
//
//
//    WebElement iframe = Driver.getDriver().findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
//
//        Driver.getDriver().switchTo().frame(iframe);
//}

    @FindBy(id = "our_price_display")
    public WebElement priceOfProduct;

    @FindBy(xpath = "//*[@id='center_column']/div/div/div[3]/h1")
    public WebElement nameOfProduct;

    @FindBy(id = "quantity_wanted")
    public WebElement defaultQuantity;

    @FindBy(xpath = "//*[@id='quantity_wanted_p']/a[2]/span/i")
    public WebElement incrementQuantity;

    @FindBy(id = "group_1")
    public WebElement defaultSize;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2")
    public WebElement addedToCardMessage;

    @FindBy(xpath = "//*[@id='header_logo']/a/img")
    public WebElement logo;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/span")
    public WebElement xButton;

    //temporary
    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
    public WebElement checkoutProceed;

    @FindBy(xpath = "//*[.='Add to cart']")
    public WebElement addToCart;

    //size lari listeliyoruz
    public String selectSize(){
        Select sizeOptions=new Select(defaultSize);
        List<WebElement> options=sizeOptions.getOptions();
        return options.get(0).getText();
    }
    //all the sizes
    public String sizeOptions(){
        String size_Options1="";
        Select sizeOptions=new Select(defaultSize);
        List<WebElement> options=sizeOptions.getOptions();
        for (WebElement option:
             options) {
            size_Options1+= option.getText();
        }
        return size_Options1;
    }

    //choose a size
    public void chooseSize(String size){
        Select sizeOptions=new Select(defaultSize);
        sizeOptions.selectByVisibleText(size);
//                Select state = new Select(driver.findElement(By.id("id_state")));
//        state.selectByValue("46");
    }


    public String productPrice(){
        return priceOfProduct.getText();
    }

    public String productName(){
            return nameOfProduct.getText();
    }

    public void windowFull(){
        Driver.getDriver().manage().window().fullscreen();
    }





    //SADECE EN ALLTAKI TEST CASE KALDI. DIGERLERI COZULDU
    private WebDriver driver;

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
    public void productInfoTest1(){
        driver.get("http://automationpractice.com/index.php");
//<span itemprop="price" class="price product-price">
//								$27.00							</span>
        String homePagePrice = driver.findElement(By.xpath("//*[@id='homefeatured']/li[2]/div/div[2]/div[1]/span")).getText();
        //System.out.println(homePagePrice);
//<img class="replace-2x img-responsive" src="http://automationpractice.com/img/p/7/7-home_default.jpg" alt="Blouse"
// title="Blouse" width="250" height="250" itemprop="image">
        driver.findElement(By.xpath("(//*[@title='Blouse'])[2]")).click();
 //<span id="our_price_display" itemprop="price">$27.00</span>
//        WebElement iframe1=driver.findElement(By.id("fb_xdm_frame_https"));
//        driver.switchTo().frame(iframe1);


       // WebElement iframe=driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));

        //driver.switchTo().frame(iframe);

      //String displayPrice=driver.findElement(By.id("our_price_display")).getText();
       // System.out.println(displayPrice);
//
//
//
//
        //Assert.assertEquals(homePagePrice,displayPrice);




//        String homePagePrice =driver.findElement(By.partialLinkText("$27")).getText();
//        System.out.println(homePagePrice);


//<span id="our_price_display" itemprop="price">$27.00</span>

    }

    @Test
    public void productInfoDetails(){
        driver.get("http://automationpractice.com/index.php");

        driver.findElement(By.xpath("(//*[@title='Blouse'])[2]")).click();
        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
        driver.switchTo().frame(iframe);
       String quantity=driver.findElement(By.id("quantity_wanted")).getAttribute("value");
        System.out.println(quantity);

       Assert.assertEquals(quantity,"1");


       WebElement selectElement=driver.findElement(By.id("group_1"));
        System.out.println(selectElement.getText());

        System.out.println("**********");
       Select list= new Select(selectElement);
        List<WebElement> options=list.getOptions();
        System.out.println(options.get(0).getText());

        Assert.assertEquals(options.get(0).getText(),"S");

        for (WebElement option:options
             ) {
            System.out.println(option.getText());

        }

    }



    @Test
    public void Registration () {
        driver.get("http://automationpractice.com/index.php");
    driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        WebElement createEmail = driver.findElement(By.id("email_create"));
        createEmail.sendKeys("funky11@gmail.com" + Keys.ENTER);

        //find and select mrs. button
        WebElement femaleRadioBtn = driver.findElement(By.id("id_gender2"));
        femaleRadioBtn.click();

        //verify mrs. button is selected
        System.out.println(femaleRadioBtn.isSelected());

        //input first name, last name, and password
        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Tre");

        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys("scotty");

        WebElement inputPassword = driver.findElement(By.id("passwd"));
        inputPassword.sendKeys("tre123");


        //Enter your address information

        //address line 1
        WebElement addressLine1 = driver.findElement(By.id("address1"));
        addressLine1.sendKeys("7925 Cybertek BLVD");

        //city
        WebElement addressCity = driver.findElement(By.id("city"));
        addressCity.sendKeys("McLean");

        //state
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByValue("46");

        //zip code
        WebElement zipCode = driver.findElement(By.id("postcode"));
        zipCode.sendKeys("22102");

        //mobile phone
        WebElement mobilePhone = driver.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("2021234567" + Keys.ENTER);
    }

    @Test
    public void positiveLogin () {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        //enter your username
        WebElement enterUserName = driver.findElement(By.id("email"));
        enterUserName.sendKeys("funky@gmail.com");

        //verify username is correct
        String expectedUserName = "funky@gmail.com";
        String actualUserName = driver.findElement(By.id("email")).getAttribute("value");
        System.out.println("Expected Username: " + expectedUserName + " | Actual UserName: " + actualUserName);
        Assert.assertEquals(actualUserName, expectedUserName);

        //enter password
        WebElement enterPassword = driver.findElement(By.id("passwd"));
        enterPassword.sendKeys("tre123");

        //verify password
        String expectedPassword = "tre123";
        String actualPassword = driver.findElement(By.id("passwd")).getAttribute("value");
        System.out.println("Expected password: " + expectedPassword + " | Actual password: " + actualPassword);
        Assert.assertEquals(actualPassword, expectedPassword);


        //sign in to your account
        WebElement signIn = driver.findElement(By.id("SubmitLogin"));
        signIn.click();
    }

    @Test
    public void search () {
        driver.get("http://automationpractice.com/index.php");

        //locate search and search a t-shirt
        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("T-shirt" + Keys.ENTER);

        //verify page title contains search
        String expectedTitle = "Search";
        String actualTitle = driver.getTitle();
        System.out.println("Expected Title: " + expectedTitle + " | Actual Title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));


        //add the first item into cart
        WebElement shirt = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
       Actions actions=new Actions(driver);
        actions.moveToElement(shirt).perform();
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span"));
        addToCart.click();

        //proceed to checkout
      driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
        driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")).click();

        //sign in again
        WebElement enterUserName = driver.findElement(By.id("email"));
        enterUserName.sendKeys("funky@gmail.com");
        //enter password
        WebElement enterPassword = driver.findElement(By.id("passwd"));
        enterPassword.sendKeys("tre123");
        WebElement signIn = driver.findElement(By.id("SubmitLogin"));
        signIn.click();

        //verify "same delivery address" box is checked
        WebElement sameAddress = driver.findElement(By.id("addressesAreEquals"));
        System.out.println(sameAddress.isSelected());
        Assert.assertTrue(sameAddress.isSelected());

        //proceed to checkout
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();

        //select terms of service box
        driver.findElement(By.id("cgv")).click();

        //proceed to checkout
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();

        //pay by bank wire
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();


        //confirm my order
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();


        //verify confirmation
        String expectedMsg = "Your order on My Store is complete.";
        String actualMsg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
        Assert.assertEquals(expectedMsg, actualMsg);
    }
}