package com.prestashop.tests.functional_tests.login;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourPersonalInfoPage {
    public YourPersonalInfoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")
    public WebElement accountOwnername;

    @FindBy(xpath = "//*[@id='center_column']/div/form/fieldset/div[11]/button/span")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='center_column']/div/div/ol/li")
    public WebElement errorMessageAfterSaving;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/a/span")
    public WebElement backToYourAccountButton;



}
