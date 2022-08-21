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

public class MorseFallScale extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public MorseFallScale() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("MorseFallScale");
	}


	@Test(priority=1,enabled=true)
	public void verifyDataUpdateMorseFallScale() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_01): Validate 'Email' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in 'email' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_02): Validate 'Password' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in 'password' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		Thread.sleep(5000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement morseFallScale = driver.findElement(By.xpath("//div[@id='mfs']/div/h4"));
		js.executeScript("arguments[0].scrollIntoView();", morseFallScale);
		morseFallScale.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_04): Validate 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Morse Fall Scale' module.",ExtentColor.GREEN));  

		WebElement historyOfFalling = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[2]/div[2]/div[2]"));
		historyOfFalling.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_05): Validate 'History of ...' field in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'YES' option for 'History of ...' field in 'Morse Fall Scale' module.",ExtentColor.GREEN));  

		WebElement secondaryDiagnosis = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[3]/div[2]/div[2]"));
		secondaryDiagnosis.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_06): Validate 'Secondary diagnos ...' field in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'YES' option for 'Secondary diagnosis ...' field in 'Morse Fall Scale' module.",ExtentColor.GREEN));  

		WebElement ambulatoryAid  = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[4]/div[2]/div[2]"));
		ambulatoryAid.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_07): Validate 'Ambulatory ...' field in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Crutches, cane(s), walker' option for 'Ambulatory aid ...' field in 'Morse Fall Scale' module.",ExtentColor.GREEN));  

		WebElement iVHeparinLockOrSaline = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[5]/div[2]/div[2]"));
		iVHeparinLockOrSaline.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_08): Validate 'IV/Heparin lock ...' field in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'YES' option for 'IV/Heparin lock ...' field in 'Morse Fall Scale' module.",ExtentColor.GREEN));  

		WebElement gait = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[6]/div[2]/div[2]"));
		gait.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_09): Validate 'Gait ...' field in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'YES' option for 'Gait ...' field in 'Morse Fall Scale' module.",ExtentColor.GREEN));  

		WebElement mentalStatus = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[7]/div[2]/div[2]"));
		mentalStatus.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_10");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_10): Validate 'Mental status ...' field in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Overestimates or forgets limitations' option for 'Mental status ...' field in 'Morse Fall Scale' module.",ExtentColor.GREEN));  

		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_11");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_11): Validate 'Update' button in  'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Update' button in 'Morse Fall Scale' module.",ExtentColor.GREEN));  

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_12");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_12): Validate 'X' button in 'Information' pop up in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'X' button in 'Information' pop up in 'Morse Fall Scale' module.",ExtentColor.GREEN));  
	}


	@Test(priority=2,enabled=true)
	public void dataUpdateMorseFallScale() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		SoftAssert softAssert = new SoftAssert();

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_01): Validate 'Email' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in 'email' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_02): Validate 'Password' textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in 'password' field in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		Thread.sleep(5000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		WebElement morseFallScale = driver.findElement(By.xpath("//div[@id='mfs']/div/h4"));
		js.executeScript("arguments[0].scrollIntoView();", morseFallScale);
		morseFallScale.click();
		Thread.sleep(3000);	

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_04): Validate 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Morse Fall Scale' module.",ExtentColor.GREEN));  

		WebElement historyOfFalling = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[2]/div[2]/div[2]/button/div[1]/span"));
		Thread.sleep(3000);	

		String historyOfFallingText = historyOfFalling.getText();
		String historyOfFallingVerify = tcData.get("Label3");
		softAssert.assertEquals(historyOfFallingText,historyOfFallingVerify);

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_05): Verify 'History of ...' field data in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'History of ...' data in 'Morse Fall Scale' module is same as input value given for 'History of ...' field from xls.",ExtentColor.GREEN));  

		WebElement secondaryDiagnosis = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[3]/div[2]/div[2]/button/div[1]/span"));
		Thread.sleep(3000);	

		String secondaryDiagnosisText = secondaryDiagnosis.getText();
		String secondaryDiagnosisVerify = tcData.get("Label4");
		softAssert.assertEquals(secondaryDiagnosisText,secondaryDiagnosisVerify);

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_06): Verify 'Secondary diagnosis ...' field data in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Secondary diagnosis ...' data in 'Morse Fall Scale' module is same as input value given for 'Secondary diagnosis ...' field from xls.",ExtentColor.GREEN));  

		WebElement ambulatoryAid  = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[4]/div[2]/div[2]/button/div[1]/span"));
		Thread.sleep(3000);	

		String ambulatoryAidText = ambulatoryAid.getText();
		String ambulatoryAidVerify = tcData.get("Label5");
		softAssert.assertEquals(ambulatoryAidText,ambulatoryAidVerify);

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_07): Verify 'Ambulatory aid ...' field data in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Ambulatory aid ...' data in 'Morse Fall Scale' module is same as input value given for 'Ambulatory aid ...' field from xls.",ExtentColor.GREEN));  

		WebElement iVHeparinLockOrSaline = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[5]/div[2]/div[2]/button/div[1]/span"));
		Thread.sleep(3000);	

		String iVHeparinLockOrSalineText = iVHeparinLockOrSaline.getText();
		String iVHeparinLockOrSalineVerify = tcData.get("Label6");
		softAssert.assertEquals(iVHeparinLockOrSalineText,iVHeparinLockOrSalineVerify);

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_08): Verify 'IV/Heparin lock ...' field data in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'IV/Heparin lock ...' data in 'Morse Fall Scale' module is same as input value given for 'IV/Heparin lock ...' field from xls.",ExtentColor.GREEN));  

		WebElement gait = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[6]/div[2]/div[2]/button/div[1]/span"));
		Thread.sleep(3000);	

		String gaitText = gait.getText();
		String gaitVerify = tcData.get("Label7");
		softAssert.assertEquals(gaitText,gaitVerify);

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_09): Verify 'Gait ...' field data in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Gait ...' data in 'Morse Fall Scale' module is same as input value given for 'Gait ...' field from xls.",ExtentColor.GREEN));  

		WebElement mentalStatus = driver.findElement(By.xpath("//div[@id='mfs']/div[2]/div/app-mfs/form/div[7]/div[2]/div[2]/button/div[1]/span"));
		Thread.sleep(3000);	

		String mentalStatusText = mentalStatus.getText();
		String mentalStatusVerify = tcData.get("Label8");
		softAssert.assertEquals(mentalStatusText,mentalStatusVerify);

		logger = extent.createTest("VerifyDataUpdateMorseFallScale_TC_10");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyDataUpdateMorseFallScale_TC_10): Verify 'Mental status ...' field data in 'Morse Fall Scale' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Mental status ...' data in 'Morse Fall Scale' module is same as input value given for 'Mental status ...' field from xls.",ExtentColor.GREEN));  

		softAssert.assertAll();

	}



	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
