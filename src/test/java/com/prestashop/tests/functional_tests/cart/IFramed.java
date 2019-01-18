package com.prestashop.tests.functional_tests.cart;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramed {
    public IFramed(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//iframe[@class='fancybox-iframe']")
    public WebElement iFrameChange;


    public void setiFrameChange(){
        Driver.getDriver().switchTo().frame(iFrameChange);
    }



}


// WebElement iframe=driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
////
////    driver.switchTo().frame(iframe);