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

public class ClickAllTabsLeftPanelRightPanel extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public ClickAllTabsLeftPanelRightPanel() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("PatientAcknowledgement");
	}


	@Test(priority=1)
	public void verifyClickonAllTabsLeftAndRightPanels() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifyClickonAllTabsLeftAndRightPanels_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyClickonAllTabsLeftAndRightPanels_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifyClickonAllTabsLeftAndRightPanels_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyClickonAllTabsLeftAndRightPanels_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifyClickonAllTabsLeftAndRightPanels_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyClickonAllTabsLeftAndRightPanels_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement patientAcknowledgementRightPanel = driver.findElement(By.xpath("//div[@id='patient-acknowledgement']/div/h4"));
		patientAcknowledgementRightPanel.click();
		Thread.sleep(3000);	
		
		WebElement patientInformationRightPanel = driver.findElement(By.xpath("//div[@id='patient-information']/div/h4"));
		patientInformationRightPanel.click();
		Thread.sleep(3000);	
		
		WebElement medicalRecordsReleaseFormRightPanel = driver.findElement(By.xpath("//div[@id='release-form']/div/h4"));
		medicalRecordsReleaseFormRightPanel.click();
		Thread.sleep(3000);
		
		WebElement healthQuestionnaireRightPanel = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		healthQuestionnaireRightPanel.click();
		Thread.sleep(3000);	
		
		WebElement patientHealthQuestionnaireRightPanel = driver.findElement(By.xpath("//div[@id='phq']/div/h4"));
		js.executeScript("arguments[0].scrollIntoView();", patientHealthQuestionnaireRightPanel);
		patientHealthQuestionnaireRightPanel.click();
		Thread.sleep(3000);	
		
		WebElement morseFallScaleRightPanel = driver.findElement(By.xpath("//div[@id='mfs']/div/h4"));
		js.executeScript("arguments[0].scrollIntoView();", morseFallScaleRightPanel);
		morseFallScaleRightPanel.click();
		Thread.sleep(3000);	
		
		WebElement champsActivitiesRightPanel = driver.findElement(By.xpath("//div[@id='champs']/div/h4"));
		champsActivitiesRightPanel.click();
		Thread.sleep(5000);	
		
		WebElement collapseAll = driver.findElement(By.xpath("//button[@aria-controls='collapseExample'][2]"));
		collapseAll.click();
		Thread.sleep(3000);	
		
		WebElement patientAcknowledgementLeftPanel = driver.findElement(By.xpath("//span[contains(text(),'Patient Acknowledgement')]"));
		patientAcknowledgementLeftPanel.click();
		Thread.sleep(3000);	
		
		WebElement patientInformationLeftPanel = driver.findElement(By.xpath("//span[contains(text(),'Patient Information')]"));
		patientInformationLeftPanel.click();
		Thread.sleep(3000);	
		
		WebElement medicalRecordsReleaseFormLeftPanel = driver.findElement(By.xpath("//span[contains(text(),'Medical Records Release Form')]"));
		medicalRecordsReleaseFormLeftPanel.click();
		Thread.sleep(3000);
		
		WebElement GeriatricsLeftPanel = driver.findElement(By.xpath("//span[contains(text(),'Geriatrics')]"));
		GeriatricsLeftPanel.click();
		Thread.sleep(3000);
		
		WebElement healthQuestionnaireLeftPanel = driver.findElement(By.xpath("//span[contains(text(),'Health Questionnaire')]"));
		healthQuestionnaireLeftPanel.click();
		Thread.sleep(3000);	
		
		WebElement patientHealthQuestionnaireLeftPanel = driver.findElement(By.xpath("//span[contains(text(),'Patient Health Questionnaire')]"));
		patientHealthQuestionnaireLeftPanel.click();
		Thread.sleep(3000);	
		
		WebElement morseFallScaleLeftPanel = driver.findElement(By.xpath("//span[contains(text(),'Morse Fall Scale (Adapted with permission, SAGE Publications)')]"));
		morseFallScaleLeftPanel.click();
		Thread.sleep(3000);	
		
		WebElement champsActivitiesLeftPanel = driver.findElement(By.xpath("//span[contains(text(),'CHAMPS Activities Questionnaire for Older Adults')]"));
		champsActivitiesLeftPanel.click();
		Thread.sleep(5000);	
		
		WebElement logOut = driver.findElement(By.xpath("//a[@title='Logout']"));
		//logOut.click();
		Thread.sleep(3000);	
	}


	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}


}
