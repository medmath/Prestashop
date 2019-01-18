package com.prestashop.tests.functional_tests.login;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
    public AddressPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a/b")
    public WebElement cartHoverOver;

    //@FindBy(linkText = "Blouse")
    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt/div/div[1]/a")
    public WebElement blouseElement;


    @FindBy(xpath = "//*[@id='center_column']/div[2]/a/span")
    public WebElement addANewaddress;

    @FindBy(id = "firstname")
    public WebElement firstName;


    @FindBy(id = "lastname")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='submitAddress']/span")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='center_column']/div/div/ol/li[1]")
    public WebElement afterDeletedErrorMessage;

    public String setCartHoverOver(){
        Actions action= new Actions(Driver.getDriver());
        action.moveToElement(cartHoverOver).perform();
        return blouseElement.getText();
    }

}
