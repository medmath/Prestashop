package com.prestashop.tests.functional_tests.login;

import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginPage extends TestBase {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="email_create")
    public WebElement createAccountEmail;

    @FindBy(xpath = "//*[@id='SubmitCreate']/span")
    public WebElement createAccountButton;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="passwd")
    public WebElement password;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(xpath = "//*[@id='SubmitLogin']/span")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@id='columns']/div[1]/a/i")
    public WebElement backToHome;


    public void registeredInfo(String email, String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        signInButton.click();
    }

    public void goHomePage(){
        backToHome.click();
    }


/*
 @Test
    public void readPropertyTest(){
        driver.get(ConfigurationReader.getProperty("url"));

        HomePage homePage=new HomePage();
        String username=ConfigurationReader.getProperty("Username");
        String password=ConfigurationReader.getProperty("Password");
        homePage.login(username,password);

    }
 */




    @Test
    public void registrationTest(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.id("email_create")).sendKeys("cakmak2018@gmail.com");

        driver.findElement(By.xpath("//button[@id='SubmitCreate']/span")).click();

        //String email= driver.findElement(By.id("email")).getAttribute("value");

        String email= driver.findElement(By.xpath("//input[@value='cakmak2018@gmail.com']")).getAttribute("value");
        System.out.println(email);

        Assert.assertEquals(email,"cakmak2018@gmail.com");
        driver.findElement(By.id("customer_firstname")).sendKeys("Tom");
        driver.findElement(By.id("customer_lastname")).sendKeys("Hanks");
        driver.findElement(By.id("passwd")).sendKeys("abc123");
        driver.findElement(By.id("address1")).sendKeys("51 Hayfield Lane");
        driver.findElement(By.id("city")).sendKeys("Greer");
        driver.findElement(By.id("postcode")).sendKeys("29650");
        String fullName="Tom Hanks";
        WebElement selectState= driver.findElement(By.id("id_state"));
        Select options= new Select(selectState);
        List<WebElement> stateNames=options.getOptions();
        options.selectByVisibleText("South Carolina");
        // options.selectByValue("South Carolina");// it did not work
        //        for (WebElement option:stateNames
//             ) {
//            System.out.println(option.getText());
//        }
        driver.findElement(By.id("phone_mobile")).sendKeys("+18622222222");
        driver.findElement(By.xpath("//button[@id='submitAccount']/span")).click();

        String checkName=driver.findElement(By.xpath("//a[@title='View my customer account']/span")).getText();
        System.out.println(checkName);
        Assert.assertEquals(checkName,fullName);

        driver.findElement(By.xpath("//a[@title='Information']/span")).click();
        String frstName=driver.findElement(By.id("firstname")).getAttribute("value");
        Assert.assertEquals(frstName,"Tom");

        String lName=driver.findElement(By.id("lastname")).getAttribute("value");
        Assert.assertEquals(lName,"Hanks");
////12. Click on Back to your account
        driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/a/span")).click();
//13
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[3]/a/span")).click();
        String address=driver.findElement(By.xpath("//*[@id='center_column']/div[1]/div/div/ul/li[4]/span[1]")).getText();
        System.out.println(address);
        driver.findElement(By.xpath("//a[@title='Log me out']")) .click();
    }

    @Test
    public void loginTest2(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        //driver.findElement(By.id("email_create")).sendKeys("cakmak2016@gmail.com");
        driver.findElement(By.id("email")).sendKeys("cakmak2016@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("abc123"+ Keys.ENTER);

        String fullName=driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).getText();
        Assert.assertEquals(fullName,"Tom Hanks");
    }

    @Test
    public void messageValidation(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.id("email_create")).sendKeys("cakmak2017@gmail.com");

        driver.findElement(By.xpath("//button[@id='SubmitCreate']/span")).click();


        String email= driver.findElement(By.xpath("//input[@value='cakmak2017@gmail.com']")).getAttribute("value");
        System.out.println(email);

        Assert.assertEquals(email,"cakmak2017@gmail.com");
        //driver.findElement(By.id("customer_firstname")).sendKeys("Tom");
        driver.findElement(By.id("customer_lastname")).sendKeys("Hanks");
        driver.findElement(By.id("passwd")).sendKeys("abc123");
        driver.findElement(By.id("address1")).sendKeys("51 Hayfield Lane");
        driver.findElement(By.id("city")).sendKeys("Greer");
        driver.findElement(By.id("postcode")).sendKeys("29650");
        String fullName="Tom Hanks";
        WebElement selectState= driver.findElement(By.id("id_state"));
        Select options= new Select(selectState);

        options.selectByVisibleText("South Carolina");

        driver.findElement(By.id("phone_mobile")).sendKeys("+18622222222");
        driver.findElement(By.xpath("//button[@id='submitAccount']/span")).click();
        String name1=driver.findElement(By.xpath("//*[@id=\'center_column\']/div/ol/li  ")).getText();
        System.out.println(name1);
        Assert.assertEquals(name1,"firstname is required.");

    }
}
