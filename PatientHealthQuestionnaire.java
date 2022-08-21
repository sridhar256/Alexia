package com.alexiageriatrics.testcases;


import static org.testng.Assert.assertEquals;

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

public class PatientHealthQuestionnaire extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public PatientHealthQuestionnaire() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("PatientHealthQuestionnaire");
	}


	@Test(priority=1,enabled=true)
	public void dataUpdatePatientHealthQuestionnaire() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_01): Validate 'Email' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in 'email' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_02): Validate 'Password' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in 'password' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		Thread.sleep(5000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  


		WebElement patientHealthQuestionnaire = driver.findElement(By.xpath("//div[@id='phq']/div/h4"));
		js.executeScript("arguments[0].scrollIntoView();", patientHealthQuestionnaire);
		patientHealthQuestionnaire.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_04): Validate 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement datePickerDateOfBirth = driver.findElement(By.xpath("(//input[@placeholder = 'Date'])[4]"));
		js.executeScript("arguments[0].click();", datePickerDateOfBirth);
		Thread.sleep(2000);

		WebElement dateOfBirth = driver.findElement(By.xpath("(//span[@aria-current='date'])[3]"));
		js.executeScript("arguments[0].click();", dateOfBirth);
		Thread.sleep(3000);

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_05): Validate 'Date of Birth' textbox in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select '08-04-2022' date from date picker for 'Date of Birth' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement littleInterest = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[2]/div[2]/div[4]"));
		littleInterest.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_06): Validate 'Little interest...' field in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Nearly every day' option for 'Little interest...' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement feelingDown = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[3]/div[2]/div[4]"));
		feelingDown.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_07): Validate 'Feeling Down ...' field in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Nearly every day' option for 'Feeling Down ...' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement troubleFalling  = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[4]/div[2]/div[4]"));
		troubleFalling.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_08): Validate 'Trouble Falling ...' field in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Nearly every day' option for 'Trouble Falling ...' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement feelingTired = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[5]/div[2]/div[4]"));
		feelingTired.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_09): Validate 'Feeling Tired ...' field in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Nearly every day' option for 'Feeling Tired ...' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement poorAppetite = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[6]/div[2]/div[4]"));
		poorAppetite.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_10");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_10): Validate 'Poor Appetite ...' field in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Nearly every day' option for 'Poor Appetite ...' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement feelingBad = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[7]/div[2]/div[4]"));
		feelingBad.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_11");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_11): Validate 'Feeling Bad ...' field in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Nearly every day' option for 'Feeling Bad ...' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement troubleConcentrating  = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[8]/div[2]/div[4]"));
		troubleConcentrating.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_12");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_12): Validate 'Trouble Concentrating ...' field in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Nearly every day' option for 'Trouble Concentrating ...' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement movingSpeaking  = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[9]/div[2]/div[4]"));
		movingSpeaking.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_13");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_13): Validate 'Moving Speaking ...' field in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Nearly every day' option for 'Moving Speaking ...' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement thoughts  = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[10]/div[2]/div[4]"));
		thoughts.click();
		Thread.sleep(3000);

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_14");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_14): Validate 'Thoughts ...' field in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Nearly every day' option for 'Thoughts ...' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement anyProblems  = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[13]/div[2]/div[4]"));
		anyProblems.click();
		Thread.sleep(3000);

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_15");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_15): Validate 'Any Problems ...' field in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Nearly every day' option for 'Any Problems ...' field in 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_16");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_16): Validate 'Update' button in  'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Update' button in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	

		logger = extent.createTest("DataUpdatePatientHealthQuestionnaire_TC_17");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(DataUpdatePatientHealthQuestionnaire_TC_17): Validate 'X' button in 'Information' pop up in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'X' button in 'Information' pop up in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  
	}

	@Test(priority=2,enabled =true)
	public void verifyDataUpdatePatientHealthQuestionnaire() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		SoftAssert softAssert = new SoftAssert();

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_01): Validate 'Email' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in 'email' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_02): Validate 'Password' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in 'password' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		Thread.sleep(5000);	

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement patientHealthQuestionnaire = driver.findElement(By.xpath("//div[@id='phq']/div/h4"));
		js.executeScript("arguments[0].scrollIntoView();", patientHealthQuestionnaire);
		patientHealthQuestionnaire.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_04): Validate 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Patient Health Questionnaire' module.",ExtentColor.GREEN));  

		WebElement patientName = driver.findElement(By.xpath("(//input[@placeholder='Name'])[2]"));

		String patientNameText = patientName.getAttribute("value");
		String patientNameVerify = tcData.get("Label3");
		
		System.out.println(patientNameText);
		System.out.println(tcData.get("Label3"));

		softAssert.assertEquals(patientNameText,patientNameVerify);

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_05): Verify 'Patient Name' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Patient Name' data in 'Patient Health Questionnaire' module is same as input value given for 'Patient Name' field from xls.",ExtentColor.GREEN));  

		WebElement dateOfBirth = driver.findElement(By.xpath("(//input[@placeholder = 'Date'])[4]"));
		Thread.sleep(2000);

		String dateOfBirthText = dateOfBirth.getAttribute("value");
		String dateOfBirthVerify = "08-17-2022";
		
		System.out.println(dateOfBirthText);
		System.out.println(dateOfBirthVerify);
		
		softAssert.assertEquals(dateOfBirthText,dateOfBirthVerify);

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_06): Verify 'Date of Birth' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Date of Birth' data in 'Patient Health Questionnaire' module is same as input value given for 'Date of Birth' field from xls.",ExtentColor.GREEN));  

		WebElement littleInterest = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[2]/div[2]/div[4]/button/span[1]"));
		Thread.sleep(3000);

		String littleInterestText = littleInterest.getText();
		String littleInterestVerify = tcData.get("Label5");
		softAssert.assertEquals(littleInterestText,littleInterestVerify);

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_07): Verify 'Little Interest...' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Little Interest...' data in 'Patient Health Questionnaire' module is same as input value given for 'Little Interest...' field from xls.",ExtentColor.GREEN));  

		WebElement feelingDown = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[3]/div[2]/div[4]/button/span[1]"));
		Thread.sleep(3000);	

		softAssert.assertEquals(feelingDown.getText(),tcData.get("Label5"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_08): Verify 'Feeling Down...' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Feeling Down...' data in 'Patient Health Questionnaire' module is same as input value given for 'Feeling Down...' field from xls.",ExtentColor.GREEN));  

		WebElement troubleFalling  = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[4]/div[2]/div[4]/button/span[1]"));
		Thread.sleep(3000);	

		softAssert.assertEquals(troubleFalling.getText(),tcData.get("Label5"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_09): Verify 'Trouble Falling...' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Trouble Falling...' data in 'Patient Health Questionnaire' module is same as input value given for 'Trouble Falling...' field from xls.",ExtentColor.GREEN));  

		WebElement feelingTired = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[5]/div[2]/div[4]/button/span[1]"));
		Thread.sleep(3000);	

		softAssert.assertEquals(feelingTired.getText(),tcData.get("Label5"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_10");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_10): Verify 'Feeling Tired...' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Feeling Tired...' data in 'Patient Health Questionnaire' module is same as input value given for 'Feeling Tired...' field from xls.",ExtentColor.GREEN));  

		WebElement poorAppetite = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[6]/div[2]/div[4]/button/span[1]"));
		Thread.sleep(3000);	

		softAssert.assertEquals(poorAppetite.getText(),tcData.get("Label5"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_11");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_11): Verify 'Poor Appetite...' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Poor Appetite...' data in 'Patient Health Questionnaire' module is same as input value given for 'Poor Appetite...' field from xls.",ExtentColor.GREEN));  

		WebElement feelingBad = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[7]/div[2]/div[4]/button/span[1]"));
		Thread.sleep(3000);	

		softAssert.assertEquals(feelingBad.getText(),tcData.get("Label5"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_12");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_12): Verify 'Feeling Bad...' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Feeling Bad...' data in 'Patient Health Questionnaire' module is same as input value given for 'Feeling Bad...' field from xls.",ExtentColor.GREEN));  

		WebElement troubleConcentrating  = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[8]/div[2]/div[4]/button/span[1]"));
		Thread.sleep(3000);	

		softAssert.assertEquals(troubleConcentrating.getText(),tcData.get("Label5"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_13");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_13): Verify 'Trouble Concentrating...' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Trouble Concentrating...' data in 'Patient Health Questionnaire' module is same as input value given for 'Trouble Concentrating...' field from xls.",ExtentColor.GREEN));  

		WebElement movingSpeaking  = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[9]/div[2]/div[4]/button/span[1]"));
		Thread.sleep(3000);	

		softAssert.assertEquals(movingSpeaking.getText(),tcData.get("Label5"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_14");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_14): Verify 'Moving Speaking...' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Moving Speaking...' data in 'Patient Health Questionnaire' module is same as input value given for 'Moving Speaking...' field from xls.",ExtentColor.GREEN));  

		WebElement thoughts  = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[10]/div[2]/div[4]/button/span[1]"));
		Thread.sleep(3000);

		softAssert.assertEquals(thoughts.getText(),tcData.get("Label5"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_15");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_15): Verify 'Thoughts...' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Thoughts...' data in 'Patient Health Questionnaire' module is same as input value given for 'Thoughts...' field from xls.",ExtentColor.GREEN));  

		WebElement anyProblems  = driver.findElement(By.xpath("//div[@id='phq']/div[2]/div/app-phq/form/div[13]/div[2]/div[4]/button/span[1]"));
		Thread.sleep(3000);

		softAssert.assertEquals(anyProblems.getText(),tcData.get("Label6"));

		logger = extent.createTest("VerifyDataUpdatePatientHealthQuestionnaire_TC_16");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdatePatientHealthQuestionnaire_TC_16): Verify 'Any Problems...' field data in 'Patient Health Questionnaire' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Any Problems...' data in 'Patient Health Questionnaire' module is same as input value given for 'Any Problems...' field from xls.",ExtentColor.GREEN));  

		softAssert.assertAll();

	}



	@AfterMethod
	public void tearDown() {

		// driver.quit();
	}


}
