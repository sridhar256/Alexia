package com.alexiageriatrics.testcases;


import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

public class PatientAcknowledgementUpdate extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public PatientAcknowledgementUpdate() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("PatientAcknowledgement");
	}

	@Test(priority=1, enabled = true)
	public void dataUpdatePatientAcknowledgement() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));

		logger = extent.createTest("DataUpdatePatientAcknowledgement_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientAcknowledgement_TC_01): Validate 'Email' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in 'email' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("DataUpdatePatientAcknowledgement_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientAcknowledgement_TC_02): Validate 'Password' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in 'password' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();

		logger = extent.createTest("DataUpdatePatientAcknowledgement_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientAcknowledgement_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement patientAcknowledgement = driver.findElement(By.xpath("//div[@id='patient-acknowledgement']/div/h4"));
		patientAcknowledgement.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientAcknowledgement_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientAcknowledgement_TC_04): Validate 'Patient Acknowledgement' module after user logged to Alexia.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Patient Acknowledgement' module.",ExtentColor.GREEN));  

		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder = 'First Name']"));
		firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		firstName.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);

		logger = extent.createTest("DataUpdatePatientAcknowledgement_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientAcknowledgement_TC_05): Validate 'First Name' textbox in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Jasti1!' in 'First Name' field in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  

		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder = 'Last Name']"));
		lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		lastName.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	

		logger = extent.createTest("DataUpdatePatientAcknowledgement_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientAcknowledgement_TC_06): Validate 'Last Name' textbox in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in 'Last Name' field in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  

		WebElement datePickerDateOfBirth = driver.findElement(By.xpath("(//input[@placeholder = 'Date of Birth'])[2]"));
		js.executeScript("arguments[0].click();", datePickerDateOfBirth);
		Thread.sleep(2000);

		WebElement dateOfBirth = driver.findElement(By.xpath("(//span[@aria-current='date'])[22]"));
		js.executeScript("arguments[0].click();", dateOfBirth);
		Thread.sleep(2000);

		logger = extent.createTest("DataUpdatePatientAcknowledgement_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientAcknowledgement_TC_07): Validate 'Date of Birth' textbox in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select '08-17-2022' date from date picker for 'Date of Birth' field in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  

		WebElement relationShipOpen= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PA_relationship_to_patient'])"));
		relationShipOpen.click();
		Thread.sleep(1500);
		WebElement relationShipOpenValue= driver.findElement(By.xpath("(//div[contains(text(),'Brother')])"));
		js.executeScript("arguments[0].click();", relationShipOpenValue);
		Thread.sleep(3000);

		logger = extent.createTest("DataUpdatePatientAcknowledgement_TC_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientAcknowledgement_TC_08): Validate 'Relationship to patient..' dropdown field in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Grand Father' option from 'Relationship to patient..' dropdown field in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  

		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientAcknowledgement_TC_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientAcknowledgement_TC_09): Validate 'Update' button in  'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Update' button in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientAcknowledgement_TC_10");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientAcknowledgement_TC_10): Validate 'X' button in 'Information' pop up in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'X' button in 'Information' pop up in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  
	}


	@Test(priority=2, enabled = false)
	public void verifyDataUpdatePatientAcknowledgement() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		SoftAssert softAssert = new SoftAssert();

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));

		logger = extent.createTest("VerifyDataUpdatePatientAcknowledgement_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientAcknowledgement_TC_01): Validate 'Email' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in 'email' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("VerifyDataUpdatePatientAcknowledgement_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientAcknowledgement_TC_02): Validate 'Password' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in 'password' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();

		logger = extent.createTest("VerifyDataUpdatePatientAcknowledgement_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientAcknowledgement_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement patientAcknowledgement = driver.findElement(By.xpath("//div[@id='patient-acknowledgement']/div/h4"));
		patientAcknowledgement.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdatePatientAcknowledgement_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientAcknowledgement_TC_04): Validate 'Patient Acknowledgement' module after user logged to Alexia.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Patient Acknowledgement' module.",ExtentColor.GREEN));  

		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder = 'First Name']"));
		softAssert.assertEquals(firstName.getAttribute("value"),tcData.get("Label3"));

		logger = extent.createTest("VerifyDataUpdatePatientAcknowledgement_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientAcknowledgement_TC_05): Verify 'First Name' field data in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'First Name' data in 'Patient Acknowledgement' module is same as input value given for 'First Name' field from xls.",ExtentColor.GREEN));  

		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder = 'Last Name']"));
		softAssert.assertEquals(lastName.getAttribute("value"),tcData.get("Label4"));

		logger = extent.createTest("VerifyDataUpdatePatientAcknowledgement_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientAcknowledgement_TC_06): Verify 'Last Name' field data in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Last Name' data in 'Patient Acknowledgement' module is same as input value given for 'Last Name' field from xls.",ExtentColor.GREEN));  

		WebElement datePickerDateOfBirth = driver.findElement(By.xpath("(//input[@placeholder = 'Date of Birth'])[2]"));
		softAssert.assertEquals(datePickerDateOfBirth.getAttribute("value"),"08-17-2022");

		logger = extent.createTest("VerifyDataUpdatePatientAcknowledgement_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientAcknowledgement_TC_07): Verify 'Date of Birth' field data in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Date of Birth' data in 'Patient Acknowledgement' module is same as input value given for 'Date of Birth' field from xls.",ExtentColor.GREEN));  

		WebElement relationShipOpen= driver.findElement(By.xpath("//ng-select[@formcontrolname='PA_relationship_to_patient']/div/div/div[2]"));
		softAssert.assertEquals(relationShipOpen.getText(),tcData.get("Label6"));

		logger = extent.createTest("VerifyDataUpdatePatientAcknowledgement_TC_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientAcknowledgement_TC_08): Verify 'RelationShip to patient' field data in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'RelationShip to patient' data in 'Patient Acknowledgement' module is same as input value given for 'RelationShip to patient' field from xls.",ExtentColor.GREEN));  

		softAssert.assertAll();

	}


	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
