package com.alexiageriatrics.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alexiageriatrics.base.*;
import com.alexiageriatrics.util.TestUtil;

public class LoginPage extends TestBase {

	@FindBy(xpath="//input[@formcontrolname='email']")
	WebElement emailTxt;

	public void clearEmail() {
		emailTxt.clear();
	}

	public void enterEmail(String email) {
		emailTxt.sendKeys(email);
	}

	public boolean verifyEmail(){
		return emailTxt.isDisplayed();
	}

	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement passwordTxt;

	public void clearPassword() {
		passwordTxt.clear();
	}

	public void enterPassword(String pwd) {
		passwordTxt.sendKeys(pwd);
	}

	public boolean verifyPassword(){
		return passwordTxt.isDisplayed();
	}

	@FindBy(xpath="//button[@type='submit']")
	WebElement signInBtn;

	public void clickLoginBtn() {
		signInBtn.click();
	}

	public boolean verifysignInBtn(){
		return signInBtn.isDisplayed();
	}

	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	public void waitForLoginBtn(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(signInBtn));   
	}

	public HomePage loginToSite(String email, String pwd) throws Exception {

		emailTxt.sendKeys(email);
		TestUtil.waitForPageLoad(driver);
		
		passwordTxt.sendKeys(pwd);
		TestUtil.waitForPageLoad(driver);
		
		signInBtn.click();
		TestUtil.waitForPageLoad(driver);
		
		Thread.sleep(6000);

		return new HomePage();	
	}
}
