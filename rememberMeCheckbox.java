package com.alexiageriatrics.functionality;


import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opensymphony.xwork2.Action;
import com.alexiageriatrics.util.TestUtil;
import com.alexiageriatrics.ExtentReportListener.*;
import com.alexiageriatrics.base.TestBase;
import com.alexiageriatrics.pages.HomePage;
import com.alexiageriatrics.pages.LoginPage;
import com.alexiageriatrics.pages.PatientAcknowledgementPage;

public class rememberMeCheckbox extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public rememberMeCheckbox() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("SignIn");
	}


	@Test(priority=1)
	public void rememberMeCheckbox() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		
		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));

		logger = extent.createTest("RememberMeCheckbox_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RememberMeCheckbox_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("RememberMeCheckbox_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RememberMeCheckbox_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement rememberMeCheckbox = driver.findElement(By.xpath("//input[@id='remember-me']"));
		js.executeScript("arguments[0].click();", rememberMeCheckbox);
		Thread.sleep(5000);	
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("RememberMeCheckbox_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RememberMeCheckbox_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement logOut = driver.findElement(By.xpath("//a[@title='Logout']"));
		logOut.click();
		Thread.sleep(5000);	
		
		WebElement signInAgainSameUser = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
		signInAgainSameUser.click();
		Thread.sleep(5000);	
		
		WebElement logOutAgainSameUser = driver.findElement(By.xpath("//a[@title='Logout']"));
		logOutAgainSameUser.click();
		Thread.sleep(5000);	
		
		WebElement signInAgainSameUser2ndTime = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
		signInAgainSameUser2ndTime.click();
		Thread.sleep(5000);	
		
		WebElement logOutAgainSameUser2ndTime = driver.findElement(By.xpath("//a[@title='Logout']"));
		logOutAgainSameUser2ndTime.click();
		Thread.sleep(5000);	
		
		WebElement signInDifferentUser = driver.findElement(By.xpath("//button[contains(text(),'Sign in as different user')]"));
		signInDifferentUser.click();
		Thread.sleep(5000);	
		
		WebElement emailNew = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		emailNew.sendKeys(tcData.get("Label3"));
		Thread.sleep(3000);	

		WebElement passwordNew = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		passwordNew.sendKeys(tcData.get("Label4"));
		Thread.sleep(3000);	
		
		WebElement rememberMeCheckboxNew = driver.findElement(By.xpath("//label[contains(text(),' Remember Me')]"));
		rememberMeCheckboxNew.click();
		Thread.sleep(3000);	

		WebElement signInNew= driver.findElement(By.xpath("//button[@type='submit']"));
		signInNew.click();
		Thread.sleep(5000);	
		
		WebElement logOutNew = driver.findElement(By.xpath("//a[@title='Logout']"));
		logOutNew.click();
		Thread.sleep(5000);	
		
		WebElement signInAgainNewUser = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
		signInAgainNewUser.click();
		Thread.sleep(5000);	
		
		WebElement logOutAgainNewUser = driver.findElement(By.xpath("//a[@title='Logout']"));
		logOutAgainNewUser.click();
		Thread.sleep(5000);	
		
		WebElement signInDifferentUser1 = driver.findElement(By.xpath("//button[contains(text(),'Sign in as different user')]"));
		signInDifferentUser1.click();
		Thread.sleep(5000);	
		
		WebElement emailNew1 = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		emailNew1.sendKeys(tcData.get("Label1"));
		Thread.sleep(3000);	

		WebElement passwordNew1 = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		passwordNew1.sendKeys(tcData.get("Label2"));
		Thread.sleep(3000);	
		
		WebElement rememberMeCheckboxNew1 = driver.findElement(By.xpath("//label[contains(text(),' Remember Me')]"));
		rememberMeCheckboxNew1.click();
		Thread.sleep(3000);	

		WebElement signInNew1= driver.findElement(By.xpath("//button[@type='submit']"));
		signInNew1.click();
		Thread.sleep(15000);	
		
		WebElement logOutNew1 = driver.findElement(By.xpath("//a[@title='Logout']"));
		logOutNew1.click();
		Thread.sleep(5000);	
	}


	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
