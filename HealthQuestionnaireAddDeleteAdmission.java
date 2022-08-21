package com.alexiageriatrics.functionality;


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

public class HealthQuestionnaireAddDeleteAdmission extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public HealthQuestionnaireAddDeleteAdmission() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("PatientAcknowledgement");
	}


	@Test(priority=1,enabled=true)
	public void verifyAddDeleteAdmission() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifyAddDeleteAdmission_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddDeleteAdmission_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifyAddDeleteAdmission_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddDeleteAdmission_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifyAddDeleteAdmission_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddDeleteAdmission_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement healthQuestionnaire = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		healthQuestionnaire.click();
		Thread.sleep(3000);	

		WebElement yearOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year'])[1]"));
		Select yearValue = new Select(yearOpen);
		yearValue.selectByValue("1979");
		Thread.sleep(3000);

		WebElement illnessOperationOpen= driver.findElement(By.xpath("(//select[@formcontrolname='illness_or_operation'])[1]"));
		Select illnessOperationValue = new Select(illnessOperationOpen);
		illnessOperationValue.selectByValue("1");
		Thread.sleep(3000);

		WebElement addNewAdmission1 = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[2]"));
		addNewAdmission1.click();
		Thread.sleep(3000);	

		WebElement yearNewAdmissionOpen1= driver.findElement(By.xpath("(//select[@formcontrolname='year'])[2]"));
		Select yearNewAdmission1Value = new Select(yearNewAdmissionOpen1);
		yearNewAdmission1Value.selectByValue("1979");
		Thread.sleep(3000);

		WebElement illnessOperationOpen1= driver.findElement(By.xpath("(//select[@formcontrolname='illness_or_operation'])[2]"));
		Select illnessOperationOpen1Value = new Select(illnessOperationOpen1);
		illnessOperationOpen1Value.selectByValue("1");
		Thread.sleep(3000);

		WebElement addNewAdmission2 = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[2]"));
		addNewAdmission2.click();
		Thread.sleep(3000);	

		WebElement yearNewAdmission2Open= driver.findElement(By.xpath("(//select[@formcontrolname='year'])[3]"));
		Select yearNewAdmission2Value = new Select(yearNewAdmission2Open);
		yearNewAdmission2Value.selectByValue("1979");
		Thread.sleep(3000);

		WebElement illnessOperationNewAdmission2Open= driver.findElement(By.xpath("(//select[@formcontrolname='illness_or_operation'])[3]"));
		Select illnessOperationNewAdmission2Value = new Select(illnessOperationNewAdmission2Open);
		illnessOperationNewAdmission2Value.selectByValue("1");
		Thread.sleep(3000);

		WebElement addNewAdmission3 = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[2]"));
		addNewAdmission3.click();
		Thread.sleep(3000);	

		WebElement yearNewAdmission3Open= driver.findElement(By.xpath("(//select[@formcontrolname='year'])[4]"));
		Select yearNewAdmission3Value = new Select(yearNewAdmission3Open);
		yearNewAdmission3Value.selectByValue("1979");
		Thread.sleep(3000);

		WebElement illnessOperationNewAdmission3Open= driver.findElement(By.xpath("(//select[@formcontrolname='illness_or_operation'])[4]"));
		Select illnessOperationNewAdmission3Value = new Select(illnessOperationNewAdmission3Open);
		illnessOperationNewAdmission3Value.selectByValue("1");
		Thread.sleep(3000);

		WebElement addNewAdmission4 = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[2]"));
		addNewAdmission4.click();
		Thread.sleep(3000);	

		WebElement yearNewAdmission4Open= driver.findElement(By.xpath("(//select[@formcontrolname='year'])[5]"));
		Select yearNewAdmission4Value = new Select(yearNewAdmission4Open);
		yearNewAdmission4Value.selectByValue("1979");
		Thread.sleep(3000);

		WebElement illnessOperationNewAdmission4Open= driver.findElement(By.xpath("(//select[@formcontrolname='illness_or_operation'])[5]"));
		Select illnessOperationNewAdmission4Value = new Select(illnessOperationNewAdmission4Open);
		illnessOperationNewAdmission4Value.selectByValue("1");
		Thread.sleep(3000);


		WebElement deleteAdmission1 = driver.findElement(By.xpath("//span[@class='bi bi-trash-fill text-danger cursor-pointer'][1]"));
		deleteAdmission1.click();
		Thread.sleep(3000);	

		WebElement deleteAdmission2 = driver.findElement(By.xpath("//span[@class='bi bi-trash-fill text-danger cursor-pointer'][1]"));
		deleteAdmission2.click();
		Thread.sleep(3000);	

		WebElement deleteAdmission3 = driver.findElement(By.xpath("//span[@class='bi bi-trash-fill text-danger cursor-pointer'][1]"));
		deleteAdmission3.click();
		Thread.sleep(3000);	

		WebElement deleteAdmission4 = driver.findElement(By.xpath("//span[@class='bi bi-trash-fill text-danger cursor-pointer'][1]"));
		deleteAdmission4.click();
		Thread.sleep(3000);	

		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	

	}

	@Test(priority=2)
	public void verifyDeleteAdmission() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		Thread.sleep(5000);	

		WebElement healthQuestionnaire = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		healthQuestionnaire.click();
		Thread.sleep(3000);	

		try{
			driver.findElement(By.xpath("//span[@class='bi bi-trash-fill text-danger cursor-pointer'][1]")).isDisplayed(); //your element here
			System.out.println("Add and Delete Admission functionality is not working as expected");

		}catch(Exception e){
			System.out.println("Add and Delete Admission functionality is working as expected");
		}
	}


	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
