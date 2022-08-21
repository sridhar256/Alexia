package com.alexiageriatrics.testcases;


import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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

public class MedicalRecordsReleaseForm extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public MedicalRecordsReleaseForm() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("MedicalRecordsReleaseForm");
	}


	@Test(priority=1,enabled=true)
	public void dataUpdateMedicalRecordsReleaseForm() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));

		logger = extent.createTest("DataUpdateMedicalRecordsReleaseForm_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdateMedicalRecordsReleaseForm_TC_01): Validate 'Email' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in 'email' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("DataUpdateMedicalRecordsReleaseForm_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdateMedicalRecordsReleaseForm_TC_02): Validate 'Password' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in 'password' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();

		logger = extent.createTest("DataUpdateMedicalRecordsReleaseForm_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdateMedicalRecordsReleaseForm_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement medicalRecordsReleaseForm = driver.findElement(By.xpath("//div[@id='release-form']/div/h4"));
		medicalRecordsReleaseForm.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdateMedicalRecordsReleaseForm_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdateMedicalRecordsReleaseForm_TC_04): Validate 'Medical Records Release Form' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Medical Records Release Form' module.",ExtentColor.GREEN));  

		WebElement healthQuestionnaire = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		js.executeScript("arguments[0].scrollIntoView(true);", healthQuestionnaire);
		Thread.sleep(3000);	

		WebElement relationFormOpen = driver.findElement(By.xpath("(//span[@class='dropdown-multiselect__caret'])[1]"));
		js.executeScript("arguments[0].click();", relationFormOpen);
		Thread.sleep(2000);

		WebElement completedRecordsCheckbox = driver.findElement(By.xpath("(//li[@class='multiselect-item-checkbox ng-star-inserted'][1])[1]/input"));
		if (!completedRecordsCheckbox.isSelected()){
			System.out.println("completedRecordsCheckbox is selected");  
			js.executeScript("arguments[0].click();", completedRecordsCheckbox);
		}
		else {
			System.out.println("completedRecordsCheckbox is not selected");
		}
		Thread.sleep(3000);

		WebElement historyPhysicalCheckbox = driver.findElement(By.xpath("(//li[@class='multiselect-item-checkbox ng-star-inserted'][2])[1]/input"));
		if (!historyPhysicalCheckbox.isSelected()){
			System.out.println("HistoryPhysicalCheckbox is selected");  
			js.executeScript("arguments[0].click();", historyPhysicalCheckbox);
		}
		else {
			System.out.println("HistoryPhysicalCheckbox is not selected");
		}
		Thread.sleep(3000);

		WebElement progressNotesCheckbox = driver.findElement(By.xpath("(//li[@class='multiselect-item-checkbox ng-star-inserted'][3])[1]/input"));
		if (!progressNotesCheckbox.isSelected()){
			System.out.println("ProgressNotesCheckbox is selected");  
			js.executeScript("arguments[0].click();", progressNotesCheckbox);
		}
		else {
			System.out.println("ProgressNotesCheckbox is not selected");
		}
		Thread.sleep(3000);

		WebElement search = driver.findElement(By.xpath("(//input[@placeholder = 'Search'])[2]"));
		search.sendKeys("Lab Reports");
		Thread.sleep(1500);	

		WebElement labReportsCheckbox = driver.findElement(By.xpath("(//li[@class='multiselect-item-checkbox ng-star-inserted'][1])[1]/input"));
		if (!labReportsCheckbox.isSelected()){
			System.out.println("LabReportsCheckbox is selected");  
			js.executeScript("arguments[0].click();", labReportsCheckbox);
		}
		else {
			System.out.println("LabReportsCheckbox is not selected");
		}
		Thread.sleep(3000);

		logger = extent.createTest("DataUpdateMedicalRecordsReleaseForm_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdateMedicalRecordsReleaseForm_TC_05): Validate adding records/reports for release form in 'Medical Records Release Form' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to add 'Lab Reports, History Physical, Progress Notes and Completed Records' to 'Medical Records Release Form' module.",ExtentColor.GREEN));  

		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdateMedicalRecordsReleaseForm_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdateMedicalRecordsReleaseForm_TC_06): Validate 'Update' button in  'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Update' button in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdateMedicalRecordsReleaseForm_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdateMedicalRecordsReleaseForm_TC_07): Validate 'X' button in 'Information' pop up in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'X' button in 'Information' pop up in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  
	}


	@Test(priority=2,enabled=true)
	public void verifyDataUpdateMedicalRecordsReleaseForm() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		SoftAssert softAssert = new SoftAssert();

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));

		logger = extent.createTest("VerifySaveDataMedicalRecordsReleaseForm_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataMedicalRecordsReleaseForm_TC_01): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("VerifySaveDataMedicalRecordsReleaseForm_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataMedicalRecordsReleaseForm_TC_02): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();

		logger = extent.createTest("VerifySaveDataMedicalRecordsReleaseForm_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataMedicalRecordsReleaseForm_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  
		Thread.sleep(5000);	

		WebElement medicalRecordsReleaseForm = driver.findElement(By.xpath("//div[@id='release-form']/div/h4"));
		medicalRecordsReleaseForm.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifySaveDataMedicalRecordsReleaseForm_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataMedicalRecordsReleaseForm_TC_04): Validate 'Medical Records Release Form' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Medical Records Release Form' module.",ExtentColor.GREEN));  

		WebElement healthQuestionnaire = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		js.executeScript("arguments[0].scrollIntoView(true);", healthQuestionnaire);
		Thread.sleep(3000);	

		WebElement patientName = driver.findElement(By.xpath("(//input[@placeholder='Patient Name'])[2]"));
		softAssert.assertEquals(patientName.getAttribute("value"),tcData.get("Label3"));
		
		System.out.println(patientName.getAttribute("value"));
		System.out.println(tcData.get("Label3"));

		logger = extent.createTest("VerifySaveDataMedicalRecordsReleaseForm_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataMedicalRecordsReleaseForm_TC_05): Verify 'Patient Name' field data in 'Medical Records Release Form' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Patient Name' data in 'Medical Records Release Form' module is same as input value given for 'Patient Name' field from xls.",ExtentColor.GREEN));  

		WebElement dateOfBirth = driver.findElement(By.xpath("(//input[@placeholder = 'Date of Birth'])[4]"));
		softAssert.assertEquals(dateOfBirth.getAttribute("value"),"08/17/2022");

		System.out.println(dateOfBirth.getAttribute("value"));
		System.out.println(tcData.get("Label4"));

		logger = extent.createTest("VerifySaveDataMedicalRecordsReleaseForm_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataMedicalRecordsReleaseForm_TC_06): Verify 'Date of Birth' field data in 'Medical Records Release Form' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Date of Birth' data in 'Medical Records Release Form' module is same as input value given for 'Date of Birth' field from xls.",ExtentColor.GREEN));  

		WebElement completedRecords = driver.findElement(By.xpath("//span[contains(text(),'Complete Records')]"));
		softAssert.assertEquals(completedRecords.getText(),tcData.get("Label5"));

		System.out.println(completedRecords.getText());
		System.out.println(tcData.get("Label5"));

		logger = extent.createTest("VerifySaveDataMedicalRecordsReleaseForm_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataMedicalRecordsReleaseForm_TC_07): Verify 'Complete Records' is added to release form in 'Medical Records Release Form' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Complete Records' is added to release form which is the same input value from xls.",ExtentColor.GREEN));  

		WebElement historyPhysical = driver.findElement(By.xpath("//span[contains(text(),'History & Physical')]"));
		softAssert.assertEquals(historyPhysical.getText(),tcData.get("Label6"));

		System.out.println(historyPhysical.getText());
		System.out.println(tcData.get("Label6"));

		logger = extent.createTest("VerifySaveDataMedicalRecordsReleaseForm_TC_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataMedicalRecordsReleaseForm_TC_08): Verify 'History & Physical' is added to release form in 'Medical Records Release Form' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'History & Physical' is added to release form which is the same input value from xls.",ExtentColor.GREEN));  


		WebElement progressNotes  = driver.findElement(By.xpath("//span[contains(text(),'Progress Notes')]"));
		softAssert.assertEquals(progressNotes.getText(),tcData.get("Label7"));

		System.out.println(progressNotes.getText());
		System.out.println(tcData.get("Label7"));

		logger = extent.createTest("VerifySaveDataMedicalRecordsReleaseForm_TC_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataMedicalRecordsReleaseForm_TC_09): Verify 'Progress Notes' is added to release form in 'Medical Records Release Form' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Progress Notes' is added to release form which is the same input value from xls.",ExtentColor.GREEN));  
		softAssert.assertTrue(true);


		WebElement labReports  = driver.findElement(By.xpath("//span[contains(text(),'Lab Reports')]"));
		softAssert.assertEquals(labReports.getText(),tcData.get("Label8"));

		System.out.println(labReports.getText());
		System.out.println(tcData.get("Label8"));

		logger = extent.createTest("VerifySaveDataMedicalRecordsReleaseForm_TC_10");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataMedicalRecordsReleaseForm_TC_10): Verify 'Lab Reports' is added to release form in 'Medical Records Release Form' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Lab Reports' is added to release form which is the same input value from xls.",ExtentColor.GREEN));  

		softAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
