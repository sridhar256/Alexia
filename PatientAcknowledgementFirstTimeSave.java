package com.alexiageriatrics.testcases;


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

public class PatientAcknowledgementFirstTimeSave extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public PatientAcknowledgementFirstTimeSave() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("PatientAcknowledgement");
	}


	@Test(priority=1)
	public void verifySaveDataPatientAcknowledgement() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifySaveDataPatientAcknowledgement_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataPatientAcknowledgement_TC_01): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifySaveDataPatientAcknowledgement_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataPatientAcknowledgement_TC_02): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifySaveDataPatientAcknowledgement_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataPatientAcknowledgement_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement patientAcknowledgement = driver.findElement(By.xpath("//div[@id='patient-acknowledgement']/div/h4"));
		patientAcknowledgement.click();
		Thread.sleep(3000);	

		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder = 'First Name']"));
		firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		firstName.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);

		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder = 'Last Name']"));
		lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		lastName.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	

		WebElement datePickerDateOfBirth = driver.findElement(By.xpath("(//input[@placeholder = 'Date of Birth'])[2]"));
		js.executeScript("arguments[0].click();", datePickerDateOfBirth);
		Thread.sleep(2000);

		WebElement dateOfBirth = driver.findElement(By.xpath("(//span[@aria-current='date'])[1]"));
		js.executeScript("arguments[0].click();", dateOfBirth);
		Thread.sleep(2000);

		WebElement acceptTermsConditions = driver.findElement(By.xpath("//button[contains(text(),'Accept Terms & Conditions')]"));
		js.executeScript("arguments[0].click();", acceptTermsConditions);
		Thread.sleep(1500);	

		WebElement confirmation = driver.findElement(By.xpath("(//button[contains(text(),'Confirm')])[1]"));
		confirmation.click();
		Thread.sleep(1500);	

		WebElement signature = driver.findElement(By.xpath("//div[@class='signaturepad ng-star-inserted']"));
		signature.click();
		Thread.sleep(1500);	

		WebElement clearSignature = driver.findElement(By.xpath("//button[contains(text(),'Clear')]"));
		clearSignature.click();
		Thread.sleep(1500);	

		WebElement addSignature = driver.findElement(By.xpath("(//div[@class='modal-body'])[2]"));

		Actions builder = new Actions(driver);
		org.openqa.selenium.interactions.Action signature1= builder.moveToElement(addSignature,100,50) 
				.clickAndHold()
				.moveByOffset(-50, 60) // 2nd points (x1,y1)
				.moveByOffset(-60, -70)// 3rd points (x2,y2)
				.moveByOffset(150, 60) // 2nd points (x1,y1)
				.moveByOffset(-60, -70)// 3rd points (x2,y
				.doubleClick()
				.build();
		signature1.perform();
		Thread.sleep(1500);	

		WebElement addSignature1 = driver.findElement(By.xpath("(//div[@class='modal-body'])[2]"));

		Actions builder1 = new Actions(driver);
		org.openqa.selenium.interactions.Action signature2= builder.moveToElement(addSignature,100,50) 
				.clickAndHold()
				.moveByOffset(50, -60) // 2nd points (x1,y1)
				.moveByOffset(60, 70)// 3rd points (x2,y2)
				.moveByOffset(-150, -60) // 2nd points (x1,y1)
				.moveByOffset(60, 70)// 3rd points (x2,y
				.doubleClick()
				.build();
		signature2.perform();
		Thread.sleep(1500);	

		WebElement saveSignature = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		saveSignature.click();
		Thread.sleep(1500);	

		WebElement date = driver.findElement(By.xpath("(//span[@aria-current='date'])[2]"));
		js.executeScript("arguments[0].click();", date);
		Thread.sleep(2000);

		WebElement dateSelect = driver.findElement(By.xpath("(//div[@class='flatpickr-rContainer'])[2]/div[2]/div/span[25]"));
		js.executeScript("arguments[0].click();", dateSelect);
		Thread.sleep(1500);	

		WebElement relationShipOpen = driver.findElement(By.xpath("//select[@formcontrolname='PA_relationship_to_patient']"));
		js.executeScript("arguments[0].click();", relationShipOpen);
		Thread.sleep(2000);

		List<WebElement> option = driver.findElements(By.xpath("//select/option"));
		for (WebElement ele1 : option) {
			String optionSelect = ele1.getText();
			if (optionSelect.equalsIgnoreCase("Brother")) {
				ele1.click();
				break;
			}
		}
		Thread.sleep(3000);

		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		update.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	

	}


	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
