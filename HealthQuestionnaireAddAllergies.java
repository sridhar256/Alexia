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

public class HealthQuestionnaireAddAllergies extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public HealthQuestionnaireAddAllergies() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("AddAllergies");
	}


	@Test(priority=1, enabled =true)
	public void selectAllAllergies() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("SelectAllAllergies_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(SelectAllAllergies_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("SelectAllAllergies_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(SelectAllAllergies_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("SelectAllAllergies_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(SelectAllAllergies_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement healthQuestionnaire = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		healthQuestionnaire.click();
		Thread.sleep(3000);	

		WebElement AddButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		js.executeScript("arguments[0].scrollIntoView();", AddButton);
		Thread.sleep(3000);	

		WebElement selectAllergies = driver.findElement(By.xpath("(//span[@class='dropdown-multiselect__caret'])[2]"));
		selectAllergies.click();
		Thread.sleep(3000);	

		WebElement selectAllAllergies = driver.findElement(By.xpath("(//ng-multiselect-dropdown[@formcontrolname='HQ_allergies']/div/div[2]/ul/li[1])[1]"));
		if (!selectAllAllergies.isSelected()){
			System.out.println("Select All checkbox is selected");  
			js.executeScript("arguments[0].click();", selectAllAllergies);
		}
		else {
			System.out.println("Select All checkbox is not selected");
		}
		Thread.sleep(3000);	

		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	
	}
	
	
	@Test(priority=2, enabled =true)
	public void addAllergies() throws Exception {

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

		WebElement AddButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		js.executeScript("arguments[0].scrollIntoView();", AddButton);
		Thread.sleep(3000);	

		WebElement addAllergies = driver.findElement(By.xpath("//input[@placeholder = 'Add allergies']"));
		addAllergies.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);

		js.executeScript("arguments[0].click();", AddButton);
		Thread.sleep(3000);	

		WebElement okButton = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		js.executeScript("arguments[0].click();", okButton);
		Thread.sleep(3000);	

		WebElement selectAllAllergiesAgain = driver.findElement(By.xpath("(//ng-multiselect-dropdown[@formcontrolname='HQ_allergies']/div/div[2]/ul/li[1])[1]"));
		js.executeScript("arguments[0].click();", selectAllAllergiesAgain);
		Thread.sleep(3000);	

		WebElement selectAllergiesAgain = driver.findElement(By.xpath("(//span[@class='dropdown-multiselect__caret'])[2]"));
		selectAllergiesAgain.click();
		Thread.sleep(3000);	

		WebElement search = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[2]/ul[1]/li[2]/input"));
		search.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);

		WebElement selectAllergy = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[2]/ul[2]/li[1]"));
		js.executeScript("arguments[0].click();", selectAllergy);
		Thread.sleep(3000);	

		WebElement updateAgain = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		updateAgain.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopupAgain = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopupAgain.click();
		Thread.sleep(3000);	

		WebElement healthQuestionnaire2 = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		healthQuestionnaire2.click();
		Thread.sleep(3000);	

		js.executeScript("arguments[0].scrollIntoView();", AddButton);
		Thread.sleep(3000);	

	}
	
	
	@Test(priority=3, enabled =true)
	public void checkAddedAllergies() throws Exception {

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

		WebElement AddButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		js.executeScript("arguments[0].scrollIntoView();", AddButton);
		Thread.sleep(3000);	

		WebElement checkAllergy = driver.findElement(By.xpath("(//div[@class='multiselect-dropdown'])[2]/div[1]/span/span[1]/span/span"));
		System.out.println(checkAllergy.getText());
		Thread.sleep(3000);	

	}


	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
